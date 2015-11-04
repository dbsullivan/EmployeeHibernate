package edu.madisoncollege.enterprisejava.persistence;

import edu.madisoncollege.enterprisejava.entity.Employee;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

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


    /* Method to READ an employee in the database */
    public Employee getEmployee(int employeeId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Employee employee = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(Employee.class);
            criteria.add(Restrictions.eq("id", employeeId));
            employee = (Employee) criteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employee;
    }

    /* Method to READ all the employees in the database */
    public List<Employee> getAllEmployees() {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<Employee> employees = new ArrayList<Employee>();
        try {
            tx = session.beginTransaction();
            //org.hibernate.hql.internal.ast.QuerySyntaxException: employees is not mapped [FROM employees]
//            employees = session.createQuery("FROM employees").list(); // error, fully qualified class name
            employees = (List<Employee>) session.createQuery("FROM edu.madisoncollege.enterprisejava.entity.Employee").list();
                tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return employees;
    }

    /* Method to UPDATE last name for an employee */
    public void updateEmployeeLastName(int employeeId, String lastName ){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee =
                    (Employee)session.get(Employee.class, employeeId);
            employee.setLastName(lastName);
            session.update(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /* Method to DELETE an employee */
    public void deleteEmployee(int employeeId){
        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            Employee employee =
                    (Employee)session.get(Employee.class, employeeId);
            session.delete(employee);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }


}