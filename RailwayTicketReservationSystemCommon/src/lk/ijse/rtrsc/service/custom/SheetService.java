/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service.custom;

import java.util.List;
import lk.ijse.rtrsc.dto.SheetDto;
import lk.ijse.rtrsc.service.SuperService;

/**
 *
 * @author Gnanod-PC
 */
public interface SheetService extends SuperService{

    public boolean saveSheet(SheetDto dto)throws Exception;

    public List<SheetDto> getAllSheets()throws Exception;

    public List<SheetDto> getAllTrainSheets(Object[] ob)throws Exception;

    public boolean updateSheet(SheetDto dto)throws Exception;

    public List<SheetDto> getAllSeatsInDate(Object[] o)throws Exception;

    public int getCountAllCount(Object[] all)throws Exception;

   
    
}
