package com.dasun.desingpattern;

/**
 * The GeneratePlanBill - Factory method pattern
 */
public class GeneratePlanBill {

    public static void main(String[] args) {

        PlanFactory planFactory = new PlanFactory();
        Plan plan = planFactory.getPlan("Commercial");
        plan.getRate();
        plan.calculateBill(10);
    }
}

abstract class Plan{

    protected double rate;
    abstract  void getRate();

    public void calculateBill(int units){
        System.out.println(units*rate);
    }

}

class DomesticPlan extends Plan{

    @Override
    void getRate() {
        rate=3.50;
    }
}

class CommercialPlan extends Plan{

    @Override
    void getRate() {
        rate=7.50;
    }
}


class PlanFactory{

    public Plan getPlan(String planType){

        if(planType==null){
            return null;
        }else if(planType.equalsIgnoreCase("Domestic")){
            return new DomesticPlan();
        }else{
            return new CommercialPlan();
        }

    }
}

