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
import lk.ijse.rtrsc.bussiness.custom.PriceBO;
import lk.ijse.rtrsc.bussiness.custom.impl.PriceBOImpl;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.service.custom.PriceService;

/**
 *
 * @author Gnanod-PC
 */
public class PriceServiceImpl  extends UnicastRemoteObject implements PriceService,Subject{
    private PriceBO priceBO;
     private static ArrayList<Observer> observerList = new ArrayList<>();
    public PriceServiceImpl()throws RemoteException{
        priceBO=(PriceBOImpl) BOFactory.getInstance().getBO(BOFactory.BoTypes.PRICE);
       
    }

    @Override
    public boolean addPrice(PricaeDto priceD) throws Exception {
        
      boolean result = priceBO.addPrice(priceD);
      notifyObservers();
      return result;
    }

    @Override
    public List<PricaeDto> getAllPrices() throws Exception {
       return priceBO.getAllPrices();
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
    public boolean deletePrices(String deletePrice) throws Exception {
        boolean result = priceBO.deletePrices(deletePrice);
        notifyObservers();
        return result;
        
    }

    @Override
    public boolean updatePrice(PricaeDto priceD) throws Exception {
       boolean result = priceBO.updatePrice(priceD);
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
    public PricaeDto searchPrice(Object[] search) throws Exception {
        return priceBO.searchPrice(search);
    }
    
}
