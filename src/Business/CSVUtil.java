/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import Business.BudgetData.Budget;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import Business.Events.Event;
/**
 *
 * @author Abhinav
 */
public class CSVUtil {
    
    private ArrayList<Budget> previousBudgetlist;
    private ArrayList<Event> eventList;

    public CSVUtil() {
        this.previousBudgetlist = new ArrayList<>();
        this.eventList = new ArrayList<>();
    }

    
    
    public void loadBudgetFromCSV() throws FileNotFoundException, ParseException{    
        String csvFile = "./src/CSV/Budget.csv";
        String cvsSplitBy = ",";
        File file = new File(csvFile);
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()){
            String data[]=scanner.nextLine().split(cvsSplitBy);
            Budget budget = new Budget();
            budget.setOrgName(data[0]);
            budget.setBudgetYear(Integer.parseInt(data[1]));
            budget.setOrgBudget(Integer.parseInt(data[2]));
            budget.setOrgAdditionalBudget(Integer.parseInt(data[3]));
            budget.setBudgetUsed(Integer.parseInt(data[4]));
            
            
            previousBudgetlist.add(budget);
            setPreviousBudgetlist(previousBudgetlist);
            //
        }
        scanner.close();
        System.out.println("budget list size: "+getPreviousBudgetlist().size());
 }

    /**
     * @return the previousBudgetlist
     */
    public ArrayList<Budget> getPreviousBudgetlist() {
        return previousBudgetlist;
    }

    /**
     * @param previousBudgetlist the previousBudgetlist to set
     */
    public void setPreviousBudgetlist(ArrayList<Budget> previousBudgetlist) {
        this.previousBudgetlist = previousBudgetlist;
    }
    
    
//    public void loadEventsFromCSV() throws FileNotFoundException, ParseException{    
//        String csvFile = "./src/CSV/Events.csv";
//        String cvsSplitBy = ",";
//        File file = new File(csvFile);
//        Scanner scanner = new Scanner(file);
//        while(scanner.hasNextLine()){
//            String data[]=scanner.nextLine().split(cvsSplitBy);
//            Event events = new Event();
//            events.setOrganisationOfEvent(data[0]);
//            events.setEventID(Integer.parseInt(data[1]));
//            events.setEventName(data[2]);
//            events.setEventBudget(Integer.parseInt(data[3]));
//            
//            
//            
//            eventList.add(events);
//            setEventList(eventList);
//            
//        }
//        scanner.close();
//        System.out.println("event list size: "+getEventList().size());
// }

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
