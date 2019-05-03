/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class TrainEntity {
    @Id
    private String trainId;
    private String engineNumber;
    private boolean firstClass;
    private boolean secondClass;
    private boolean thirdClass;
    private boolean observationSaloon;
    private int firstClassWagonQty;
    private int secondClassWagonQty;
    private int thirdClassWagonQty;
    private int observationSaloonWagonQty;
    private String trainType;
    private String status;
    private String routeStatus;

    public TrainEntity(String trainId, String engineNumber, boolean firstClass, boolean secondClass, boolean thirdClass, boolean observationSaloon, int firstClassWagonQty, int secondClassWagonQty, int thirdClassWagonQty, int observationSaloonWagonQty, String trainType, String status) {
        this.trainId = trainId;
        this.engineNumber = engineNumber;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.thirdClass = thirdClass;
        this.observationSaloon = observationSaloon;
        this.firstClassWagonQty = firstClassWagonQty;
        this.secondClassWagonQty = secondClassWagonQty;
        this.thirdClassWagonQty = thirdClassWagonQty;
        this.observationSaloonWagonQty = observationSaloonWagonQty;
        this.trainType = trainType;
        this.status = status;
    }
    

    public TrainEntity(String trainId, String engineNumber, boolean firstClass, boolean secondClass, boolean thirdClass, boolean observationSaloon, int firstClassWagonQty, int secondClassWagonQty, int thirdClassWagonQty, int observationSaloonWagonQty, String trainType) {
        this.trainId = trainId;
        this.engineNumber = engineNumber;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.thirdClass = thirdClass;
        this.observationSaloon = observationSaloon;
        this.firstClassWagonQty = firstClassWagonQty;
        this.secondClassWagonQty = secondClassWagonQty;
        this.thirdClassWagonQty = thirdClassWagonQty;
        this.observationSaloonWagonQty = observationSaloonWagonQty;
        this.trainType = trainType;
    }

    public TrainEntity(String trainId, String engineNumber, boolean firstClass, boolean secondClass, boolean thirdClass, boolean observationSaloon, int firstClassWagonQty, int secondClassWagonQty, int thirdClassWagonQty, int observationSaloonWagonQty, String trainType, String status, String routeStatus) {
        this.trainId = trainId;
        this.engineNumber = engineNumber;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.thirdClass = thirdClass;
        this.observationSaloon = observationSaloon;
        this.firstClassWagonQty = firstClassWagonQty;
        this.secondClassWagonQty = secondClassWagonQty;
        this.thirdClassWagonQty = thirdClassWagonQty;
        this.observationSaloonWagonQty = observationSaloonWagonQty;
        this.trainType = trainType;
        this.status = status;
        this.routeStatus = routeStatus;
    }
    
    public TrainEntity() {
    }

    public TrainEntity(String trainId, String engineNumber, boolean firstClass, boolean secondClass, boolean thirdClass, boolean observationSaloon, int firstClassWagonQty, int secondClassWagonQty, int thirdClassWagonQty, int observationSaloonWagonQty) {
        this.trainId = trainId;
        this.engineNumber = engineNumber;
        this.firstClass = firstClass;
        this.secondClass = secondClass;
        this.thirdClass = thirdClass;
        this.observationSaloon = observationSaloon;
        this.firstClassWagonQty = firstClassWagonQty;
        this.secondClassWagonQty = secondClassWagonQty;
        this.thirdClassWagonQty = thirdClassWagonQty;
        this.observationSaloonWagonQty = observationSaloonWagonQty;
    }

    /**
     * @return the trainId
     */
    public String getTrainId() {
        return trainId;
    }

    /**
     * @param trainId the trainId to set
     */
    public void setTrainId(String trainId) {
        this.trainId = trainId;
    }

    /**
     * @return the engineNumber
     */
    public String getEngineNumber() {
        return engineNumber;
    }

    /**
     * @param engineNumber the engineNumber to set
     */
    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    /**
     * @return the firstClass
     */
    public boolean isFirstClass() {
        return firstClass;
    }

    /**
     * @param firstClass the firstClass to set
     */
    public void setFirstClass(boolean firstClass) {
        this.firstClass = firstClass;
    }

    /**
     * @return the secondClass
     */
    public boolean isSecondClass() {
        return secondClass;
    }

    /**
     * @param secondClass the secondClass to set
     */
    public void setSecondClass(boolean secondClass) {
        this.secondClass = secondClass;
    }

    /**
     * @return the thirdClass
     */
    public boolean isThirdClass() {
        return thirdClass;
    }

    /**
     * @param thirdClass the thirdClass to set
     */
    public void setThirdClass(boolean thirdClass) {
        this.thirdClass = thirdClass;
    }

    /**
     * @return the observationSaloon
     */
    public boolean isObservationSaloon() {
        return observationSaloon;
    }

    /**
     * @param observationSaloon the observationSaloon to set
     */
    public void setObservationSaloon(boolean observationSaloon) {
        this.observationSaloon = observationSaloon;
    }

    /**
     * @return the firstClassWagonQty
     */
    public int getFirstClassWagonQty() {
        return firstClassWagonQty;
    }

    /**
     * @param firstClassWagonQty the firstClassWagonQty to set
     */
    public void setFirstClassWagonQty(int firstClassWagonQty) {
        this.firstClassWagonQty = firstClassWagonQty;
    }

    /**
     * @return the secondClassWagonQty
     */
    public int getSecondClassWagonQty() {
        return secondClassWagonQty;
    }

    /**
     * @param secondClassWagonQty the secondClassWagonQty to set
     */
    public void setSecondClassWagonQty(int secondClassWagonQty) {
        this.secondClassWagonQty = secondClassWagonQty;
    }

    /**
     * @return the thirdClassWagonQty
     */
    public int getThirdClassWagonQty() {
        return thirdClassWagonQty;
    }

    /**
     * @param thirdClassWagonQty the thirdClassWagonQty to set
     */
    public void setThirdClassWagonQty(int thirdClassWagonQty) {
        this.thirdClassWagonQty = thirdClassWagonQty;
    }

    /**
     * @return the observationSaloonWagonQty
     */
    public int getObservationSaloonWagonQty() {
        return observationSaloonWagonQty;
    }

    /**
     * @param observationSaloonWagonQty the observationSaloonWagonQty to set
     */
    public void setObservationSaloonWagonQty(int observationSaloonWagonQty) {
        this.observationSaloonWagonQty = observationSaloonWagonQty;
    }

    @Override
    public String toString() {
        return "TrainEntity{" + "trainId=" + trainId + ", engineNumber=" + engineNumber + ", firstClass=" + firstClass + ", secondClass=" + secondClass + ", thirdClass=" + thirdClass + ", observationSaloon=" + observationSaloon + ", firstClassWagonQty=" + firstClassWagonQty + ", secondClassWagonQty=" + secondClassWagonQty + ", thirdClassWagonQty=" + thirdClassWagonQty + ", observationSaloonWagonQty=" + observationSaloonWagonQty + '}';
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
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the routeStatus
     */
    public String getRouteStatus() {
        return routeStatus;
    }

    /**
     * @param routeStatus the routeStatus to set
     */
    public void setRouteStatus(String routeStatus) {
        this.routeStatus = routeStatus;
    }
    
    
    
}
