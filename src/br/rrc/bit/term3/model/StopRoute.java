/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.model;

import java.util.ArrayList;


/**
 *
 * @author Pedro Henrique
 */
public class StopRoute extends Object{
    private String busRoute;
    private ArrayList<SystemTime> busArrivalTime;
    
    
    public StopRoute(String busRoute){
        this.busRoute = busRoute;
        busArrivalTime = new ArrayList<SystemTime>();
    }
        
    public String getBusRoute() {
        return busRoute;
    }

    public void setBusRoute(String busRoute) {
        this.busRoute = busRoute;
    }

    public ArrayList<SystemTime> getBusArrivalTime() {
        return busArrivalTime;
    }
        
    public void addTime(String arrivalTime){
        busArrivalTime.add(new SystemTime(arrivalTime));
    }
}
