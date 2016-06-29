package ro.sci.ems;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ro.sci.ems.dao.EmployeeDAO;
import ro.sci.ems.dao.db.JDBCEmployeeDAO;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	}
	
	@Bean
	public EmployeeDAO employeeDao() {
	
		String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String username = System.getenv("JDBC_DATABASE_USERNAME");
        String password = System.getenv("JDBC_DATABASE_PASSWORD");
        return new JDBCEmployeeDAO(dbUrl,
				"5432","d7e9jnjjfhhoip" ,username,
				password);
				
				
				
	}
//	 @Bean
//	    public BasicDataSource dataSource() throws URISyntaxException {
//	        String dbUrl = System.getenv("JDBC_DATABASE_URL");
//	        String username = System.getenv("JDBC_DATABASE_USERNAME");
//	        String password = System.getenv("JDBC_DATABASE_PASSWORD");
//
//	        BasicDataSource basicDataSource = new BasicDataSource();
//	        basicDataSource.setUrl(dbUrl);
//	        basicDataSource.setUsername(username);
//	        basicDataSource.setPassword(password);
//
//	        return basicDataSource;
//	    }
}
