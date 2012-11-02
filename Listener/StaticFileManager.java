import java.io.InputStream;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.io.IOUtils;

public class StaticFileManager {
	public static ConcurrentHashMap<String, String> fileMap = new ConcurrentHashMap<String, String>();
	private static Logger logger = Logger.getLogger(StaticFileManager.class
			.getName());

	private static final boolean useCache = false;

	public static String getFile(String relativePath) {
		String resourcePath = makeResourcePath(relativePath);

		if (useCache) {
			if (!fileMap.containsKey(resourcePath)) {
				fileMap.put(resourcePath, loadFile(resourcePath));
			}

			return fileMap.get(resourcePath);
		}

		return loadFile(resourcePath);
	}

	private static String loadFile(String resourcePath) {
		InputStream inStream = StaticFileManager.class
				.getResourceAsStream(resourcePath);
		if (inStream == null) {
			logger.log(Level.INFO, "no file: " + resourcePath);
			return "";
		}

		try {
			return IOUtils.toString(inStream);
		} catch (Exception e) {
			logger.log(Level.SEVERE, e.getMessage(), e);
		} finally {
			IOUtils.closeQuietly(inStream);
		}
		return "";
	}

	private static String makeResourcePath(String relativePath) {
		String resourcePath = relativePath;
		if (resourcePath.equals("/"))
			resourcePath = "/index.html";
		if (!resourcePath.startsWith("/"))
			resourcePath = "/" + resourcePath;
		resourcePath = "Web" + resourcePath;
		return resourcePath;
	}
}
