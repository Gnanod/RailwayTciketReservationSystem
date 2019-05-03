/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.proxy;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.SuperService;
import lk.ijse.rtrsc.service.custom.DayService;
import lk.ijse.rtrsc.service.custom.IdService;
import lk.ijse.rtrsc.service.custom.PriceService;
import lk.ijse.rtrsc.service.custom.ReservationService;
import lk.ijse.rtrsc.service.custom.RouteService;
import lk.ijse.rtrsc.service.custom.SheetService;
import lk.ijse.rtrsc.service.custom.StationService;
import lk.ijse.rtrsc.service.custom.TrainService;
import lk.ijse.rtrsc.service.custom.UserService;
import lk.ijse.rtrsc.service.custom.ViewTrainsService;
import lk.ijse.rtrsc.service.custom.WagonService;




/**
 *
 * @author Gnanod-PC
 */
public class ProxyHandler implements ServiceFactory{

    private static ProxyHandler proxyHandler;
     private ServiceFactory serviceFactory;
     private UserService userService;
     private TrainService trainService;
     private WagonService wagonService;
     private RouteService routeService;
     private StationService stationService;
     private PriceService priceService;
     private ViewTrainsService viewTrainsService;
     private SheetService sheetService;
     private ReservationService reservationService;
     private DayService dayService;
     private IdService idService;
    public ProxyHandler() {
        try {
           serviceFactory =  (ServiceFactory) Naming.lookup("rmi://localhost:5050/TrainReservationSystem");
           userService = (UserService) serviceFactory.getService(ServiceTypes.USER);
           trainService = (TrainService) serviceFactory.getService(ServiceTypes.TRAIN);
           wagonService =(WagonService) serviceFactory.getService(ServiceTypes.WAGON);
           routeService = (RouteService) serviceFactory.getService(ServiceTypes.ROUTE);
           stationService = (StationService) serviceFactory.getService(ServiceTypes.STATION);
           priceService = (PriceService) serviceFactory.getService(ServiceTypes.PRICE);
           viewTrainsService = (ViewTrainsService) serviceFactory.getService(ServiceTypes.VIEWTRAINS);
           sheetService = (SheetService) serviceFactory.getService(ServiceTypes.SHEET);
           reservationService = (ReservationService) serviceFactory.getService(ServiceTypes.RESERVATION);
           dayService = (DayService) serviceFactory.getService(ServiceTypes.DAY);
           idService = (IdService) serviceFactory.getService(ServiceTypes.ID);
        } catch (NotBoundException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MalformedURLException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (RemoteException ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
     public static ProxyHandler getInstance(){
        if (proxyHandler == null){
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }

    @Override
    public SuperService getService(ServiceTypes serviceTypes) throws Exception {
        switch(serviceTypes){
            case USER :
                return userService;
            case TRAIN:
                return trainService;
            case WAGON:
                return wagonService;
            case ROUTE:
                return routeService;
            case STATION:
                return stationService;
            case PRICE:
                return priceService;
            case VIEWTRAINS:
                return viewTrainsService;
            case SHEET:
                return sheetService;
            case RESERVATION:
                return reservationService;
            case DAY:
                return dayService; 
            case ID:
                return idService;
            default:
                return null;
        }
    }
}
