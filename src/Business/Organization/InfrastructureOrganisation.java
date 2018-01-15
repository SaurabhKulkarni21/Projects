/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.InfrastructureAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public class InfrastructureOrganisation extends Organization{
    
    public InfrastructureOrganisation(){
        super(OrganizationType.Infrastructure.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new InfrastructureAdmin());
        return roles;
    }
    
}
