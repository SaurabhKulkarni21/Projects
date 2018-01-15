/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import Business.Role.Role;
import Business.Role.TourismAdmin;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public class TourismOrganisation extends Organization{
    
    public TourismOrganisation(){
        super(OrganizationType.Tourism.getValue());
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new TourismAdmin());
        return roles;
    }
    
}
