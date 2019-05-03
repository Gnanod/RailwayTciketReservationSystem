/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Gnanod-PC
 */
@Embeddable
public class WagonDetail_PkEntity implements Serializable{
    @Column(length = 10)
    private String wagonId;
    @Column(length = 10)
    private String trainId;

    public WagonDetail_PkEntity() {
    }

    public WagonDetail_PkEntity(String wagonId, String trainId) {
        this.wagonId = wagonId;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.wagonId);
        hash = 97 * hash + Objects.hashCode(this.trainId);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final WagonDetail_PkEntity other = (WagonDetail_PkEntity) obj;
        if (!Objects.equals(this.wagonId, other.wagonId)) {
            return false;
        }
        if (!Objects.equals(this.trainId, other.trainId)) {
            return false;
        }
        return true;
    }
    
}
