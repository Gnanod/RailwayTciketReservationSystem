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
public class ViewWagonDto extends SuperDto{
    private String trainId;
    private String wagonId;
    private String classType;
    private int sheetQty;

    public ViewWagonDto() {
    }

    public ViewWagonDto(String trainId, String wagonId, String classType, int sheetQty) {
        this.trainId = trainId;
        this.wagonId = wagonId;
        this.classType = classType;
        this.sheetQty = sheetQty;
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
     * @return the wagonId
     */
    public String getWagonId() {
        return wagonId;
    }

    /**
     * @param wagonId the wagonId to set
     */
    public void setWagonId(String wagonId) {
        this.wagonId = wagonId;
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
     * @return the sheetQty
     */
    public int getSheetQty() {
        return sheetQty;
    }

    /**
     * @param sheetQty the sheetQty to set
     */
    public void setSheetQty(int sheetQty) {
        this.sheetQty = sheetQty;
    }
    
    
}
