/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.repository.custom.impl;


import java.util.List;
import lk.ijse.rtrsc.entity.UserEntity;
import lk.ijse.rtrsc.repository.SuperRepositoryImpl;
import lk.ijse.rtrsc.repository.custom.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

/**
 *
 * @author Gnanod-PC
 */
public class UserRepositoryImpl extends SuperRepositoryImpl<UserEntity, String> implements UserRepository  {

    private Session session;
    @Override
    public void setSessions(Session session) throws Exception {
        this.session= session;
    }

    @Override
    public List<Object[]> searchPasssword(UserEntity userEntity) throws Exception {
        
        List<Object []> entity = session.createSQLQuery("select userId,userType,userAddress from userentity where userId='"+userEntity.getUserId()+"'&& userPassword='"+userEntity.getUserPassword()+"'").list();
        
        return entity;
   
    }
    
}
