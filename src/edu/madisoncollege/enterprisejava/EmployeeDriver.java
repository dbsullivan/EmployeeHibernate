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

// dao.addEmployee
        Employee employee = new Employee(0, "Dean", "Martin","222-33-4444","ET","100","4148887771");
        dao.addEmployee(employee);
// dao.getEmployee
        System.out.println("Returned Employee: " + dao.getEmployee(109));
// dao.getAllEmployees
        System.out.println(dao.getAllEmployees());
// dao.updateEmployeeLastName
        dao.updateEmployeeLastName(116, "Tillman-Spillman");
// dao.deleteEmployee
        dao.deleteEmployee(101);
// final Employees list After dao transactions have been run:
        System.out.println("After, 116 new name, 101 deleted, new Dean Martin: " + dao.getAllEmployees());

    }
}
