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
import lk.ijse.rtrsc.bussiness.custom.RouteBO;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.dto.RouteDayDto;
import lk.ijse.rtrsc.dto.RouteDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.service.custom.RouteService;

/**
 *
 * @author Gnanod-PC
 */
public class RouteServiceImpl extends UnicastRemoteObject implements RouteService, Subject {

    private RouteBO routeBO;
    private static ArrayList<Observer> observerList = new ArrayList<>();

    public RouteServiceImpl() throws RemoteException {
        routeBO = (RouteBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.ROUTE);
    }

    @Override
    public boolean addRouteDay(RouteDayDto routeDay) throws Exception {
        
       boolean result=routeBO.addRouteDay(routeDay);
       notifyObservers();
       return result;
    }

    @Override
    public List<RouteDto> getAllRoutes() throws Exception {
        return routeBO.getAllRoutes();
    }

    @Override
    public DayDto searchDays(String dateId) throws Exception {
        return routeBO.searchDays(dateId);
    }

    @Override
    public boolean deleteRoute(String routeId) throws Exception {
        
        boolean result= routeBO.deleteRoute(routeId);
        notifyObservers();
        return result;
    }

    @Override
    public RouteDto searchTrain(String routeName) throws Exception {
        System.out.println("2222222");
        return routeBO.searchTrain(routeName);
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
}
