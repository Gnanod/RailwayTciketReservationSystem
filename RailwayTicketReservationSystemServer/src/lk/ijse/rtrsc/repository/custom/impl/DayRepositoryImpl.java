/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.entity.DayEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.DayRepository;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class DayRepositoryImpl extends SuperRepositoryImpl<DayEntity, String> implements DayRepository{

    private Session session;
    @Override
    public void setSessions(Session session) {
        this.session= session;
    }



    @Override
    public List<Object[]> getDays(String dayId) throws Exception {
        List<Object []> entity = session.createSQLQuery("select Friday,monday,holyDay,Saturday,sunday,thursday,tuesday,Wednesday from dayentity where dateId='"+dayId+"'").list();
       // System.out.println("oooooRewnj"+day);
        return entity;
    }

   
    
}
