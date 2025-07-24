package springcore;

import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main{
	public static void main(String[] args) {
		ApplicationContext app= new ClassPathXmlApplicationContext("beans.xml");
		//ApplicationContext app = new AnnotationConfigApplicationContext(Config.class);
		
//		Viettel v = app.getBean(Viettel.class);
//		v.call();
		JDBCUtil u = app.getBean("jdbc", JDBCUtil.class);
		try {
			u.test1();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Transaction.testTransaction(u);
	
	}

}
