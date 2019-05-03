/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository;

import lk.ijse.rtrsc.repository.custom.impl.DayRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.IdRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.PassengerReservationImpl;
import lk.ijse.rtrsc.repository.custom.impl.PaymentRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.PricesRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.ReservationRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.ReservationWagonDetailRepositoryImpl;

import lk.ijse.rtrsc.repository.custom.impl.RouteRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.SheetRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.SheetReservationRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.StationRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.StationRouteDetailRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.TrainRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.UserRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.ViewTrainsRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.ViewWagonRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.WagonDetailRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.impl.WagonRepositoryImpl;

/**
 *
 * @author Gnanod-PC
 */
public class RepositoryFactory {

    public enum RepositoryTypes {
        USER,TRAIN,WAGON,WAGONDETAIL,ROUTE,DAY,STATION,STATIONROUTE,VIEWWAGON,PRICE,ViewTrains,SHEET,PAYMENT,PASSENGER,RESERVATION,RESERVATIONWAGONDETAIL,ID,RESERVATIONSHEET
    }
    public static RepositoryFactory repositoryFactory;

    public RepositoryFactory() {
    }

    public static RepositoryFactory getInstance() {
        if (repositoryFactory == null) {
            repositoryFactory = new RepositoryFactory();
        }
        return repositoryFactory;
    }

    public SuperRepository getRepository(RepositoryTypes type) {
        System.out.println("enum");
        switch (type) {
            case USER:
                return new UserRepositoryImpl();
            case TRAIN:
                return new TrainRepositoryImpl();
            case WAGON:
                return new WagonRepositoryImpl();
            case WAGONDETAIL:
                return new WagonDetailRepositoryImpl();
            case ROUTE:
                return new RouteRepositoryImpl();
            case DAY:
                return new DayRepositoryImpl();
            case STATION:
                return new StationRepositoryImpl();
            case STATIONROUTE:
                return new StationRouteDetailRepositoryImpl();
            case VIEWWAGON:
                return new ViewWagonRepositoryImpl();
            case PRICE:
                return new PricesRepositoryImpl();
            case ViewTrains:
                return new ViewTrainsRepositoryImpl();
            case SHEET:
                return new SheetRepositoryImpl();
            case RESERVATION:
                return new ReservationRepositoryImpl();
            case PAYMENT:
                return new PaymentRepositoryImpl();
            case PASSENGER:
                return new PassengerReservationImpl();
            case RESERVATIONWAGONDETAIL:
                return new ReservationWagonDetailRepositoryImpl();
            case ID:
                return new IdRepositoryImpl();
            case RESERVATIONSHEET:
                return new SheetReservationRepositoryImpl();
            default:
                return null;

        }
    }
}
