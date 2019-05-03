/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.bussiness.custom.impl;

import com.sun.corba.se.impl.orbutil.RepositoryIdFactory;
import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;
import java.util.ArrayList;
import java.util.List;
import lk.ijse.rtrsc.bussiness.custom.DayBO;
import lk.ijse.rtrsc.dto.DayDto;
import lk.ijse.rtrsc.entity.DayEntity;
import lk.ijse.rtrsc.repository.RepositoryFactory;
import lk.ijse.rtrsc.repository.custom.DayRepository;
import lk.ijse.rtrsc.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Gnanod-PC
 */
public class DayBOImpl implements DayBO {

    private DayRepository dayRepository;

    public DayBOImpl() {
        dayRepository = (DayRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.DAY);
    }

    @Override
    public DayDto getDay(String dayId) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            dayRepository.setSessions(session);
            session.beginTransaction();
            List<Object[]> day = dayRepository.getDays(dayId);
            session.getTransaction().commit();
            if (day != null) {
                // List<DayDto> alDays = new ArrayList<>();
                DayDto dto = null;
                for (Object[] ob : day) {
                    dto = new DayDto();
                
                    dto.setFriday((boolean) ob[0]);
                    dto.setHoliday((boolean) ob[2]);
                    dto.setMonday((boolean) ob[1]);
                    dto.setSaturday((boolean) ob[3]);
                    dto.setSunday((boolean) ob[4]);
                    dto.setThursday((boolean) ob[5]);
                    dto.setTuesday((boolean) ob[6]);
                    dto.setWednesday((boolean) ob[7]);
                }
                return dto;
            } else {
                return null;
            }
        }
    }

}
