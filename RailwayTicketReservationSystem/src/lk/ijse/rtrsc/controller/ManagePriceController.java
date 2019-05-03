/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import java.util.List;
import lk.ijse.rtrsc.dto.PricaeDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.PriceService;

/**
 *
 * @author Gnanod-PC
 */
public class ManagePriceController {

    public static boolean addPrice(PricaeDto priceD) throws Exception {
        PriceService priceService = (PriceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PRICE);
       
        return priceService.addPrice(priceD);
    }

    public static List<PricaeDto> getAllPrices() throws Exception {
          PriceService priceService = (PriceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PRICE);
       
        return priceService.getAllPrices();
    }

    public static boolean deletePrices(String deletePrice) throws Exception {
          PriceService priceService = (PriceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PRICE);
       
        return priceService.deletePrices(deletePrice);
    }

    public static boolean updatePrice(PricaeDto priceD) throws Exception {
        PriceService priceService = (PriceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PRICE);       
        return priceService.updatePrice(priceD);
    }
     public static Subject getSubject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PRICE);
    }

    public static PricaeDto searchPrice(Object[] search) throws Exception {
        PriceService priceService = (PriceService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.PRICE);       
        return priceService.searchPrice(search);
    }
}
