/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BudgetData;

import Business.Events.Event;
import java.util.ArrayList;

/**
 *
 * @author Abhinav
 */
public class Budget {
    
    private String orgName;
    private int orgBudget;
    private int orgAdditionalBudget;
    private int budgetYear;
    private int budgetUsed;
    private ArrayList<Event> eventList;
    

    
    public Budget(){
        this.eventList = new ArrayList<>();
    }

    /**
     * @return the orgName
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * @param orgName the orgName to set
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * @return the orgBudget
     */
    public int getOrgBudget() {
        return orgBudget;
    }

    /**
     * @param orgBudget the orgBudget to set
     */
    public void setOrgBudget(int orgBudget) {
        this.orgBudget = orgBudget;
    }

    /**
     * @return the orgAdditionalBudget
     */
    public int getOrgAdditionalBudget() {
        return orgAdditionalBudget;
    }

    /**
     * @param orgAdditionalBudget the orgAdditionalBudget to set
     */
    public void setOrgAdditionalBudget(int orgAdditionalBudget) {
        this.orgAdditionalBudget = orgAdditionalBudget;
    }

    /**
     * @return the budgetYear
     */
    public int getBudgetYear() {
        return budgetYear;
    }

    /**
     * @param budgetYear the budgetYear to set
     */
    public void setBudgetYear(int budgetYear) {
        this.budgetYear = budgetYear;
    }

    public int getBudgetUsed() {
        return budgetUsed;
    }

    public void setBudgetUsed(int budgetUsed) {
        this.budgetUsed = budgetUsed;
    }

    /**
     * @return the eventList
     */
    public ArrayList<Event> getEventList() {
        return eventList;
    }

    /**
     * @param eventList the eventList to set
     */
    public void setEventList(ArrayList<Event> eventList) {
        this.eventList = eventList;
    }
  
}
