/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.BudgetData.Budget;
import Business.Employee.EmployeeDirectory;
import Business.Events.Event;
import Business.Events.EventDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkRequest.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public abstract class Organization {
    
    private String name;
    private Budget budget; 
    private WorkQueue workQueue;
    private EmployeeDirectory employeeDirecctory;
    private UserAccountDirectory userAccDir;
    private EventDirectory eventDirectory;
     private int organizationID;
    private static int counter;
    
    public Organization(String name){
        this.name = name;
        this.budget = new Budget();
        workQueue = new WorkQueue();
        this.employeeDirecctory = new EmployeeDirectory();
        this.userAccDir = new UserAccountDirectory();
        this.eventDirectory = new EventDirectory();
        organizationID = counter;
        ++counter;
    }

        
    public enum OrganizationType{
        HealthCare("HealthCare"), 
        Education("Education"), 
        Tourism("Tourism"), 
        Automobile("Automobile"), 
        Infrastructure("Infrastructure"), 
        Industries("Industries");
        
        private String value;
        private OrganizationType(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }
    
    }

   
    public abstract ArrayList<Role> getSupportedRole();
    

    public int getOrganizationID() {
        return organizationID;
    }

    /**
     *
     * @param event
     */
    public void setOrganizationID(int organizationID) {
        this.organizationID = organizationID;
    }

    public EmployeeDirectory getEmployeeDirecctory() {
        return employeeDirecctory;
    }

    public void setEmployeeDirecctory(EmployeeDirectory employeeDirecctory) {
        this.employeeDirecctory = employeeDirecctory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }

 
    /**
     * @return the userAccDir
     */
    public UserAccountDirectory getUserAccDir() {
        return userAccDir;
    }

    /**
     * @param userAccDir the userAccDir to set
     */
    public void setUserAccDir(UserAccountDirectory userAccDir) {
        this.userAccDir = userAccDir;
    }

    /**
     * @return the eventDirectory
     */
    public EventDirectory getEventDirectory() {
        return eventDirectory;
    }

    /**
     * @param eventDirectory the eventDirectory to set
     */
    public void setEventDirectory(EventDirectory eventDirectory) {
        this.eventDirectory = eventDirectory;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param orgName the name to set
     */
    public void setName(String Name) {
        this.name = Name;
    }

    @Override
    public String toString() {
        return name;
    }
}
