package edu.madisoncollege.enterprisejava;

import java.util.List;
import java.util.Date;
import java.util.Iterator;

import edu.madisoncollege.enterprisejava.entity.Employee;
import edu.madisoncollege.enterprisejava.persistence.EmployeeDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Dave on 11/4/2015.
 */

public class EmployeeDriver {
    public static void main(String[] args) {
        EmployeeDao dao = new EmployeeDao();
        Employee employee = new Employee(0, "Dean", "Martin","222-33-4444","ET","100","4148887771");
        dao.addEmployee(employee);
    }
}
