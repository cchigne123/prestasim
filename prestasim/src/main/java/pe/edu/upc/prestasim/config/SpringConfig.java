package pe.edu.upc.prestasim.config;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import pe.edu.upc.prestasim.dao.UsuarioDao;
import pe.edu.upc.prestasim.utils.Constants;

@Configuration
@EnableAsync
@EnableWebMvc
public class SpringConfig {

	@Bean
	public DataSource dataSource() {
	    Context objCtx;
	    DataSource objDt = null;
	    try {
			objCtx = new InitialContext();
			objDt = (DataSource) objCtx.lookup("java:comp/env/jdbc/mysqlds");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	    return objDt;
	}

	@Bean(name="transactionManager")
	public DataSourceTransactionManager transactionManager() {
	    return new DataSourceTransactionManager(dataSource());
	}

	public SqlSessionFactory sqlSessionFactory() throws Exception {
	   SqlSessionFactoryBean objSessionFactory = new SqlSessionFactoryBean();
	   objSessionFactory.setDataSource(dataSource());
	   objSessionFactory.setConfigLocation(new ClassPathResource("mybatis-config.xml"));
	   return objSessionFactory.getObject();
	}

	public void configureMessageConverters(List<HttpMessageConverter<?>> lstConverters) {
		Jackson2ObjectMapperBuilder objBuilder = new Jackson2ObjectMapperBuilder();
		objBuilder.indentOutput(true).dateFormat(new SimpleDateFormat(Constants.STR_DATE_FORMAT_YYYY_MM_DD));
		lstConverters.add(new MappingJackson2HttpMessageConverter(objBuilder.build()));
	}
	
	@Bean
	public UsuarioDao usuarioDao() throws Exception {
		@SuppressWarnings("resource")
		SqlSessionTemplate objSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		UsuarioDao objMapper = objSessionTemplate.getMapper(UsuarioDao.class);
		return objMapper;
	}

}
