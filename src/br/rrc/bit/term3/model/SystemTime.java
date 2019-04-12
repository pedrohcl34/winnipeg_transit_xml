/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.rrc.bit.term3.model;

/**
 *
 * @author Pedro Henrique
 */
public class SystemTime extends Object{
    private String date;
    private String time;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
    public SystemTime(String time){
        this.date = time.split("T")[0];
        this.time = time.split("T")[1];
        
    }
}
