package com.dasun.desingpattern;

/**
 * The StrategyPatternDemo - Strategy Pattern
 */
public class StrategyPatternDemo {
    public static void main(String[] args) {
        Context context = new Context((Strategy) new Addition());
        System.out.println(context.executeStrategy(13.0f,14.0f));
    }
}

interface Strategy{
    float calculation(float a,float b);
}

class Addition implements Strategy{
    @Override
    public float calculation(float a, float b) {
        return a+b;
    }
}

class Subtraction implements Strategy{
    @Override
    public float calculation(float a, float b) {
        return a-b;
    }
}

class Context{

    private  Strategy strategy;
    public Context(Strategy strategy){
        this.strategy=strategy;
    }

    public float executeStrategy(float a,float b){
        return strategy.calculation(a,b);
    }

}