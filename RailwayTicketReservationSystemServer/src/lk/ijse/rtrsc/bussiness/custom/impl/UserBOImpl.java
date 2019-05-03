/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.UserBO;
import lk.ijse.rtrsc.dto.UserDto;
import lk.ijse.rtrsc.entity.UserEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.UserRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class UserBOImpl implements UserBO {

    private UserRepository userRepository;

    public UserBOImpl() {
        System.out.println("UserBOImpl");
        userRepository = (UserRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.USER);
    }

    @Override
    public boolean addCustomer(UserDto user) throws Exception {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userRepository.setSession(session);

            session.beginTransaction();

            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(user.getUserName());
            userEntity.setUserName(user.getUserId());
            userEntity.setUserAddress(user.getUserAddress());
            userEntity.setUserGender(user.getUserGender());
            userEntity.setUserPassword(user.getUserPassword());
            userEntity.setUserContac(user.getUserContac());
            userEntity.setUserType(user.getUserType());
            boolean result = userRepository.save(userEntity);

            session.getTransaction().commit();

            return result;
        }
    }

    @Override
    public boolean searcgPass(UserDto login) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UserDto searchPasssword(UserDto user) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {

            userRepository.setSessions(session);

            session.beginTransaction();

            UserEntity userEntity = new UserEntity();
            userEntity.setUserId(user.getUserId());
            userEntity.setUserName(user.getUserName());
            userEntity.setUserAddress(user.getUserAddress());
            userEntity.setUserGender(user.getUserGender());
            userEntity.setUserPassword(user.getUserPassword());
            userEntity.setUserContac(user.getUserContac());
            
             List<Object[]> result = userRepository.searchPasssword(userEntity);
             System.out.println("resulttttttttt"+result);
             session.getTransaction().commit();
             if (result != null) {
                UserDto dto = null;
                for (Object[] w : result) {
                    dto = new UserDto();
                    System.out.println("w[000000000000000000]+w[0]");
                     System.out.println("w[000000000000000000]+w[1]");
                   dto.setUserId((String) w[0]);
                   dto.setUserType((String) w[1]);
                   dto.setUserAddress((String) w[2]);
                }
                return dto;
            } else {
                return null;
            }
//            
//            if (result != null) {
//                return result;
//            } else {
//                return null;
//            }
//    return null;
        }

    }

}
