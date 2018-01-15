/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.UserAccount;

import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Role.Role;
import Business.WorkRequest.WorkQueue;


/**
 *
 * @author Abhinav
 */
public class UserAccount {
    
    private String username;
    private String password;
    private Employee employee;
    private Enterprise enterprise;
    private Role role;
    private WorkQueue workQueue;
    
    public UserAccount(){
        this.employee = new Employee();
        this.workQueue = new WorkQueue();
        
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }
    
    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the workQueue
     */
    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    /**
     * @param workQueue the workQueue to set
     */
    public void setWorkQueue(WorkQueue workQueue) {
        this.workQueue = workQueue;
    }
    
    
        
    @Override
    public String toString() {
        return getUsername();
    }
}
