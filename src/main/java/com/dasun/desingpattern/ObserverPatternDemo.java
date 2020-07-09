package com.dasun.desingpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * The ObserverPatternDemo - Observer Pattern
 */
public class ObserverPatternDemo {
    public static void main(String[] args) {

        AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();
        CricketData cricketData = new CricketData();
        cricketData.registerObserver(averageScoreDisplay);
        cricketData.dataChanged();

    }
}

interface Subject{
    public void registerObserver(Observer observer);
    public void unregisterObserver(Observer observer);
    public void notifyObservers();
}

class CricketData implements Subject{

    int run;
    int wickets;
    float overs;
    List<Observer> observerList;

    public CricketData(){
        observerList = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
        observerList.remove(observerList.indexOf(observer));
    }

    @Override
    public void notifyObservers() {
        for(Observer observer:observerList){
            observer.update(run,wickets,overs);
        }

    }

    public int getRun() {
        return 50;
    }

    public int getWickets() {
        return 1;
    }

    public float getOvers() {
        return 2.5f;
    }

    public void dataChanged(){
        run =getRun();
        wickets = getWickets();
        overs = getOvers();
        notifyObservers();
    }

}

interface Observer{
    void update(int runs,int wickets,float overs);
}

class AverageScoreDisplay implements Observer{

    private float runRate;
    private int predictedScore;

    @Override
    public void update(int runs, int wickets, float overs) {
        this.runRate = (float) runs/overs;
        this.predictedScore = (int) this.runRate*50;
        display();
    }

    public void display(){
        System.out.println("RunRate::"+runRate +""+"Predicted Score::"+predictedScore);
    }
}


