/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.services.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.SuperService;
import lk.ijse.rtrsc.services.custom.impl.DayServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.IDServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.PriceServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.ReservationServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.RouteServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.SheetServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.StationServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.TrainServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.UserServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.ViewTrainsServiceImpl;
import lk.ijse.rtrsc.services.custom.impl.WagonServiceImpl;

/**
 *
 * @author Gnanod-PC
 */
public class ServiceFactoryImpl extends UnicastRemoteObject implements ServiceFactory {

    public static ServiceFactory serviceFactory;

    private ServiceFactoryImpl() throws RemoteException {

    }

    public static ServiceFactory getInstance() throws RemoteException {
        if (serviceFactory == null) {
            serviceFactory = new ServiceFactoryImpl();
        }
        return serviceFactory;
    }

    @Override
    public SuperService getService(ServiceTypes serviceTypes) throws Exception {
        System.out.println("rrrrrrrr");
        switch (serviceTypes) {

            case USER:
                return new UserServiceImpl();
            case TRAIN:
                return new TrainServiceImpl();
            case WAGON:
                return new WagonServiceImpl();
            case ROUTE:
                return new RouteServiceImpl();
            case STATION:
                return new StationServiceImpl();
            case PRICE:

                return new PriceServiceImpl();
            case VIEWTRAINS:
                return new ViewTrainsServiceImpl();
            case SHEET:
                return new SheetServiceImpl();
            case RESERVATION:
                return new ReservationServiceImpl();
            case DAY:
                return new DayServiceImpl();
            case ID:
                return new IDServiceImpl();
            default:
                return null;
        }
    }

}
