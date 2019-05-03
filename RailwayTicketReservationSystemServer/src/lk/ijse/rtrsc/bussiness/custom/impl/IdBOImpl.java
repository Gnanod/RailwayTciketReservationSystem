/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import lk.ijse.rtrsc.bussiness.custom.IdBO;
import lk.ijse.rtrsc.dto.IdDto;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.IdRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class IdBOImpl implements IdBO{
    private IdRepository idRepository;
    public IdBOImpl() {
        idRepository = (IdRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ID);
    }

    
    @Override
    public String getResult(IdDto idDTO) throws Exception {
         try(Session session=HibernateUtil.getSessionFactory().openSession()){
            idRepository.setSessions(session);
            session.beginTransaction();
            session.getTransaction().commit();
            Object lastId=idRepository.getResult(idDTO);
            return lastId.toString();
        }catch(Exception ex){
            //ex.printStackTrace();
            return null;
        }
    }
    
}
