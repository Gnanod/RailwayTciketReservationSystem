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
public class SheetDto extends SuperDto{
     private int sheetID;
    private String sheetType;
    private String status;
    
    private WagonDto wagonDto;

    public SheetDto() {
    }

    public SheetDto(int sheetID, String sheetType, String status, WagonDto wagonDto) {
        this.sheetID = sheetID;
        this.sheetType = sheetType;
        this.status = status;
        this.wagonDto = wagonDto;
    }

    /**
     * @return the sheetID
     */
    public int getSheetID() {
        return sheetID;
    }

    /**
     * @param sheetID the sheetID to set
     */
    public void setSheetID(int sheetID) {
        this.sheetID = sheetID;
    }

    /**
     * @return the sheetType
     */
    public String getSheetType() {
        return sheetType;
    }

    /**
     * @param sheetType the sheetType to set
     */
    public void setSheetType(String sheetType) {
        this.sheetType = sheetType;
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
     * @return the wagonDto
     */
    public WagonDto getWagonDto() {
        return wagonDto;
    }

    /**
     * @param wagonDto the wagonDto to set
     */
    public void setWagonDto(WagonDto wagonDto) {
        this.wagonDto = wagonDto;
    }

   

   
    
}
