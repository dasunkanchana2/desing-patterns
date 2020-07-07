package com.dasun.desingpattern;

/**
 * The AdapterPatternDemo - Adapter Pattern
 */
public class AdapterPatternDemo {
    public static void main(String[] args) {
       CreditCard creditCard =  new BankCustomer();
       creditCard.giveBankDetails();
       System.out.println(creditCard.getCreditCard());
    }
}

interface CreditCard{
    public void giveBankDetails();
    public String getCreditCard();
}

class BankDetails{
    private String bankName;
    private String accHolderName;
    private long accNumber;

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccHolderName() {
        return accHolderName;
    }

    public void setAccHolderName(String accHolderName) {
        this.accHolderName = accHolderName;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
    }
}


class BankCustomer extends BankDetails implements CreditCard{

    @Override
    public void giveBankDetails() {
        setAccHolderName("Dasun");
        setAccNumber(123456);
        setBankName("Commercial");
    }

    @Override
    public String getCreditCard() {
        return getAccHolderName()+""+getAccNumber()+""+getBankName();
    }
}