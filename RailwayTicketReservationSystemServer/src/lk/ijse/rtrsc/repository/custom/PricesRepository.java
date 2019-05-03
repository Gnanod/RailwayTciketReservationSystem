/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom;

import java.util.List;
import lk.ijse.rtrsc.entity.PriceEntity;
import lk.ijse.rtrsc.repository.SuperRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public interface PricesRepository extends SuperRepository<PriceEntity,Integer>{

    public void setSessionss(Session session)throws Exception;

    public List<Object[]> searchPrice(Object[] search)throws Exception;
    
}
