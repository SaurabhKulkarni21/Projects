/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Enterprise;

import Business.Employee.EmployeeDirectory;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */


public class EnterpriseDirectory {
    private ArrayList<Enterprise> enterpriseList;
   
  
    

    public EnterpriseDirectory(){
        this.enterpriseList = new ArrayList<>();
    }

    /**
     * @return the enterpriseList
     */
    public ArrayList<Enterprise> getEnterpriseList() {
        return enterpriseList;
    }

    /**
     * @param enterpriseList the enterpriseList to set
     */
    public void setEnterpriseList(ArrayList<Enterprise> enterpriseList) {
        this.enterpriseList = enterpriseList;
    }
    
    public Enterprise createAndAddEnterprise(String name, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
      
        
        if (type == Enterprise.EnterpriseType.GoGreenEnterprise){
            enterprise = new GoGreenEnterprise(name);
            enterpriseList.add(enterprise);
        }
        if (type == Enterprise.EnterpriseType.BudgetingEnterprise){
            enterprise = new BudgetingEnterprise(name);
            enterpriseList.add(enterprise);
        }
        return enterprise;
    }
    
    
}
