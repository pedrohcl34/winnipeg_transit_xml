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
public class StopFeatures extends Object{
    private String featureName;
    private long number;
    
    public StopFeatures(String featureName, long number){
        this.featureName = featureName;
        this.number  = number;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }
}
