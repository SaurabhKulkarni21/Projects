/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.BudgetData;

import java.util.ArrayList;

/**
 *
 * @author amaha
 */
public class BudgetDirectory {
        private ArrayList<Budget> budgetList;
    
    public BudgetDirectory(){
        this.budgetList = new ArrayList<>();
    }

    public ArrayList<Budget> getBudgetList() {
        return budgetList;
    }

    public void setBudgetList(ArrayList<Budget> budgetList) {
        this.budgetList = budgetList;
    }
    
     public Budget addBudget()
    {
        Budget bd = new Budget();
        budgetList.add(bd);
        return bd;
    }
    
        
    public void deleteBudget(Budget bd){
        budgetList.remove(bd);
    }
    
    public Budget searchAirliner(int year){
        for(Budget bd: budgetList){
            if(bd.getBudgetYear()==(year)){
                return bd;
            }
        }
        return null;
    }
        
}
