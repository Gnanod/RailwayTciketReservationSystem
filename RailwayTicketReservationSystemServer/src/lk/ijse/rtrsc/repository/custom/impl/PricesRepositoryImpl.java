/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.entity.PriceEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.PricesRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class PricesRepositoryImpl extends SuperRepositoryImpl<PriceEntity,Integer> implements PricesRepository{

    private Session session;
    @Override
    public void setSessionss(Session session) throws Exception {
        this.session = session;
    }

    @Override
    public List<Object[]> searchPrice(Object[] search) throws Exception {
        List<Object []> entity = session.createSQLQuery("select classType,amount from priceentity where trainType='"+search[1]+"' && classType='"+search[0]+"'&& startStation='"+search[2]+"' && endStation='"+search[3]+"'").list();      
        return entity;
    }
    
}
