package ch.christianguedemann.demoplugin.angular.resources;

import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.framework.Bundle;

import ch.christianguedemann.demoplugin.angular.AJSActivator;

import com.ibm.xsp.resource.ScriptResource;
import com.ibm.xsp.webapp.resources.BundleResourceProvider;

public class AJSResourceProvider extends BundleResourceProvider {

	public static final String RESOURCES_WEB_ANGULAR = "/resources/web/angular/";
	public static final String ANGULAR_PREFIX = ".angular";

	public static ScriptResource ANGULAR_1_1_4 = new ScriptResource("/.ibmxspres/" + ANGULAR_PREFIX + "/angular.1.1.4.min.js", true);
	public static ScriptResource ANGULAR_1_2_28 = new ScriptResource("/.ibmxspres/" + ANGULAR_PREFIX + "/angular.1.2.28.min.js", true);
	public static ScriptResource ANGULAR_1_3_8 = new ScriptResource("/.ibmxspres/" + ANGULAR_PREFIX + "/angular.1.3.8.min.js", true);

	private static Map<String, ScriptResource> ANGULAR_VERSIONS = new HashMap<String, ScriptResource>() {
		private static final long serialVersionUID = 1L;

		{
			put("1.1.4", ANGULAR_1_1_4);
			put("1.2.28", ANGULAR_1_2_28);
			put("1.3.8", ANGULAR_1_3_8);
			put("latest", ANGULAR_1_3_8);
		}
	};

	public AJSResourceProvider() {

		super(AJSActivator.getInstance().getBundle(), ANGULAR_PREFIX);
	}

	@Override
	protected URL getResourceURL(HttpServletRequest arg0, String name) {
		String path = RESOURCES_WEB_ANGULAR + name; // $NON-NLS-1$
		int fileNameIndex = path.lastIndexOf('/');
		String fileName = path.substring(fileNameIndex + 1);
		path = path.substring(0, fileNameIndex + 1);
		// see http://www.osgi.org/javadoc/r4v42/org/osgi/framework/Bundle.html
		// #findEntries%28java.lang.String,%20java.lang.String,%20boolean%29
		Enumeration<?> urls = getBundle().findEntries(path, fileName, false/* recursive */);
		if (null != urls && urls.hasMoreElements()) {
			URL url = (URL) urls.nextElement();
			if (null != url) {
				return url;
			}
		}
		return null; // no match, 404 not found.
	}

	public static ScriptResource getAngularScriptLibrary(String version) {
		if (ANGULAR_VERSIONS.containsKey(version)) {
			return ANGULAR_VERSIONS.get(version);
		}
		return null;
	}
}
