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
public class Wagon extends SuperDto{
    private List<WagonDetailDto> wagonDetailList;
    private WagonDto wagon;
    private TrainDto train;
    private List<SheetDto> sheetList ;

    public Wagon() {
    }

    public Wagon(List<WagonDetailDto> wagonDetailList, WagonDto wagon, TrainDto train, List<SheetDto> sheetList) {
        this.wagonDetailList = wagonDetailList;
        this.wagon = wagon;
        this.train = train;
        this.sheetList = sheetList;
    }

    public Wagon(List<WagonDetailDto> wagonDetailList, WagonDto wagon, TrainDto train) {
        this.wagonDetailList = wagonDetailList;
        this.wagon = wagon;
        this.train = train;
    }

    /**
     * @return the wagonDetailList
     */
    public List<WagonDetailDto> getWagonDetailList() {
        return wagonDetailList;
    }

    /**
     * @param wagonDetailList the wagonDetailList to set
     */
    public void setWagonDetailList(List<WagonDetailDto> wagonDetailList) {
        this.wagonDetailList = wagonDetailList;
    }

    /**
     * @return the wagon
     */
    public WagonDto getWagon() {
        return wagon;
    }

    /**
     * @param wagon the wagon to set
     */
    public void setWagon(WagonDto wagon) {
        this.wagon = wagon;
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
