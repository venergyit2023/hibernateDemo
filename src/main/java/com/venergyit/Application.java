package com.venergyit;


import com.venergyit.employee.Employee;
import hibernate.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.hibernate.SessionFactory;

import java.util.List;

/**
* <li><
 *      1. MySQL driver
 * </li>
 *  <li>
 *      2. Hibernate ORM
 *  </li>
 *  <li>
 *      3. Configuration of ORM - file: resources/hibernate.cfg.xml
 *  </li>
 *  <li>
 *      4. Mapping using XML
 *      table: employees -> Employee.java Mapping rules: Employee.hbm.xml
 *      (which property from Employee.java match to which atribute in table: employees)
 *
 *      4.1. Employee.bhm.xml <-> Employee.java
 *                            <-> employees table
 *  </li>
 *  <li>
 *      5. HibernateUtil -> SessionFactory - Session
 *  </li>
 *
*/
public class Application {

    public static void main(String[] args) {

        try{
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();
            session.getTransaction().begin();
            Query<Employee> query = session.createQuery("from Employee");
            List<Employee> employees = query.getResultList();
            for(Employee employee: employees){
                System.out.println(employee);
            }
            session.getTransaction().commit();
        } catch (HibernateException exception){
            System.err.println(exception.toString());
        }

    }
}
