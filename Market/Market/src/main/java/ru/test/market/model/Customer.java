package ru.test.market.model;

public class Customer 
{
    public static final char TYPE_CHILD = 'C';
    public static final char TYPE_MAN   = 'M';
    public static final char TYPE_WOMAN = 'W';
    
    private final char type;    
    private int goodsQty;
    private boolean newCustomer = true;
    

    public Customer(char type, int goodsQty) 
    {
        this.type = type;
        this.goodsQty = goodsQty;
    }

    public char getType() {
        return type;
    }

    public int getGoodsQty() {
        return goodsQty;
    }

    public boolean isNewCustomer() {
        return newCustomer;
    }

    public void setNewCustomer(boolean newCustomer) {
        this.newCustomer = newCustomer;
    }    

    public void setGoodsQty(int goodsQty) {
        this.goodsQty = goodsQty;
    }      
    
}
