/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gnanod-PC
 */
@Embeddable
public class Route_PkEntity implements Serializable{
     @Column(length = 10)
    private String trainId;
      @Column(length = 10)
    private String dateId;

    public Route_PkEntity() {
    }

    public Route_PkEntity(String trainId, String dateId) {
        this.trainId = trainId;
        this.dateId = dateId;
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
     * @return the dayId
     */
    public String getDayId() {
        return dateId;
    }

    /**
     * @param dayId the dayId to set
     */
    public void setDayId(String dayId) {
        this.dateId = dayId;
    }
    
}
