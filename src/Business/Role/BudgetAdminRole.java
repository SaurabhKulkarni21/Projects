/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.BudgetingEnterprise;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.BudgetAdminWorkArea.BudgetManagerAdminJpanel;
import javax.swing.JPanel;

/**
 *
 * @author Abhinav
 */
public class BudgetAdminRole extends Role{

        // Have to create a Jpanel named for Budget - BudgetAdminWorkAreaJPanel then we can un comment below method

    
 @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new BudgetManagerAdminJpanel(userProcessContainer, account, (BudgetingEnterprise)enterprise, business);
    }
    
    
}
