package com.dasun.desingpattern;

/**
 * The  DecoratorPatternCustomer - Decorator Pattern
 */
public class DecoratorPatternCustomer {
    public static void main(String[] args) {
        VegFood vegFood = new VegFood();
        System.out.println(vegFood.prepareFood());
        System.out.println(vegFood.foodPrice());

        Food food =new NonVegFood((Food) vegFood);
        System.out.println(food.prepareFood());
        System.out.println(food.foodPrice());
    }
}

interface Food {
    public String prepareFood();

    public double foodPrice();
}

class VegFood implements Food {
    @Override
    public String prepareFood() {
        return "VegFood";
    }

    @Override
    public double foodPrice() {
        return 50.0;
    }
}

abstract class FoodDecorator implements Food {

    Food newFood;

    public FoodDecorator(Food newFood) {
        this.newFood = newFood;
    }

    @Override
    public String prepareFood() {
        return newFood.prepareFood();
    }

    @Override
    public double foodPrice() {
        return newFood.foodPrice();
    }
}

class NonVegFood extends FoodDecorator{

    public NonVegFood(Food newFood){
        super(newFood);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood()+"Chicken Roast";
    }

    @Override
    public double foodPrice() {
        return super.foodPrice()+15.00;
    }
}

class ChineseFood extends FoodDecorator{

    public ChineseFood(Food newFood){
        super(newFood);
    }

    @Override
    public String prepareFood() {
        return super.prepareFood()+"Chinese soup";
    }

    @Override
    public double foodPrice() {
        return super.foodPrice()+20.00;
    }
}