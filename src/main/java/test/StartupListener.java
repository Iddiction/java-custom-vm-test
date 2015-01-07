package test;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.logging.Logger;

public class StartupListener implements ServletContextListener {

	private static final Logger log = Logger.getLogger(StartupListener.class.getName());

	// Public constructor is required by servlet spec
	public StartupListener() {
	}

	public void contextInitialized(ServletContextEvent sce) {
		log.info("Context Initialized");
	}

	public void contextDestroyed(ServletContextEvent sce) {
		log.info("Context Destroyed");
	}

}
