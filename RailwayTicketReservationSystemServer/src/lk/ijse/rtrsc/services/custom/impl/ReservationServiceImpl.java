/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.services.custom.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.rtrsc.bussiness.BOFactory;
import lk.ijse.rtrsc.bussiness.custom.ReservationBO;
import lk.ijse.rtrsc.bussiness.custom.impl.ReservationBOImpl;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.dto.ReservationTransactionDto;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.observer.Observer;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.reservation.impl.ReservationImpl;
import lk.ijse.rtrsc.service.custom.PriceService;
import lk.ijse.rtrsc.service.custom.ReservationService;

/**
 *
 * @author Gnanod-PC
 */
public class ReservationServiceImpl extends UnicastRemoteObject implements ReservationService,Subject {

    private ReservationBO reservationBO;
    private static ReservationImpl<ReservationService> resSheet = new ReservationImpl<>();
    private static ArrayList<Observer> observerList = new ArrayList<>();

    public ReservationServiceImpl() throws RemoteException {
        reservationBO = (ReservationBOImpl) BOFactory.getInstance().getBO(BOFactory.BoTypes.RESERVATION);
    }

    @Override
    public boolean addReservation(ReservationTransactionDto f) throws Exception {
       boolean result= reservationBO.addResrvation(f);
       notifyObservers();
       return result;
    }

    @Override
    public SheetDto getAllSheets(Object sheet1) throws Exception {
        return reservationBO.getAllSheets(sheet1);
    }

    @Override
    public boolean reserve(Object id) throws Exception {
         return resSheet.reserve(id, this, false);
    }

    @Override
    public boolean release(Object id) throws Exception {
        return resSheet.release(id);
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
