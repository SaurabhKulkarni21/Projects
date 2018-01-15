/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Events;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Abhinav
 */
public class EventDirectory {
    private ArrayList<Event> eventList;
    
    public EventDirectory(){
        this.eventList = new ArrayList<>();
    }

    
    public void addEvents(Event event){
    	System.out.println("In add");
        getEventList().add(event);

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
    
    public void loadEventsFromCSV() throws FileNotFoundException, ParseException{    
        String csvFile = "./src/CSV/Events.csv";
        String cvsSplitBy = ",";
        File file = new File(csvFile);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String data[]=scanner.nextLine().split(cvsSplitBy);
            Event events = new Event();
            events.setOrganisationOfEvent(data[0]);
            events.setEventID(Integer.parseInt(data[1]));
            events.setEventName(data[2]);
            events.setEventBudget(Integer.parseInt(data[3]));
            events.setEventOutcome(data[4]);
            
            
            
            
            eventList.add(events);
            setEventList(eventList);
            
        }
        scanner.close();
        System.out.println("event list size: "+getEventList().size());
 }
    
    
    
}
