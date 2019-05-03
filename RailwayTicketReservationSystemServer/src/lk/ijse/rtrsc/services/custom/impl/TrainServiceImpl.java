/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.services.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.rtrsc.bussiness.BOFactory;
import lk.ijse.rtrsc.bussiness.custom.TrainBO;
import lk.ijse.rtrsc.dto.TrainDto;
import lk.ijse.rtrsc.dto.UserDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.service.custom.TrainService;
import lk.ijse.rtrsc.service.custom.UserService;

/**
 *
 * @author Gnanod-PC
 */
public class TrainServiceImpl extends UnicastRemoteObject implements TrainService,Subject{
    
   private TrainBO trainBO;
   private static ArrayList<Observer> observerList = new ArrayList<>();
   public TrainServiceImpl()throws RemoteException{
        System.out.println("trainCon");
       trainBO = (TrainBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.TRAIN);
   }

    @Override
    public boolean addTrain(TrainDto trainDto) throws Exception {
        boolean isAdded= trainBO.addTrain(trainDto);
        notifyObservers();
        return isAdded;
    }

    @Override
    public TrainDto searchTrain(String trainId) throws Exception {
        return trainBO.searchTrain(trainId);
                
    }

    @Override
    public List<TrainDto> getAllTrains() throws Exception {
        return trainBO.getAllTrains();
    }

    @Override
    public boolean updateTrain(TrainDto train) throws Exception {
         
        boolean isUpdated=trainBO.updateTrain(train);
        notifyObservers();
        return isUpdated;
                
    }

    @Override
    public boolean deleteTrain(String deleteTrainId) throws Exception {
        boolean isDeleted =trainBO.deleteTrain(deleteTrainId);
        notifyObservers();
        return isDeleted;
    }

    @Override
    public boolean registerObserver(Observer observer) throws Exception {
       return observerList.add(observer);
                
    }

    @Override
    public boolean unregisterObserver(Observer observer) throws Exception {
        return observerList.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
        new Thread(() -> {
            for (Observer observer : observerList) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(TrainServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }

    @Override
    public boolean reserve(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean release(Object id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TrainDto> getAllAvailableTrains() throws Exception {
        System.out.println("tttttt");  
        return trainBO.getAvailableTrains();
    }

    @Override
    public int getRouteCount(String name) throws Exception {
          return trainBO.getRouteCount(name) ;
    }
  
    
}


