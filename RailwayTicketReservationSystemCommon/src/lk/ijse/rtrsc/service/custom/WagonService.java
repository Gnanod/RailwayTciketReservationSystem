/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.service.custom;

import java.util.List;
import lk.ijse.rtrsc.dto.ViewWagonDto;
import lk.ijse.rtrsc.dto.Wagon;
import lk.ijse.rtrsc.dto.WagonDto;
import lk.ijse.rtrsc.service.SuperService;

/**
 *
 * @author Gnanod-PC
 */
public interface WagonService extends SuperService{

    public boolean addWagon(Wagon w)throws Exception;

    public List<ViewWagonDto> ViewAllWagons()throws Exception;

    public boolean deleteWagon(String wagonId)throws Exception;

    public boolean updateWagon(WagonDto wagon)throws Exception;

    public List<ViewWagonDto> searchWagon(String wagon)throws Exception;

    public List<WagonDto> getWagon(Object[] ob)throws Exception;

    public WagonDto searchWagons(String wagonId)throws Exception;

 

  

   
    
}
