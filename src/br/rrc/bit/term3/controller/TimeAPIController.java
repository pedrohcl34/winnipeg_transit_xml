/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.controller;

import br.rrc.bit.term3.model.SystemTime;
import java.io.IOException;

import com.google.gson.JsonObject;

/**
 *
 * @author Pedro Henrique
 */
public class TimeAPIController extends APIController{
    
   

    @Override
    public Object readFile(String filePath) throws IOException{
        JsonObject jobj = JsonReader.readFile(URL+filePath+API_KEY);
        SystemTime beanTime = new SystemTime(jobj.get("time").getAsString());
        return beanTime;
    }
    
    
    
    public static void main(String args[]){
        try {
            TimeAPIController tsgTimeGetter = new TimeAPIController();
            SystemTime beanTime = (SystemTime) tsgTimeGetter.readFile("v1/time.json?");
            System.out.println("Time: " + beanTime.getTime());
            System.out.println("Date: " + beanTime.getDate());
        } catch (IOException ex) {
            System.out.println("Error "+ex.getMessage());
        }
    }
}
