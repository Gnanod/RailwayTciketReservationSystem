/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.rtrsc.resource;

import java.io.File;
import lk.ijse.rtrsc.entity.DayEntity;
import lk.ijse.rtrsc.entity.PassengerEntity;
import lk.ijse.rtrsc.entity.PaymentEntity;
import lk.ijse.rtrsc.entity.PriceEntity;
import lk.ijse.rtrsc.entity.ReservationEntity;
import lk.ijse.rtrsc.entity.ReservationSheetDetailentity;
import lk.ijse.rtrsc.entity.ReservationWagonDetailEntity;

import lk.ijse.rtrsc.entity.RouteEntity;
import lk.ijse.rtrsc.entity.StationEntity;
import lk.ijse.rtrsc.entity.StationRoutesDetailEntity;
import lk.ijse.rtrsc.entity.TrainEntity;
import lk.ijse.rtrsc.entity.UserEntity;
import lk.ijse.rtrsc.entity.ViewWagonEntity;
import lk.ijse.rtrsc.entity.SheetEntity;
import lk.ijse.rtrsc.entity.WagonDetailEntity;
import lk.ijse.rtrsc.entity.WagonEntity;
import lk.ijse.rtrsc.reservation.Reservation;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 *
 * @author Gnanod-PC
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;

    private static StandardServiceRegistry registry;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.

            // (1) 
            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();

            // (2)
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(UserEntity.class)
                    .addAnnotatedClass(TrainEntity.class)
                    .addAnnotatedClass(WagonDetailEntity.class)
                    .addAnnotatedClass(WagonEntity.class)
                    .addAnnotatedClass(DayEntity.class)
                    .addAnnotatedClass(RouteEntity.class)
                    .addAnnotatedClass(StationRoutesDetailEntity.class)
                    .addAnnotatedClass(StationEntity.class)
                    .addAnnotatedClass(ViewWagonEntity.class)
                    .addAnnotatedClass(PriceEntity.class)
                    .addAnnotatedClass(SheetEntity.class)
                    .addAnnotatedClass(PassengerEntity.class)
                    .addAnnotatedClass(PaymentEntity.class)
                    .addAnnotatedClass(ReservationEntity.class)
                 //   .addAnnotatedClass(ReservationWagonDetailEntity.class)
                    .addAnnotatedClass(ReservationSheetDetailentity.class)
                    .buildMetadata().buildSessionFactory();

        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            System.out.println("ttttttttttttttttttttttttttttt");
            StandardServiceRegistryBuilder.destroy(registry);

            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
