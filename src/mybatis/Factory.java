package mybatis;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Factory {
	private static SqlSessionFactory factory;

	//스태틱
	static {
		try {
			Reader r = Resources.getResourceAsReader("config.xml");
			factory = new SqlSessionFactoryBuilder().build(r);
			System.out.println("factory 가능");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args) {
		Factory.getFactory();
	}

	public static SqlSessionFactory getFactory() {
		return factory;
	}
	

}
