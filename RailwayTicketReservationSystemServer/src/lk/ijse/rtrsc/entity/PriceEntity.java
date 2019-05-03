/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class PriceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PriceId;
    private String trainType;
    private String classType;
    private String startStation;
    private String endStation;
    private double amount;

    public PriceEntity() {
    }

    public PriceEntity(int PriceId, String trainType, String classType, String startStation, String endStation, double amount) {
        this.PriceId = PriceId;
        this.trainType = trainType;
        this.classType = classType;
        this.startStation = startStation;
        this.endStation = endStation;
        this.amount = amount;
    }

    /**
     * @return the PriceId
     */
    public int getPriceId() {
        return PriceId;
    }

    /**
     * @param PriceId the PriceId to set
     */
    public void setPriceId(int PriceId) {
        this.PriceId = PriceId;
    }

    /**
     * @return the trainType
     */
    public String getTrainType() {
        return trainType;
    }

    /**
     * @param trainType the trainType to set
     */
    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    /**
     * @return the classType
     */
    public String getClassType() {
        return classType;
    }

    /**
     * @param classType the classType to set
     */
    public void setClassType(String classType) {
        this.classType = classType;
    }

    /**
     * @return the startStation
     */
    public String getStartStation() {
        return startStation;
    }

    /**
     * @param startStation the startStation to set
     */
    public void setStartStation(String startStation) {
        this.startStation = startStation;
    }

    /**
     * @return the endStation
     */
    public String getEndStation() {
        return endStation;
    }

    /**
     * @param endStation the endStation to set
     */
    public void setEndStation(String endStation) {
        this.endStation = endStation;
    }

    /**
     * @return the amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
