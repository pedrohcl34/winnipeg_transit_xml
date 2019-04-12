/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.controller;

import java.io.IOException;

/**
 *
 * @author Pedro Henrique
 */
 abstract class APIController {
    protected String API_KEY = "api-key=Bq2bRqpFhq6MOgzLnYce";
    protected String URL = "https://api.winnipegtransit.com/";
    
    abstract Object readFile(String filePath) throws IOException;
}
