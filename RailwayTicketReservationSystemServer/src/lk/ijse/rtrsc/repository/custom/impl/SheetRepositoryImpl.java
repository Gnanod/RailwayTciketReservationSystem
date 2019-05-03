/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.math.BigInteger;
import java.util.List;
import lk.ijse.rtrsc.entity.SheetEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.SheetRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class SheetRepositoryImpl extends SuperRepositoryImpl<SheetEntity, Integer> implements SheetRepository {

    private Session session;

    @Override
    public void setSessions(Session session) throws Exception {
        this.session = session;
    }

    @Override
    public List<Object[]> getAllTrainSheets(Object[] ob) throws Exception {
        List<Object[]> entity = session.createSQLQuery("select sheetType,status,wagonEntity_wagonId,sheetId from wagondetailentity wd,sheetentity s where wd.wagonId=s.wagonEntity_wagonId && wd.trainId='" + ob[0] + "' && s.wagonEntity_wagonId='" + ob[1] + "';").list();
        System.out.println("8888888888" + entity);
        return entity;
    }

    @Override
    public List<Object[]> ViewSheets(Object sheet1) throws Exception {
        List<Object[]> entity = session.createSQLQuery(" select sheetType,status, wagonEntity_wagonId,sheetID from sheetentity where  sheetID='" + sheet1 + "'").list();
        return entity;
    }

    @Override
    public List<Object[]> getAllSeatsInDate(Object[] o) throws Exception {

        BigInteger ob = (BigInteger) session.createSQLQuery("select  count(rs.sheetID) from  reservationsheetdetailentity rs,reservationentity r, sheetentity s where rs.reservationId = r.reservationId && rs.sheetID=s.sheetID &&date='" + o[1] + "' && routeEntity_routeId='" + o[0] + "'").list().get(0);
        System.out.println("uuuuuuuuuuuuuuuu"+ob.intValue());
        List<Object[]> entity = null;
        if (ob.intValue() != 0) {
            entity = session.createSQLQuery("select rs.sheetID , sheetType, count(rs.sheetID) from  reservationsheetdetailentity rs,reservationentity r, sheetentity s where rs.reservationId = r.reservationId && rs.sheetID=s.sheetID &&date='" + o[1] + "' && routeEntity_routeId='" + o[0] + "'").list();

        }
       
        //System.out.println("obbbb"+ob.size());
        // if (ob.size() > 0) {
        return entity;
        // }else{
        //  return null;
        //}
//        System.out.println("777777777777" + entity);
//        if (entity == null) {
//            System.out.println("uuuuuuuuuuu");
//        }
//        return entity;
    }

    @Override
    public int getAllCount(Object[] o) throws Exception {
        BigInteger ob = (BigInteger) session.createSQLQuery("select count(r.reservationId) from reservationentity r,reservationsheetdetailentity rs where r.reservationId=rs.reservationId && rs.sheetID='"+o[0]+"' && r.date='"+o[1]+"'").list().get(0);
        return ob.intValue();

    }

}
