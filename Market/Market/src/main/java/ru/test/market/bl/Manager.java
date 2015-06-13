package ru.test.market.bl;

import java.util.ArrayList;
import java.util.List;
import ru.test.market.model.CashBox;
import ru.test.market.model.Customer;

public class Manager 
{
    private final int MAX_CASHBOX_PERFOMANCE = 10;
    
    private List<CashBox> cashList;      
    private Customer newCustomer;   
    
    
    public Manager(int cashBoxCount)
    {
        cashList = new ArrayList<>(cashBoxCount);       
        
        
        for (int i = 0; i < cashBoxCount; i++) 
        {
            cashList.add(new CashBox(i, (int)Math.round(Math.random()*(MAX_CASHBOX_PERFOMANCE-1))+1));
        }
    }
    
    public void doStep()
    {
        // новый покупатель
        Customer customer = createNewCustomer();
        
        // выбор очереди
        choseCashBox(customer);
        
        // делаем один шаг у всех касс
        for (CashBox cashBox : cashList)
        {
            cashBox.doStep();
        }
    }
    
    private Customer createNewCustomer()
    {        
        char type;
        int index = (int)Math.round(Math.random()*2);
        switch (index) 
        {
            case 0: 
                type = Customer.TYPE_CHILD;
                break;
            case 1:
                type = Customer.TYPE_MAN;
                break;
            case 2:
                type = Customer.TYPE_WOMAN;
                break;
            default:
                type = Customer.TYPE_MAN;                
        }   
        
        int perfomance = (int)Math.round(Math.random()*50);  
        
        if (newCustomer != null)
            newCustomer.setNewCustomer(false);
        
        newCustomer = new Customer(type, perfomance);
        return newCustomer;
    }

    private void choseCashBox(Customer customer) 
    {
        int index = 0;
        
        switch (customer.getType()) 
        {
            case Customer.TYPE_CHILD:
                index = getCashBoxIndexForChild();                    
                break;
            case Customer.TYPE_MAN:
                index = getCashBoxIndexForMan(customer.getGoodsQty());
                break;
            case Customer.TYPE_WOMAN:
                index = getCashBoxIndexForWoman();
                break;
        }         
        cashList.get(index).addCustomerToQueue(customer);
    }
    
    int getCashBoxIndexForChild()
    {
        return (int)Math.round(Math.random()*(cashList.size()-1));
    }
    
    int getCashBoxIndexForWoman()
    {
        int index = 0;
        int minQueue = cashList.get(0).getCustomersQty();
        
        for (int i = 1; i < cashList.size(); i++)
        {
            if (minQueue > cashList.get(i).getCustomersQty())
            {
                index = i;
                minQueue = cashList.get(i).getCustomersQty();
            }
        }
        
        return index;
    }
    
    int getCashBoxIndexForMan(int goodsQty)
    {
        int index = 0;
        int minSteps = cashList.get(0).getQueueSteps();
        minSteps += goodsQty/cashList.get(0).getPerfomance();
        minSteps += goodsQty%cashList.get(0).getPerfomance() > 0 ? 1 : 0;
        
        for (int i = 1; i < cashList.size(); i++) 
        {
            int stepsForCashBox =  cashList.get(i).getQueueSteps();
            stepsForCashBox += goodsQty/cashList.get(i).getPerfomance();
            stepsForCashBox += goodsQty%cashList.get(i).getPerfomance() > 0 ? 1 : 1; 
            
            if (minSteps > stepsForCashBox)
            {
                index = i;
                minSteps = stepsForCashBox;
            }
        }        
        
        return index;
    }    
}
