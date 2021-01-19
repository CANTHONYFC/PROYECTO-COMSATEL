package comsatel.spring.boot;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import net.royal.spring.framework.core.UFile;
import net.royal.spring.framework.util.UPropiedades;
import net.royal.spring.framework.web.boot.ConstanteBoot;
import net.royal.spring.framework.web.boot.GenericoSecurityFilterPublic;
/**
 * Hello world!
 *
 */

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
@ComponentScan({ "comsatel.spring" })
public class App extends SpringBootServletInitializer {
	private static Logger logger = LogManager.getLogger(App.class);

	public static void main(String[] args) throws IOException {
		String recursoRuta = UFile.rutaFisicaWebServer() + File.separator + ConstanteBoot.CARPETA_PROPERTIES;
		Properties recursoPropiedad = UPropiedades.getInstance().abrir(recursoRuta, ConstanteBoot.PROPERTIES_GLOBAL);
		SpringApplication app = new SpringApplication(App.class);
//		app.setDefaultProperties(Collections.singletonMap(ConstanteBoot.SERVER_PORT,
//				recursoPropiedad.getProperty("port."+ComsatelConstanteBoot.NOMBRE)));
		recursoPropiedad.setProperty(ConstanteBoot.SERVER_PORT, recursoPropiedad.getProperty("port."+ComsatelConstanteBoot.NOMBRE));

		app.setDefaultProperties(recursoPropiedad);
		app.run(args);

		logger.debug("COMSATEL CORE : INICIADO");
	}


	
	@Bean
	public Jackson2ObjectMapperBuilderCustomizer init() {
		return new Jackson2ObjectMapperBuilderCustomizer() {
			public void customize(Jackson2ObjectMapperBuilder builder) {
				builder.timeZone(TimeZone.getDefault());
			}
		};
	}

}
