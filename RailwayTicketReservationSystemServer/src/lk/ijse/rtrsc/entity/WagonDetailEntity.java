/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.entity;



import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Gnanod-PC
 */
@Entity
public class WagonDetailEntity implements Serializable{
   
   // @Column(unique=true)
   // private String wagonDetailId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="trainId",referencedColumnName = "trainId",insertable = false,updatable = false)
    private TrainEntity train;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="wagonId",referencedColumnName = "wagonId",insertable = false,updatable = false)
    private WagonEntity wagonEntity;
    
    @EmbeddedId
    private WagonDetail_PkEntity wagonDetail_Pk;

    public WagonDetailEntity(){
        
    }

    public WagonDetailEntity(String trainId,String wagonId, WagonEntity wagonEntity, TrainEntity train, WagonDetail_PkEntity wagonDetail_Pk) {
       
        this.wagonEntity = wagonEntity;
        this.train = train;
        this.wagonDetail_Pk = new WagonDetail_PkEntity(wagonId,trainId);
    }

    /**
     * @return the wagonDetailId
     */
//    public String getWagonDetailId() {
//        return wagonDetailId;
//    }
//
//    /**
//     * @param wagonDetailId the wagonDetailId to set
//     */
//    public void setWagonDetailId(String wagonDetailId) {
//        this.wagonDetailId = wagonDetailId;
//    }

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

    /**
     * @return the train
     */
    public TrainEntity getTrain() {
        return train;
    }

    /**
     * @param train the train to set
     */
    public void setTrain(TrainEntity train) {
        this.train = train;
    }

    /**
     * @return the wagonDetail_Pk
     */
    public WagonDetail_PkEntity getWagonDetail_Pk() {
        return wagonDetail_Pk;
    }

    /**
     * @param wagonDetail_Pk the wagonDetail_Pk to set
     */
    public void setWagonDetail_Pk(WagonDetail_PkEntity wagonDetail_Pk) {
        this.wagonDetail_Pk = wagonDetail_Pk;
    }
    
    
}
