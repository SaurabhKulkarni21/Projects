/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Network;

import Business.Enterprise.EnterpriseDirectory;
import Business.UserAccount.UserAccountDirectory;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public class Network {

    private String name;
    private EnterpriseDirectory enterpriseDirectory;
    private UserAccountDirectory userAccountDirectory;

    public Network() {
        this.enterpriseDirectory = new EnterpriseDirectory();
        this.userAccountDirectory = new UserAccountDirectory();
    }

    /**
     * @return the enterpriseDirectorylist
     */
    public EnterpriseDirectory getEnterpriseDirectory() {
        return enterpriseDirectory;
    }

    /**
     * @param enterpriseDirectorylist the enterpriseDirectorylist to set
     */
    public void setEnterpriseDirectory(EnterpriseDirectory enterpriseDirectory) {
        this.enterpriseDirectory = enterpriseDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public void setUserAccountDirectory(UserAccountDirectory userAccountDirectory) {
        this.userAccountDirectory = userAccountDirectory;
    }
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

}
