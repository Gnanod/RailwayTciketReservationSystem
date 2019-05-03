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
public class IdDto extends SuperDto{
    private String entityName;
    private String colName;

    public IdDto() {
    }

    public IdDto(String entityName, String colName) {
        this.entityName = entityName;
        this.colName = colName;
    }

    /**
     * @return the entityName
     */
    public String getEntityName() {
        return entityName;
    }

    /**
     * @param entityName the entityName to set
     */
    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    /**
     * @return the colName
     */
    public String getColName() {
        return colName;
    }

    /**
     * @param colName the colName to set
     */
    public void setColName(String colName) {
        this.colName = colName;
    }

    
}
