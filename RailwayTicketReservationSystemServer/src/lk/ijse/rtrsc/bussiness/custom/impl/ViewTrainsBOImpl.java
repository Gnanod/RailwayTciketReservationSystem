/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.ViewTrainsBO;
import lk.ijse.rtrsc.dto.ViewTrainsDto;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.ViewTrainsRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class ViewTrainsBOImpl implements ViewTrainsBO {

    private ViewTrainsRepository viewTrainsRepository;

    public ViewTrainsBOImpl() {
        viewTrainsRepository = (ViewTrainsRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ViewTrains);
    }

    @Override
    public ViewTrainsDto searchTrains(Object[] ob) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            viewTrainsRepository.setSessions(session);
            session.beginTransaction();
          
            List< Object[]> trains = viewTrainsRepository.ViewTrains(ob);

            session.getTransaction().commit();
            if (trains != null) {
                ViewTrainsDto dto = null;
                for (Object[] w : trains) {
                    dto = new ViewTrainsDto();
                    dto.setRouteName((String) w[0]);
                    dto.setDepaturetime((String) w[1]);
                    dto.setTrainType((String)w[2]);
                }
                return dto;
            } else {
                return null;
            }
        }
    }

}
