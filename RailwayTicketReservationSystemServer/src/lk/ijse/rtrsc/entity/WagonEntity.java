/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class WagonEntity implements Serializable{
  @Id
  private String wagonId;
  private String classType;
  private int sheetQuantity;
  @OneToMany(cascade = CascadeType.ALL)
  private List<SheetEntity> sheetList;

    public WagonEntity() {
    }

    public WagonEntity(String wagonId, String classType, int sheetQuantity, List<SheetEntity> sheetList) {
        this.wagonId = wagonId;
        this.classType = classType;
        this.sheetQuantity = sheetQuantity;
        this.sheetList = sheetList;
    }

//    public WagonEntity(String wagonId, String classType, int sheetQuantity, List<SheetEntity> sheetList) {
//        this.wagonId = wagonId;
//        this.classType = classType;
//        this.sheetQuantity = sheetQuantity;
//        this.sheetList = sheetList;
//    }
//
//    /**
//     * @return the wagonId
//     */
//    public String getWagonId() {
//        return wagonId;
//    }
//
//    /**
//     * @param wagonId the wagonId to set
//     */
//    public void setWagonId(String wagonId) {
//        this.wagonId = wagonId;
//    }
//
//    /**
//     * @return the classType
//     */
//    public String getClassType() {
//        return classType;
//    }
//
//    /**
//     * @param classType the classType to set
//     */
//    public void setClassType(String classType) {
//        this.classType = classType;
//    }
//
//    /**
//     * @return the sheetQuantity
//     */
//    public int getSheetQuantity() {
//        return sheetQuantity;
//    }
//
//    /**
//     * @param sheetQuantity the sheetQuantity to set
//     */
//    public void setSheetQuantity(int sheetQuantity) {
//        this.sheetQuantity = sheetQuantity;
//    }
//
//    /**
//     * @return the sheetList
//     */
//    public List<SheetEntity> getSheetList() {
//        return sheetList;
//    }
//
//    /**
//     * @param sheetList the sheetList to set
//     */
//    public void setSheetList(List<SheetEntity> sheetList) {
//        this.sheetList = sheetList;
//    }

    public WagonEntity(String wagonId, String classType, int sheetQuantity) {
        this.wagonId = wagonId;
        this.classType = classType;
        this.sheetQuantity = sheetQuantity;
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
    public List<SheetEntity> getSheetList() {
        return sheetList;
    }

    /**
     * @param sheetList the sheetList to set
     */
    public void setSheetList(List<SheetEntity> sheetList) {
        this.sheetList = sheetList;
    }
  
}
