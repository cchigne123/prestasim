package pe.edu.upc.prestasim.config;

import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import pe.edu.upc.prestasim.dao.MasterDao;
import pe.edu.upc.prestasim.dao.SolicitudDao;
import pe.edu.upc.prestasim.dao.UsuarioDao;
import pe.edu.upc.prestasim.utils.Constants;

@Configuration
@EnableWebMvc
@PropertySource({"classpath:conf.properties"})
public class SpringConfig extends WebMvcConfigurerAdapter {

	@Autowired
    private Environment env;

	@Bean(name = "dataSource")
    public BasicDataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        return dataSource;
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

	@Bean
	public MasterDao masterDao() throws Exception {
		@SuppressWarnings("resource")
		SqlSessionTemplate objSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		MasterDao objMapper = objSessionTemplate.getMapper(MasterDao.class);
		return objMapper;
	}

	@Bean
	public SolicitudDao solicitudDao() throws Exception {
		@SuppressWarnings("resource")
		SqlSessionTemplate objSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
		SolicitudDao objMapper = objSessionTemplate.getMapper(SolicitudDao.class);
		return objMapper;
	}

}
