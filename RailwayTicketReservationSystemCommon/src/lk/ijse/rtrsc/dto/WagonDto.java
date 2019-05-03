/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.dto;

import java.util.List;

/**
 *
 * @author Gnanod-PC
 */
public class WagonDto extends SuperDto{

    private String wagonId;
    private String classType;
    private int sheetQuantity;

    private List<SheetDto> sheetList;

    public WagonDto() {
    }

    public WagonDto(String wagonId, String classType, int sheetQuantity, List<SheetDto> sheetList) {
        this.wagonId = wagonId;
        this.classType = classType;
        this.sheetQuantity = sheetQuantity;
        this.sheetList = sheetList;
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
     * @return the sheetQuantity
     */
    public int getSheetQuantity() {
        return sheetQuantity;
    }

    /**
     * @param sheetQuantity the sheetQuantity to set
     */
    public void setSheetQuantity(int sheetQuantity) {
        this.sheetQuantity = sheetQuantity;
    }

    /**
     * @return the sheetList
     */
    public List<SheetDto> getSheetList() {
        return sheetList;
    }

    /**
     * @param sheetList the sheetList to set
     */
    public void setSheetList(List<SheetDto> sheetList) {
        this.sheetList = sheetList;
    }
    
    
}
