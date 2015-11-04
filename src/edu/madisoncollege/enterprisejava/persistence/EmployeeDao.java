package edu.madisoncollege.enterprisejava.persistence;

import edu.madisoncollege.enterprisejava.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Dave on 11/4/2015.
 */

public class EmployeeDao {

    /* Method to CREATE a employee in the database */
    public Integer addEmployee(Employee employee) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer employeeId = null;
        try {
            tx = session.beginTransaction();
            employeeId = (Integer) session.save(employee);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employeeId;
    }
}