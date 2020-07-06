package com.dasun.desingpattern;

public class AbstractFactoryPatternExample {
    public static void main(String[] args) {

        AbstractFactory bankFacotory = FactoryCreator.getAbstractFactory("Bank");
        Bank bank = bankFacotory.getBank("boc");
        System.out.println(bank.getBankName());

        AbstractFactory loanFactory = FactoryCreator.getAbstractFactory("Loan");
        Loan loan = loanFactory.getLoan("Home");
        Double rate = 13.5;
        loan.getInterestRate(rate);
        loan.calculateLoanPayment(1000,10);
    }
}

interface Bank{

    String getBankName();
}

class BOC implements Bank{

    private final String BANK_NAME;

    public BOC(){
        BANK_NAME ="BOC";
    }

    @Override
    public String getBankName() {
        return BANK_NAME;
    }
}

class NTB implements Bank{

    private final String BANK_NAME;

    public NTB(){
        BANK_NAME ="NTB";
    }

    @Override
    public String getBankName() {
        return BANK_NAME;
    }
}

abstract class Loan{

    protected double rate;
    abstract void getInterestRate(double rate);

    public void calculateLoanPayment(double loanAmount,int years){
        System.out.println("Loan Amount ::: "+loanAmount+"Years:::"+years);
    }
}

class Home extends Loan{

    @Override
    void getInterestRate(double r) {
        rate = r;
    }
}

class Personal extends Loan{

    @Override
    void getInterestRate(double r) {
        rate = r;
    }
}

abstract class AbstractFactory{
    public abstract Bank getBank(String bank);
    public abstract Loan getLoan(String loan);
}

class BankFactory extends AbstractFactory{

    @Override
    public Bank getBank(String bank) {
        if(bank == null){
            return null;
        }else if(bank.equalsIgnoreCase("BOC")){
            return new BOC();
        }else{
            return new NTB();
        }
    }

    @Override
    public Loan getLoan(String loan) {
        return null;
    }
}

class LoanFactory extends AbstractFactory {

    @Override
    public Bank getBank(String bank) {
        return null;
    }

    @Override
    public Loan getLoan(String loan) {
        if (loan == null) {
            return null;
        } else if (loan.equalsIgnoreCase("home")) {
            return new Home();
        } else {
            return new Personal();
        }

    }

}
    class FactoryCreator{

        public static AbstractFactory getAbstractFactory(String choice){
            if(choice.equalsIgnoreCase("bank")){
                return new BankFactory();
            }else{
                return new LoanFactory();
            }
        }
    }


