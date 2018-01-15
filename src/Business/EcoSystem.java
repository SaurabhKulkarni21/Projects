/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.BudgetData.BudgetDirectory;
import Business.Enterprise.Enterprise;
import Business.Enterprise.EnterpriseDirectory;
import Business.Network.Network;
import Business.Organization.OrganizationDirectory;
import Business.Role.Role;
import Business.Role.SystemAdminRole;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 *
 *
 */
public class EcoSystem extends Enterprise {

    private CSVUtil csvUtil;
    private static EcoSystem business;
    private ArrayList<Network> networkList;
    private BudgetDirectory budgetDirectory;
    private EnterpriseDirectory enterpriseDirectory;
    private OrganizationDirectory organizationDirectory;
//    private EmployeeDirectory employeeDirectory;
//    private UserAccountDirectory userAccountDirectory;
//    private WorkQueue workQueue;

    public static EcoSystem getInstance() {
        if (business == null) {
            business = new EcoSystem();
        }
        return business;
    }

    private EcoSystem() {
        super(null, null);
        networkList = new ArrayList<>();
        csvUtil = new CSVUtil();
        budgetDirectory = new BudgetDirectory();
        enterpriseDirectory = new EnterpriseDirectory();
        organizationDirectory =  new OrganizationDirectory();
//        employeeDirectory = new EmployeeDirectory();
 //      userAccountDirectory = new UserAccountDirectory();
//        workQueue = new WorkQueue();

    }

    public ArrayList<Network> getNetworkList() {
        return networkList;
    }

    public Network createAndAddNetwork() {
        Network network = new Network();
        networkList.add(network);
        return network;
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(new SystemAdminRole());
        return roleList;
    }

    public boolean checkIfUsernameIsUnique(String username) {

        if (!this.getUserAccountDirectory().checkIfUsernameIsUnique(username)) {
            return false;
        }
        return true;
    }

    /**
     * @return the csvUtil
     */
    public CSVUtil getCsvUtil() {
        return csvUtil;
    }

    /**
     * @param csvUtil the csvUtil to set
     */
    public void setCsvUtil(CSVUtil csvUtil) {
        this.csvUtil = csvUtil;
    }
    

    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

//   
//    public WorkQueue getWorkQueue() {
//        return workQueue;
//    }
//
//    public void setWorkQueue(WorkQueue workQueue) {
//        this.workQueue = workQueue;
//    }

    public BudgetDirectory getBudgetDirectory() {
        return budgetDirectory;
    }

    public void setBudgetDirectory(BudgetDirectory budgetDirectory) {
        this.budgetDirectory = budgetDirectory;
    }

    public OrganizationDirectory getOrganizationDirectory() {
        return organizationDirectory;
    }

    public void setOrganizationDirectory(OrganizationDirectory organizationDirectory) {
        this.organizationDirectory = organizationDirectory;
    }

  

    
}
