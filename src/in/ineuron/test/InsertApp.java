package in.ineuron.test;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.entity.Employee;
import in.ineuron.util.HibernateUtil;

public class InsertApp {

	public static void main(String[] args) {

		Session session = null;
		Transaction transaction = null;
		boolean flag = false;
		try {
			
			//PK generation will not support in this case, becoz parent class table will not be created
			session = HibernateUtil.getSession();
			transaction = session.beginTransaction();
			
			Employee employee = new Employee();
			
			employee.setEname("Sagar");
			employee.setFriendList(List.of("Raj","Ram","Rambo"));
			employee.setPhNo(Set.of(1234233312L,126837468L, 8734682373L));
			employee.setBankAcc(Map.of("HDFC",8734682L, "ICICI",28734827348L, "BOD", 874682473L));
			
			session.save(employee);
			
			flag = true;

		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				transaction.commit();
				System.out.println("Records inserted successfully");
			} else {
				transaction.rollback();
				System.out.println("Failed to insert");
			}

			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}

}
