/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.controller;

import br.rrc.bit.term3.model.StopFeatures;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 *
 * @author Pedro Henrique
 */
public class StopFeaturesAPIController extends APIController{
   

    @Override
    public Object readFile(String busStopNumber) throws IOException {
        
        JsonObject jobj = JsonReader.readFile(URL+"v2/stops/"+busStopNumber+"/features.json?"+API_KEY);
        
        JsonArray jFeaturesArray = (JsonArray)jobj.get("stop-features");
        
        ArrayList<StopFeatures> stpBusStopFeaturesList = new ArrayList<StopFeatures>();
        
        for(int i=0;i<jFeaturesArray.size();i++){
        	JsonObject myStopFeature = (JsonObject) jFeaturesArray.get(i);
            stpBusStopFeaturesList.add(new StopFeatures(myStopFeature.get("name").getAsString(), myStopFeature.get("count").getAsLong()));
        }
            
        return stpBusStopFeaturesList;
    }
    
    
}
