package ru.test.market.bl;

import java.util.ArrayList;
import java.util.List;
import ru.test.market.model.CashBox;
import ru.test.market.model.Customer;

public class Manager 
{
    private final int MAX_CASHBOX_PERFOMANCE = 10;
    private final int MAX_CUSTOMER_GOODS = 50;
    
    private List<CashBox> cashList;      
    private Customer newCustomer;   
    
    private int man_percent;
    private int woman_percent;
    private int child_percent;
    
    private boolean autoType = true;
    
    
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
        
        if (autoType) 
        {        
            type = getAutoType();
        }
        else 
        {
            type = getBalancedType();
        }
        
        int perfomance = (int)Math.round(Math.random()*MAX_CUSTOMER_GOODS);  
        
        if (newCustomer != null)
            newCustomer.setNewCustomer(false);
        
        newCustomer = new Customer(type, perfomance);
        return newCustomer;
    }
    
    private char getAutoType() {
        char type;
        int index = (int) Math.round(Math.random() * 2);
        switch (index) {
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

        return type;
    }
    
    /*
        Данный метод не совсем корректно производит балансировку 
        процентного состава покупателей, точнее он ее не производит, 
        а только задает вероятность появление того или иного типа,
        если положить, что функция random() использует равномерное распределение :)       
    */
    private char getBalancedType() 
    {            
        int index = (int) Math.round(Math.random() * 100);
        
        if (index <= man_percent) return Customer.TYPE_MAN;
        if (index <= (man_percent + woman_percent)) return Customer.TYPE_WOMAN;
        if (index <= (man_percent + woman_percent + child_percent)) return Customer.TYPE_CHILD;
        
        return Customer.TYPE_CHILD;               
        
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
    
    public String getHtmlStepRepresentation(){
        
        StringBuilder htmlStep = new StringBuilder();
        
        for (CashBox cash : cashList){

            htmlStep.append("<table>");
            htmlStep.append("<tr>");
            htmlStep.append("<td><img src=\"images/cashbox.png\" alt=\"cashbox\"/></td>");    
            
            StringBuilder customersGoods = new StringBuilder();
            for (Customer customer : cash.getCustomers()) {
                switch (customer.getType()) {
                    case Customer.TYPE_CHILD:  
                        if (customer.isNewCustomer())
                            htmlStep.append("<td><img src=\"images/new_child.png\" alt=\"cashbox\"/></td>"); 
                        else
                            htmlStep.append("<td><img src=\"images/child.png\" alt=\"cashbox\"/></td>"); 
                        break;
                    case Customer.TYPE_MAN:
                       if (customer.isNewCustomer())
                            htmlStep.append("<td><img src=\"images/new_man.png\" alt=\"cashbox\"/></td>"); 
                        else
                            htmlStep.append("<td><img src=\"images/man.png\" alt=\"cashbox\"/></td>"); 
                        break;
                    case Customer.TYPE_WOMAN:
                        if (customer.isNewCustomer())
                            htmlStep.append("<td><img src=\"images/new_woman.png\" alt=\"cashbox\"/></td>"); 
                        else
                            htmlStep.append("<td><img src=\"images/woman.png\" alt=\"cashbox\"/></td>"); 
                        break;
                }   
                
                customersGoods.append("<td>Товары:").append(customer.getGoodsQty()).append("</td>");
            }
            
            htmlStep.append("</tr>");
            htmlStep.append("<tr>");
            htmlStep.append("<td>Производительность:").append(cash.getPerfomance()).append("</td>");
            htmlStep.append(customersGoods);
            htmlStep.append("</tr>");
            
            htmlStep.append("<tr>");
            htmlStep.append("<td>Обработано.");
            htmlStep.append("</tr>");
            
            htmlStep.append("<tr>");
            htmlStep.append("<td>Товаров:").append(cash.getDoneGoods()).append("</td>");
            htmlStep.append("</tr>");
            
            htmlStep.append("<tr>");
            htmlStep.append("<td>Клиентов:").append(cash.getDoneCustomers()).append("</td>");
            htmlStep.append("</tr>");
            
            htmlStep.append("</table>");             
            
        }       
        
        htmlStep.append("<hr>");
        
        return htmlStep.toString();
    }   

    public void addPercentBalance(int man, int woman, int child) {
        
        autoType = false;
        
        this.man_percent = man;
        this.woman_percent = woman;
        this.child_percent = child;
    }  
}
