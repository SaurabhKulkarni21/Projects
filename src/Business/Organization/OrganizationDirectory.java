/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Organization;

import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public class OrganizationDirectory {
    
    private ArrayList<Organization> organisationDirectory;
    
    public OrganizationDirectory(){
        this.organisationDirectory = new ArrayList<>();
    }

    /**
     * @return the organisationDirectory
     */
    public ArrayList<Organization> getOrganisationList() {
        return organisationDirectory;
    }

    /**
     * @param organisationList the organisationDirectory to set
     */
    public void setOrganisationList(ArrayList<Organization> organisationList) {
        this.organisationDirectory = organisationList;
    }
    
      public Organization createOrganization(Organization.OrganizationType type){
        Organization organization = null;
        if (type.getValue().equals(Organization.OrganizationType.HealthCare.getValue())){
            organization = new HealthCareOrganisation();
            organisationDirectory.add(organization);
        }
        else if (type.getValue().equals(Organization.OrganizationType.Education.getValue())){
            organization = new EducationOrganisation();
            organisationDirectory.add(organization);
        }  else if (type.getValue().equals(Organization.OrganizationType.Industries.getValue())){
            organization = new IndustriesOrganisation();
            organisationDirectory.add(organization);
        }  else if (type.getValue().equals(Organization.OrganizationType.Infrastructure.getValue())){
            organization = new InfrastructureOrganisation();
            organisationDirectory.add(organization);
        }  else if (type.getValue().equals(Organization.OrganizationType.Automobile.getValue())){
            organization = new AutomobileOrganisation();
            organisationDirectory.add(organization);
        }  else if (type.getValue().equals(Organization.OrganizationType.Tourism.getValue())){
            organization = new TourismOrganisation();
            organisationDirectory.add(organization);
        }
        return organization;
    }

}
