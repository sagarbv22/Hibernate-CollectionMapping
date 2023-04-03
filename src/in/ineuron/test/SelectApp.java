package in.ineuron.test;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import in.ineuron.entity.Employee;
import in.ineuron.util.HibernateUtil;

public class SelectApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		Integer id = 1;
		try {

			session = HibernateUtil.getSession();

			Employee employee = session.get(Employee.class, 1);

			System.out.println(employee);

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
