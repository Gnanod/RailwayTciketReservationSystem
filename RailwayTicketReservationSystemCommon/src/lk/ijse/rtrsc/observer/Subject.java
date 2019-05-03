/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.observer;

import java.rmi.Remote;

/**
 *
 * @author Gnanod-PC
 */
public interface Subject extends Remote{
     public boolean registerObserver(Observer observer) throws Exception;
    
    public boolean unregisterObserver(Observer observer) throws Exception;
    
    public void notifyObservers() throws Exception;
}
