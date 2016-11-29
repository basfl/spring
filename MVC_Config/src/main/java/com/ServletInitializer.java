package com;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

//WebApplicationInitializer
//AbstractAnnotationConfigDispatcherServletInitializer
public class ServletInitializer implements WebApplicationInitializer {
	// @Override
	// protected Class<?>[] getRootConfigClasses() {
	// return new Class<?>[0];
	// }
	//
	// @Override
	// protected Class<?>[] getServletConfigClasses() {
	// return new Class<?>[]{AppConfig.class};
	// }
	//
	// @Override
	// protected String[] getServletMappings() {
	// System.out.println("#####################################3");
	// return new String[]{"/","*.do"};
	// }
	private static final String CONFIG_LOCATION = "com";

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
		return application.sources(MvcConfigApplication.class);
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {

		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%55555");
		System.out.println("Initializing Application for " + servletContext.getServerInfo());

	//	 Create ApplicationContext
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.setConfigLocation(CONFIG_LOCATION);
		applicationContext.register(AppConfig.class);
		applicationContext.setServletContext(servletContext);

		// Add the servlet mapping manually and make it initialize automatically
		DispatcherServlet dispatcherServlet = new DispatcherServlet(applicationContext);

		ServletRegistration.Dynamic servlet = servletContext.addServlet("mvc-dispatcher", dispatcherServlet);

		servlet.addMapping("*.do");
		servlet.addMapping("*.html");
		servlet.addMapping("*.htm");
		servlet.addMapping("*.jsp");
		servlet.setInitParameter("dispatchOptionsRequest", "true");

		servlet.setAsyncSupported(true);
		servlet.setLoadOnStartup(1);
		FilterRegistration filterRegistration = servletContext.addFilter("characterEncodingFilter",
				CharacterEncodingFilter.class);
		filterRegistration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), false, "/*");
		///////////////////////new try/////////////////////
		 // Create the 'root' Spring application context
//	      AnnotationConfigWebApplicationContext rootContext =
//	        new AnnotationConfigWebApplicationContext();
//	      rootContext.register(AppConfig.class);
//
//	      // Manage the lifecycle of the root application context
//	      servletContext.addListener(new ContextLoaderListener(rootContext));
//
//	      // Create the dispatcher servlet's Spring application context
//	      AnnotationConfigWebApplicationContext dispatcherContext =
//	        new AnnotationConfigWebApplicationContext();
//	      dispatcherContext.register(AppConfig.class);
//
//	      // Register and map the dispatcher servlet
//	      ServletRegistration.Dynamic dispatcher =
//	    		  servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
//	      dispatcher.setLoadOnStartup(1);
//	      dispatcher.addMapping("/");
	}

}