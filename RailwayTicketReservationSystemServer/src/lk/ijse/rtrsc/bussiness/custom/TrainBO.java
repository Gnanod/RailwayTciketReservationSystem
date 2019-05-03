/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom;

import java.util.List;
import lk.ijse.rtrsc.bussiness.SuperBO;
import lk.ijse.rtrsc.dto.TrainDto;

/**
 *
 * @author Gnanod-PC
 */
public interface TrainBO extends SuperBO{

    public boolean addTrain(TrainDto trainDto)throws Exception;

    public TrainDto searchTrain(String trainId)throws Exception;

    public List<TrainDto> getAllTrains()throws Exception;

    public boolean updateTrain(TrainDto train)throws Exception;

    public boolean deleteTrain(String deleteTrainId)throws Exception;

    public List<TrainDto> getAllAvailableTrains()throws Exception;

    public List<TrainDto> getAvailableTrains()throws Exception;

    public int getRouteCount(String name)throws Exception;
    
}
