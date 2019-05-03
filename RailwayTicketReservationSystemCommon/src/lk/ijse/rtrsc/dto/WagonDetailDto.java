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
public class WagonDetailDto extends SuperDto{
     private String wagonDetailId;
     private WagonDto wagonEntity;
     private TrainDto train;
     private WagonDetail_PkDto wagonDetail_Pk;

    public WagonDetailDto() {
    }

    public WagonDetailDto(String wagonId,String trainId,String wagonDetailId, WagonDto wagonEntity, TrainDto train, WagonDetail_PkDto wagonDetail_Pk) {
        this.wagonDetailId = wagonDetailId;
        this.wagonEntity = wagonEntity;
        this.train = train;
        this.wagonDetail_Pk = new WagonDetail_PkDto(wagonId,trainId);
    }

    /**
     * @return the wagonDetailId
     */
    public String getWagonDetailId() {
        return wagonDetailId;
    }

    /**
     * @param wagonDetailId the wagonDetailId to set
     */
    public void setWagonDetailId(String wagonDetailId) {
        this.wagonDetailId = wagonDetailId;
    }

    /**
     * @return the wagonEntity
     */
    public WagonDto getWagonEntity() {
        return wagonEntity;
    }

    /**
     * @param wagonEntity the wagonEntity to set
     */
    public void setWagonEntity(WagonDto wagonEntity) {
        this.wagonEntity = wagonEntity;
    }

    /**
     * @return the train
     */
    public TrainDto getTrain() {
        return train;
    }

    /**
     * @param train the train to set
     */
    public void setTrain(TrainDto train) {
        this.train = train;
    }

    /**
     * @return the wagonDetail_Pk
     */
    public WagonDetail_PkDto getWagonDetail_Pk() {
        return wagonDetail_Pk;
    }

    /**
     * @param wagonDetail_Pk the wagonDetail_Pk to set
     */
    public void setWagonDetail_Pk(WagonDetail_PkDto wagonDetail_Pk) {
        this.wagonDetail_Pk = wagonDetail_Pk;
    }
     
}
