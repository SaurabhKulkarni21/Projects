/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public class WorkQueue {
    private ArrayList<WorkRequest> workRequestlist;
    
    public WorkQueue(){
        this.workRequestlist = new ArrayList<>();
    }

    /**
     * @return the workRequestlist
     */
    public ArrayList<WorkRequest> getWorkRequestlist() {
        return workRequestlist;
    }

    /**
     * @param workRequestlist the workRequestlist to set
     */
    public void setWorkRequestlist(ArrayList<WorkRequest> workRequestlist) {
        this.workRequestlist = workRequestlist;
    }
}
