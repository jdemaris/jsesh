/*
Copyright Serge Rosmorduc
contributor(s) : Serge J. P. Thomas for the fonts
serge.rosmorduc@qenherkhopeshef.org

This software is a computer program whose purpose is to edit ancient egyptian hieroglyphic texts.

This software is governed by the CeCILL license under French law and
abiding by the rules of distribution of free software.  You can  use, 
modify and/ or redistribute the software under the terms of the CeCILL
license as circulated by CEA, CNRS and INRIA at the following URL
"http://www.cecill.info". 

As a counterpart to the access to the source code and  rights to copy,
modify and redistribute granted by the license, users are provided only
with a limited warranty  and the software's author,  the holder of the
economic rights,  and the successive licensors  have only  limited
liability. 

In this respect, the user's attention is drawn to the risks associated
with loading,  using,  modifying and/or developing or reproducing the
software by the user in light of its specific status of free software,
that may mean  that it is complicated to manipulate,  and  that  also
therefore means  that it is reserved for developers  and  experienced
professionals having in-depth computer knowledge. Users are therefore
encouraged to load and test the software's suitability as regards their
requirements in conditions enabling the security of their systems and/or 
data to be ensured and,  more generally, to use and operate it in the 
same conditions as regards security. 

The fact that you are presently reading this means that you have had
knowledge of the CeCILL license and that you accept its terms.
 */
/*
 * Created on 21 fevr. 2005 by rosmord
 */
package jsesh.mdcDisplayer.layout;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

import jsesh.mdcDisplayer.mdcView.MDCView;

/**
 * Zones are places where views will be added. 
 * In fact, they are used to keep track of a line or a column's size and content.
 *
 * Basically, a zone has a certain size, contains a number of views (with a position), 
 * and holds an "insertion" point where new views would be placed. The zone itself is rather stupid,
 * and moving the insertion point, for instance, is the responsability of the class' user. 
 * 
 * <p align="center">
 * 	<img src="../../../images/zone.png">
 * </p>
 * 
 * Zones have been much simplified comparatively with earlier versions.
 * @author rosmord
 */
public class Zone {

    /**
     * Current insertion position for views in zone.
     */
    private Point2D.Double currentPoint;
    
    private Rectangle2D zoneArea;
    
    private ArrayList<MDCView> views;

    /**
     * build a new zone. 
     * @param minWidth
     * @param minHeight
     */
    public Zone(double minWidth, double minHeight) {        
        currentPoint= new Point2D.Double();
        zoneArea= new Rectangle2D.Double(0f,0f,minWidth, minHeight);
        views= new ArrayList<MDCView>();
    }
    
    /**
     * Add a view's bounding box to the current zone.
     * All the parameters for this view should be set. In particular, <em>both</em> the startPoint and the nextViewPosition 
     * should have their values. These values will be relative to the zone's first point, and all views in the zone will be translated when the zone is finally added 
     * to the document.
     * @param view : the view to add.
     */
    public void add(MDCView view) {
    	// Sets the view position
    	view.getPosition().setLocation(currentPoint.x + view.getDeltaBaseX(), currentPoint.y + view.getDeltaBaseY());
        // Update the zone size
        zoneArea.add(new Rectangle2D.Double(view.getPosition().x,
               view.getPosition().y, view.getWidth(),
                view.getHeight()));
        views.add(view);
    }
    
    /**
     * Computes the size the zone would be if a given view was added to it.
     * Does not actually add the view.
     * @param view
     * @return the size the zone would be if it included the view.
     */
    public Rectangle2D computeNewSizeWith (MDCView view) {
    	Rectangle2D newArea= (Rectangle2D) zoneArea.clone();
    	// computes the view position
        double x= currentPoint.x + view.getDeltaBaseX();
        double y= currentPoint.y + view.getDeltaBaseY();
    	// Update the zone size
        newArea.add(new Rectangle2D.Double(x,
               y, view.getWidth(),
                view.getHeight()));
        return newArea;
    }
    
    public double getWidth() {
        return zoneArea.getWidth();
    }
    
    public double getHeight() {
        return zoneArea.getHeight();
    }

    /**
     * @return true if zone is empty.
     */
    public boolean isEmpty() {
        return this.zoneArea.isEmpty();
    }
    
    public double getMinY() {
        return zoneArea.getMinY();
    }
    
    public double getMinX() {
        return zoneArea.getMinX();
    }
    
    public double getMaxX() {
    	return zoneArea.getMaxX();
    }

	/**
	 * @return
	 */
	public Point2D getCurrentPoint() {
		return currentPoint;
	}

	/**
	 * @param dx
	 * @param dy
	 */
	public void moveCurrentPoint(double dx, double dy) {
		currentPoint.setLocation(currentPoint.x+dx, currentPoint.y+dy);
	}

	/**
	 * Translates all views in a zone by a certain amount.
	 * @param zoneStart
	 */
	public void translateBy(Point2D zoneStart) {
		for (int i=0; i< views.size(); i++) {
			MDCView v= (MDCView) views.get(i);
			v.getPosition().x+= zoneStart.getX();
			v.getPosition().y+= zoneStart.getY();
		}
	}
 
}
