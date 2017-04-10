package config.web;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import config.CoreConfiguration;


/*
 * Servlet container scans to find this class.
 * This class in turn configures two(2) contexts 
 * using @Configuration classes: web and core.
 */
public class ServletConfig extends AbstractAnnotationConfigDispatcherServletInitializer {
	
	@Override
	protected String[] getServletMappings() {
		System.out.println("\n\n>>>>>>servlet config>>>>>\n\n");
		return new String[] { "/" };
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { CoreConfiguration.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfiguration.class };
	}
}
