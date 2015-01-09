package ch.christianguedemann.demoplugin.angular;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleActivator;

public class AJSActivator extends Plugin implements BundleActivator {

	private static AJSActivator INSTANCE;
	public AJSActivator() {
		INSTANCE = this;
	}
	public static AJSActivator getInstance() {
		return INSTANCE;
	}
	
	
}
