/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.controller;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 *
 * @author Pedro Henrique
 */
public class JsonReader {
   
   public static  JsonObject readFile(String filePath) throws IOException{
       JsonParser parserJSon = new JsonParser();
       JsonObject jobj = (JsonObject) parserJSon.parse(new InputStreamReader(new URL(filePath).openStream()));
       
       return jobj;
   }
             
}
