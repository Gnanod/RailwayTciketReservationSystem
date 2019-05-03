/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.dto.ViewWagonDto;
import lk.ijse.rtrsc.entity.ViewWagonEntity;
import lk.ijse.rtrsc.entity.WagonDetailEntity;
import lk.ijse.rtrsc.entity.WagonEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.ViewWagonRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class ViewWagonRepositoryImpl extends SuperRepositoryImpl<ViewWagonEntity, String> implements ViewWagonRepository {

    private Session session;

    @Override
    public void setSessionS(Session session) throws Exception {
        this.session = session;
    }

    @Override
    public List<Object []> ViewAllWagons() throws Exception {
        List<Object []> entity = session.createSQLQuery("SELECT w.wagonId, classType,sheetQuantity, trainId FROM wagonentity w, wagondetailentity d WHERE w.wagonId = d.wagonId").list();
        return entity;
    }

    @Override
    public List<Object[]> searchWagons(String wagon) throws Exception {
       List<Object []> entity = session.createSQLQuery("SELECT classType,sheetQuantity, trainId FROM wagonentity w, wagondetailentity d WHERE w.wagonId = d.wagonId && w.wagonId='"+wagon+"' ").list();
        return entity;
    }

}
