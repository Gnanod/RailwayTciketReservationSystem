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
public class Route_PkDto {
    private String trainId;
    private String dayId;

    public Route_PkDto() {
    }

    public Route_PkDto(String trainId, String dayId) {
        this.trainId = trainId;
        this.dayId = dayId;
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
        return dayId;
    }

    /**
     * @param dayId the dayId to set
     */
    public void setDayId(String dayId) {
        this.dayId = dayId;
    }
    
}
