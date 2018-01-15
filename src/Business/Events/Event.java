/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Events;

/**
 *
 * @author Abhinav
 */
public class Event {
    
    private int eventID;
    private String eventName;
    private String organisationOfEvent;
    private double eventBudget;
    private String eventOutcome;

    /**
     * @return the eventID
     */
    public int getEventID() {
        return eventID;
    }

    /**
     * @param eventID the eventID to set
     */
    public void setEventID(int eventID) {
        this.eventID = eventID;
    }

    /**
     * @return the eventName
     */
    public String getEventName() {
        return eventName;
    }

    /**
     * @param eventName the eventName to set
     */
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    /**
     * @return the organisationOfEvent
     */
    public String getOrganisationOfEvent() {
        return organisationOfEvent;
    }

    /**
     * @param organisationOfEvent the organisationOfEvent to set
     */
    public void setOrganisationOfEvent(String organisationOfEvent) {
        this.organisationOfEvent = organisationOfEvent;
    }

    /**
     * @return the eventBudget
     */
    public double getEventBudget() {
        return eventBudget;
    }

    /**
     * @param eventBudget the eventBudget to set
     */
    public void setEventBudget(double eventBudget) {
        this.eventBudget = eventBudget;
    }

    /**
     * @return the eventOutcome
     */
    public String getEventOutcome() {
        return eventOutcome;
    }

    /**
     * @param eventOutcome the eventOutcome to set
     */
    public void setEventOutcome(String eventOutcome) {
        this.eventOutcome = eventOutcome;
    }
    
    
    
}
