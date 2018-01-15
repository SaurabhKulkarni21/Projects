/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.EmployeeDirectory;
import Business.Enterprise.Enterprise.EnterpriseType;
import Business.Organization.Organization;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkRequest.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public abstract class Enterprise extends Organization{
    
   private int totalBudget;
   private OrganizationDirectory organisationDirectory;
   private EmployeeDirectory employeeDirectory;
   private UserAccountDirectory userAccountDirectory;
   private WorkQueue workQueue;
   private EnterpriseType enterpriseType;
  // private String name;
   
   
   public Enterprise(String name, EnterpriseType type){
       super(name);
       this.organisationDirectory = new OrganizationDirectory();
       this.employeeDirectory = new EmployeeDirectory();
       this.userAccountDirectory = new UserAccountDirectory();
       this.workQueue = new WorkQueue();
        this.enterpriseType = type;
       // this.name = name;
   }
    public enum EnterpriseType{
        BudgetingEnterprise("BudgetingEnterprise"),GoGreenEnterprise("GoGreenEnterprise");
        private String value;

        private EnterpriseType(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }
    
    
    public abstract ArrayList<Role> getSupportedRole();
    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public void setEmployeeDirectory(EmployeeDirectory employeeDirectory) {
        this.employeeDirectory = employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }

    /**
     * @return the organisationDirectory
     */
    public OrganizationDirectory getOrganisationDirectory() {
        return organisationDirectory;
    }

    /**
     * @param organisationDirectory the organisationDirectory to set
     */
    public void setOrganisationDirectory(OrganizationDirectory organisationDirectory) {
        this.organisationDirectory = organisationDirectory;
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

    /**
     * @return the totalBudget
     */
    public int getTotalBudget() {
        return totalBudget;
    }

    /**
     * @param totalBudget the totalBudget to set
     */
    public void setTotalBudget(int totalBudget) {
        this.totalBudget = totalBudget;
    }

////    public String getName() {
////        return name;
////    }
////    
////   @Override
////    public String toString(){
////        return name;
////    }
////
////    public void setName(String name) {
////        this.name = name;
////    }
////    
    
    
}
