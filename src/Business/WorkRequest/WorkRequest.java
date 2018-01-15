/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkRequest;

import Business.BudgetData.Budget;
import Business.Role.Role;
import Business.UserAccount.UserAccount;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public class WorkRequest {

    private String message;
    private UserAccount sender;
    private Role.RoleType receiver;
    private String status;
    private ArrayList<Budget> budgetList;
    private String approvalStatus;

    
    
    public WorkRequest(){
        this.budgetList = new ArrayList<>();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccount getSender() {
        return sender;
    }

    public void setSender(UserAccount sender) {
        this.sender = sender;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the budgetList
     */
    public ArrayList<Budget> getBudgetList() {
        return budgetList;
    }

    /**
     * @param budgetList the budgetList to set
     */
    public void setBudgetList(ArrayList<Budget> budgetList) {
        this.budgetList = budgetList;
    }

    /**
     * @return the approvalStatus
     */
    public String getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * @param approvalStatus the approvalStatus to set
     */
    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    /**
     * @return the receiver
     */
    public Role.RoleType getReceiver() {
        return receiver;
    }

    /**
     * @param receiver the receiver to set
     */
    public void setReceiver(Role.RoleType receiver) {
        this.receiver = receiver;
    }

}
