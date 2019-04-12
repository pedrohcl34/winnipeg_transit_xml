/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.controller;

import br.rrc.bit.term3.model.StopRoute;
import java.io.IOException;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author Pedro Henrique
 */
public class StopRouteController extends APIController{
    
    private String time;
    
    public StopRouteController(String time){
        this.time = time;
    }
    
    @Override
    public Object readFile(String busStopNumber) throws IOException {
        JsonObject jobj = JsonReader.readFile(URL+"v1/stops/"+busStopNumber+"/schedule.json?"+"start="+time+"&"+"max-results-per-route=3&"+API_KEY);
        
        ArrayList<StopRoute> stpBusStopRouteList = new ArrayList<StopRoute>();
        JsonObject myobj = (JsonObject) ((JsonObject)jobj.get("stop-schedule")).get("route-schedules");
        System.out.println(myobj);
        
        JsonArray jRoutesArray = null;
        
        try{
            jRoutesArray = (JsonArray)myobj.get("route-schedule");
        }catch (Exception ex){
            jRoutesArray= null;
        }
        if(jRoutesArray==null){
        	JsonObject route = (JsonObject)myobj.get("route-schedule");
           String routeName = ((JsonObject)route.get("route")).get("name").getAsString();
           StopRoute myRoute = new StopRoute(routeName);
           
           JsonObject scheduledStops = (JsonObject) route.get("scheduled-stops");
           
           JsonArray jStopTimes = (JsonArray)scheduledStops.get("scheduled-stop");
           
           for(int j=0;j<jStopTimes.size();j++){
               
        	   JsonObject busStop = (JsonObject)((JsonObject) jStopTimes.get(j)).get("times");
        	   JsonObject arrivalTime = (JsonObject) busStop.get("arrival");
               if(arrivalTime ==null)
                   arrivalTime = (JsonObject)busStop.get("departure");
               myRoute.addTime((arrivalTime.get("estimated").getAsString()));
               
               
           }
           
            stpBusStopRouteList.add(myRoute);
        }else{
            for(int i=0;i<jRoutesArray.size();i++){
            	JsonObject myStopRoute = (JsonObject) jRoutesArray.get(i);
           
           String routeName = ((JsonObject)myStopRoute.get("route")).get("name").getAsString();
           StopRoute myRoute = new StopRoute(routeName);
           
           JsonObject scheduledStops = (JsonObject) myStopRoute.get("scheduled-stops");
           
           JsonArray jStopTimes = (JsonArray)scheduledStops.get("scheduled-stop");
           
           for(int j=0;j<jStopTimes.size();j++){
               
        	   JsonObject busStop = (JsonObject)((JsonObject) jStopTimes.get(j)).get("times");
        	   JsonObject arrivalTime = (JsonObject) busStop.get("arrival");
               if(arrivalTime ==null)
                   arrivalTime = (JsonObject)busStop.get("departure");
               System.out.println(j);
               myRoute.addTime((arrivalTime.get("estimated")).getAsString());
               
               
           }
           
            stpBusStopRouteList.add(myRoute);
            
          }
        }
        
        
        return  stpBusStopRouteList;
    }
    
}
