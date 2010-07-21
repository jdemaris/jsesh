/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.qenherkhopeshef.guiFramework.swingworker;

import javax.swing.SwingUtilities;

/**
 * Adaptation of the old Swing Worker to our framework.
 * Works in java 1.4.
 * @author rosmord
 */
abstract public class QenherSwingWorker extends SwingWorker{
    private WorkerListener workerListener;

    public void finished() {
        if (workerListener != null)
            workerListener.finished(this);
    }

    /**
     * Notify <em>On the EDT</em> the workerlistener of this Worker's advance,
     * by calling the listener's own update method.
     * Note that the updateData should be thread safe: either a copy of original data,
     * or synchronized.
     */
    public void update(Object updateData) {
        if (workerListener != null)
            SwingUtilities.invokeLater(new UpdateRunnable(updateData));
    }

    public void setWorkerListener(WorkerListener workerListener) {
        this.workerListener = workerListener;
    }

    public WorkerListener getWorkerListener() {
        return workerListener;
    }

    private class UpdateRunnable implements Runnable{
        Object data;

        public UpdateRunnable(Object data) {
            this.data = data;
        }
        
        public void run() {
            workerListener.update(data);
        }
        
    }

}