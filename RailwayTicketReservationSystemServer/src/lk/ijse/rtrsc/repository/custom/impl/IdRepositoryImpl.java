/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.dto.IdDto;
import lk.ijse.rtrsc.entity.DayEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.IdRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class IdRepositoryImpl extends SuperRepositoryImpl<Object, String> implements IdRepository{

    public IdRepositoryImpl(){
    
    }
    private Session session;

    @Override
    public Object getResult(IdDto idDTO) throws Exception {
        
        return session.createSQLQuery("select " + idDTO.getColName() + " from " + idDTO.getEntityName() + " order by 1 desc limit 1;").uniqueResult();
    }

    @Override
    public void setSessions(Session session) throws Exception {
         this.session= session;
    }
    
}
