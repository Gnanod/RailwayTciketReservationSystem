/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class SheetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sheetID;
    private String sheetType;
    private String status;
    @ManyToOne(cascade = CascadeType.ALL)
    private WagonEntity wagonEntity;

    public SheetEntity() {
    }

    public SheetEntity(int sheetID, String sheetType, String status, WagonEntity wagonEntity) {
        this.sheetID = sheetID;
        this.sheetType = sheetType;
        this.status = status;
        this.wagonEntity = wagonEntity;
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
     * @return the wagonEntity
     */
    public WagonEntity getWagonEntity() {
        return wagonEntity;
    }

    /**
     * @param wagonEntity the wagonEntity to set
     */
    public void setWagonEntity(WagonEntity wagonEntity) {
        this.wagonEntity = wagonEntity;
    }
    
}
