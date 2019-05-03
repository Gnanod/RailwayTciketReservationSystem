/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.controller;

import java.util.List;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.observer.Subject;
import lk.ijse.rtrsc.proxy.ProxyHandler;
import lk.ijse.rtrsc.service.ServiceFactory;
import lk.ijse.rtrsc.service.custom.SheetService;

/**
 *
 * @author Gnanod-PC
 */
public class ManageSheetController {

    public static boolean saveSheet(SheetDto dto) throws Exception {
        SheetService service = (SheetService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SHEET);

        return service.saveSheet(dto);
    }

    public static List<SheetDto> getAllSheets() throws Exception {
        SheetService service = (SheetService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SHEET);
        return service.getAllSheets();
    }

    public static List<SheetDto> getAllTrainSheets(Object[] ob) throws Exception {
        SheetService service = (SheetService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SHEET);
        return service.getAllTrainSheets(ob);
    }

    public static boolean updateSheet(SheetDto dto) throws Exception {
        SheetService service = (SheetService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SHEET);
        return service.updateSheet(dto);
    }

    public static Subject getSubject() throws Exception {
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SHEET);
    }

    public static List<SheetDto> getAllSeatsInDate(Object[] o) throws Exception {
        SheetService service = (SheetService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SHEET);
        return service.getAllSeatsInDate(o);
    }

    public static int getCountAllCount(Object[] all) throws Exception {
         SheetService service = (SheetService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceTypes.SHEET);
        return service.getCountAllCount(all);
    }
}
