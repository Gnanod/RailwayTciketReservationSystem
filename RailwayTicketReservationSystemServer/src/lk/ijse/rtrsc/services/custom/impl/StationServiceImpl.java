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
import lk.ijse.rtrsc.bussiness.custom.StationBO;
import lk.ijse.rtrsc.dto.RouteDayDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.dto.StationDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.service.custom.RouteService;
import lk.ijse.rtrsc.service.custom.StationService;

/**
 *
 * @author Gnanod-PC
 */
public class StationServiceImpl extends UnicastRemoteObject implements StationService, Subject {

    private StationBO stationBO;
    private static ArrayList<Observer> observerList = new ArrayList<>();

    public StationServiceImpl() throws RemoteException {
        stationBO = (StationBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.STATION);
    }

    @Override
    public boolean addStation(StationDto stationDto) throws Exception {
        boolean result = stationBO.addStation(stationDto);
        notifyObservers();
        return result;
    }

    @Override
    public List<StationDto> getAllStation() throws Exception {
        return stationBO.getAllStation();
    }

    @Override
    public String searchStationId(String stationName) throws Exception {
        return stationBO.searchStationId(stationName);
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
    public boolean updateStation(StationDto station) throws Exception {
        boolean result = stationBO.updateStation(station);
        notifyObservers();
        return result;
    }

    @Override
    public boolean registerObserver(Observer observer) throws Exception {
      return  observerList.add(observer);
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

}
