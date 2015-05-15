package util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.eclipse.egit.github.core.IRepositoryIdProvider;

/**
 * Nicer interface for using loggers
 */
public class HTLog {
	public static Logger get(Class<?> c) {
		return LogManager.getLogger(c.getName());
	}

	public static String format(IRepositoryIdProvider repoId, String formatString, Object... args) {
		return repoId.generateId() + " | " + String.format(formatString, args);
	}

	public static String format(String repoId, String formatString, Object... args) {
		return repoId + " | " + String.format(formatString, args);
	}

	public static void error(Logger logger, Exception e) {
		logger.error(e.getLocalizedMessage(), e);
	}
}
