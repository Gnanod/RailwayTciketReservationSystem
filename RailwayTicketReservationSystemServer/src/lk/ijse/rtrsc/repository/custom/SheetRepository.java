/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom;

import java.util.List;
import lk.ijse.rtrsc.entity.SheetEntity;
import lk.ijse.rtrsc.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public interface SheetRepository extends SuperRepository<SheetEntity,Integer>{

    public void setSessions(Session session)throws Exception;

    public List<Object[]> getAllTrainSheets(Object[] ob)throws Exception;

    public List<Object[]> ViewSheets(Object sheet1)throws Exception;

    public List<Object[]> getAllSeatsInDate(Object[] o)throws Exception;

    public int getAllCount(Object[] o)throws Exception;

  
    
}
