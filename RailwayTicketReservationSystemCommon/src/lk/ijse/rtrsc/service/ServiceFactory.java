/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service;

import java.rmi.Remote;

/**
 *
 * @author Gnanod-PC
 */
public interface ServiceFactory extends Remote {

    public enum ServiceTypes {
        USER,TRAIN,WAGON,ROUTE,STATION,PRICE,VIEWTRAINS,SHEET,RESERVATION,DAY,ID
    }
    public SuperService getService(ServiceTypes serviceTypes)throws Exception;
}
