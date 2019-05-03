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
import lk.ijse.rtrsc.bussiness.custom.WagonBO;
import lk.ijse.rtrsc.dto.ViewWagonDto;
import lk.ijse.rtrsc.dto.Wagon;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.service.custom.WagonService;

/**
 *
 * @author Gnanod-PC
 */
public class WagonServiceImpl extends UnicastRemoteObject implements WagonService,Subject{
    
    private WagonBO wagonBO;
    private static ArrayList<Observer> observerList = new ArrayList<>();
    public WagonServiceImpl()throws RemoteException{
        wagonBO = (WagonBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.WAGON);
    }

    @Override
    public boolean addWagon(Wagon w) throws Exception {
        boolean isAdded = wagonBO.addWagon(w);
        notifyObservers();
        return isAdded;
    }

    @Override
    public List<ViewWagonDto> ViewAllWagons() throws Exception {
        return wagonBO.ViewAllWagons();
    }

 

    @Override
    public boolean deleteWagon(String wagonId) throws Exception {
        boolean isDeleted= wagonBO.deleteWagon(wagonId);
        notifyObservers();
        return isDeleted;
    }

    @Override
    public boolean updateWagon(WagonDto wagon) throws Exception {
        boolean isUpdated= wagonBO.updateWagon(wagon);
        notifyObservers();
        return isUpdated;
    }

    @Override
    public boolean registerObserver(Observer observer) throws Exception {
        return observerList.add(observer);
    }

    @Override
    public boolean unregisterObserver(Observer observer) throws Exception {
       return  observerList.remove(observer);
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
    public List<ViewWagonDto> searchWagon(String wagon) throws Exception {
        return wagonBO.searchWagon(wagon);
    }

    @Override
    public List<WagonDto> getWagon(Object[] ob) throws Exception {
        return wagonBO.getWagon(ob);
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
    public WagonDto searchWagons(String w) throws Exception {
       return wagonBO.searchWagons(w);
    }
    
    
}
