/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.dto;

/**
 *
 * @author Gnanod-PC
 */
public class ViewTrainsDto extends SuperDto{
   private String depaturetime;
   private String routeName;
   private String trainType;

    public ViewTrainsDto() {
    }

    public ViewTrainsDto(String depaturetime, String routeName, String trainType) {
        this.depaturetime = depaturetime;
        this.routeName = routeName;
        this.trainType = trainType;
    }

    /**
     * @return the depaturetime
     */
    public String getDepaturetime() {
        return depaturetime;
    }

    /**
     * @param depaturetime the depaturetime to set
     */
    public void setDepaturetime(String depaturetime) {
        this.depaturetime = depaturetime;
    }

    /**
     * @return the routeName
     */
    public String getRouteName() {
        return routeName;
    }

    /**
     * @param routeName the routeName to set
     */
    public void setRouteName(String routeName) {
        this.routeName = routeName;
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
   
}
