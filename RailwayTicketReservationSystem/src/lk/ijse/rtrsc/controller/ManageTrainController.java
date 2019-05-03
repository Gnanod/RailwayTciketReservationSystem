/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import java.util.List;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.TrainService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageTrainController {

    public static boolean addTrain(TrainDto trainDto) throws Exception {
        TrainService trainService = (TrainService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
        return trainService.addTrain(trainDto);
    }

    public static TrainDto searchTrain(String trainId) throws Exception {
        TrainService trainService = (TrainService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
        return trainService.searchTrain(trainId);
    }

    public static List<TrainDto> getAllTrains() throws Exception {
        TrainService trainService = (TrainService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
        return trainService.getAllTrains();
    }

    public static boolean updateTrain(TrainDto train) throws Exception {
        TrainService trainService = (TrainService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
        return trainService.updateTrain( train);
    }

    public static boolean deleteTrain(String deleteTrainId) throws Exception {
        TrainService trainService = (TrainService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
        return trainService.deleteTrain(deleteTrainId);
    }
    public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
    }

    public static List<TrainDto> getAllAvailableTrains() throws Exception {
        TrainService trainService = (TrainService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
        return trainService.getAllAvailableTrains();
    }

    public static int getRouteCount(String name) throws Exception {
        TrainService trainService = (TrainService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.TRAIN);
        return trainService.getRouteCount(name);
    }
}
