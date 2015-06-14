package ru.test.market.model;

import java.util.LinkedList;
import java.util.List;

public class CashBox 
{
    private int num;
    
    private final int performance;
    private final List<Customer> customers = new LinkedList<>(); 
    
    private int doneCustomers = 0;
    private int doneGoods = 0;

    public CashBox(int num,int performance) 
    {
        this.num = num;
        this.performance = performance;
    }  
    
    public int getNum()
    {
        return num;
    }
    
    public int getPerfomance()
    {
        return performance;
    }

    public int getDoneCustomers() {
        return doneCustomers;
    }

    public int getDoneGoods() {
        return doneGoods;
    }      
    
    public int getCustomersQty()
    {
        return customers.size();
    }

    public List<Customer> getCustomers() {
        return customers;
    }    
    
    public int getQueueSteps()
    {
        int steps = 0;
        
        for (Customer c: customers)
        {
            steps += c.getGoodsQty()/performance;
            steps += c.getGoodsQty()%performance > 0 ? 1 : 0;
        }
        
        return steps;
    }
    
    public void addCustomerToQueue(Customer c)
    {
        customers.add(c);
    }
            
    public void doStep()
    {
        if ( !customers.isEmpty() )
        {         
            int newGoodsQty = customers.get(0).getGoodsQty() - performance;
            customers.get(0).setGoodsQty(newGoodsQty);
            doneGoods += performance;
            
            if ( customers.get(0).getGoodsQty() <= 0 )
            {                
                doneCustomers++;
                doneGoods += customers.get(0).getGoodsQty();
                customers.remove(0);                
            }                                
        }        
    } 

}
