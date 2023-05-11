package main;

import main.Chatroom;
import org.hibernate.HibernateException;
import org.hibernate.Metamodel;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.metamodel.EntityType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Message.class)
                .buildSessionFactory();

        try{
            Session session = factory.getCurrentSession();
            //Message message = new Message(6, new User(1, "Farhat", "13e42j3ir", new Chatroom(1, "Google", "UUU", "JNJN"), 6), 6, "This is my message from main class", LocalDateTime.now());
            //Message message = new Message(6, new User(6, "JKN", "mK", new Chatroom()))
            session.beginTransaction();
            //session.save(message);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            factory.close();
        }

    }
    /*private static final SessionFactory ourSessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    public static void main(final String[] args) throws Exception {
        final Session session = getSession();
        try {
            System.out.println("querying all the managed entities...");
            final Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                final String entityName = entityType.getName();
                final Query query = session.createQuery("from " + entityName);
                System.out.println("executing: " + query.getQueryString());
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
            }
        } finally {
            session.close();
        }
    }*/
}

