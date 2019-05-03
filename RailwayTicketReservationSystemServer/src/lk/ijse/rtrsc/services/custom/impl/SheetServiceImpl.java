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
import lk.ijse.rtrsc.bussiness.custom.SheetBO;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.service.custom.SheetService;

/**
 *
 * @author Gnanod-PC
 */
public class SheetServiceImpl extends UnicastRemoteObject implements SheetService, Subject {

    private SheetBO sheetBO;
    private static ArrayList<Observer> observerList = new ArrayList<>();

    public SheetServiceImpl() throws RemoteException {
        sheetBO = (SheetBO) BOFactory.getInstance().getBO(BOFactory.BoTypes.SHEET);
    }

    @Override
    public boolean saveSheet(SheetDto dto) throws Exception {
        
        boolean result = sheetBO.saveSheet(dto);
        notifyObservers();
        return result;
    }

    @Override
    public List<SheetDto> getAllSheets() throws Exception {
        return sheetBO.getAllSheets();

    }

    @Override
    public List<SheetDto> getAllTrainSheets(Object[] ob) throws Exception {
        return sheetBO.getAllTrainSheets(ob);
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
    public boolean updateSheet(SheetDto dto) throws Exception {
        boolean result = sheetBO.updateSheet(dto);
        notifyObservers();
        return result;
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
    public List<SheetDto> getAllSeatsInDate(Object[] o) throws Exception {
        return sheetBO.getAllSeatsInDate(o);
    }

    @Override
    public int getCountAllCount(Object[] all) throws Exception {
         return sheetBO.getCountAllCount(all);
    }

}
