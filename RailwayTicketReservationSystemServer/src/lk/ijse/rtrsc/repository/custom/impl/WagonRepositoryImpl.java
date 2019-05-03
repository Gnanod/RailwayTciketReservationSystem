/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.entity.WagonEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.WagonRepository;
import org.hibernate.Session;


/**
 *
 * @author Gnanod-PC
 */
public class WagonRepositoryImpl extends SuperRepositoryImpl<WagonEntity, String> implements WagonRepository  {
    
    private Session session;
    @Override
    public void setSessions(Session session) {
        this.session = session;
    }

    @Override
    public List<Object[]> getWagon(Object[] ob) {
         List<Object []> entity = session.createSQLQuery("select w.wagonId, w.classType,w.sheetQuantity  from wagondetailentity wd ,wagonentity w where wd.wagonId=w.wagonId && w.classType='"+ob[1]+"' && wd.trainId='"+ob[0]+"'").list();
        return entity;
    }
    
}
