/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness;

import lk.ijse.rtrsc.bussiness.custom.impl.DayBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.IdBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.PriceBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.ReservationBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.RouteBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.SheetBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.StationBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.TrainBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.UserBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.ViewTrainsBOImpl;
import lk.ijse.rtrsc.bussiness.custom.impl.WagonBOImpl;

/**
 *
 * @author Gnanod-PC
 */
public class BOFactory {

    public static BOFactory boFactory;

    public enum BoTypes {
        USER, TRAIN, WAGON, ROUTE, STATION,PRICE,VIEWTRAINS,SHEET,RESERVATION,DAY,ID
    }

    public BOFactory() {
    }

    public static BOFactory getInstance() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }

    public SuperBO getBO(BoTypes type) {
        switch (type) {
            case USER:
                return new UserBOImpl();
            case TRAIN:
                return new TrainBOImpl();
            case WAGON:
                return new WagonBOImpl();
            case ROUTE:
                return new RouteBOImpl();
            case STATION:
                return new StationBOImpl();
            case PRICE:
                return new PriceBOImpl();
            case VIEWTRAINS:
                return new ViewTrainsBOImpl();
            case SHEET:
                return new SheetBOImpl();
            case RESERVATION:
                return new ReservationBOImpl();
            case DAY:
                return new DayBOImpl();
            case ID:
                return new IdBOImpl();
            default:
                return null;
        }
    }
}
