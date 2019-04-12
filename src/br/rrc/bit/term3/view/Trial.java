/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.view;
import java.io.FileReader;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
/**
 *
 * @author Pedro Henrique
 */
public class Trial {
    public static void main(String args[]){
        JsonParser parser = new JsonParser();
        
        try {
            Object obj = parser.parse(new FileReader("C:\\json_example1.json"));
            JsonObject jobj = (JsonObject)  obj;
            String firstName = jobj.get("firstName").getAsString();
            System.out.println("First Name: "+firstName);
        } catch (Exception e) {
        }
    }
}
