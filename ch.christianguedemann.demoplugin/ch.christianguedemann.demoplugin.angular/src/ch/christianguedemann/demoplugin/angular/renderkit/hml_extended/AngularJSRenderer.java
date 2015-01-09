package ch.christianguedemann.demoplugin.angular.renderkit.hml_extended;

import java.io.IOException;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import ch.christianguedemann.demoplugin.angular.component.UIAngluar;
import ch.christianguedemann.demoplugin.angular.resources.AJSResourceProvider;

import com.ibm.xsp.component.UIViewRootEx;
import com.ibm.xsp.renderkit.FacesRenderer;
import com.ibm.xsp.resource.ScriptResource;

public class AngularJSRenderer extends FacesRenderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		if (!component.isRendered()) {
			return;
		}
		if (!(component instanceof UIAngluar)) {
			return;
		}
		UIAngluar angularJS = (UIAngluar) component;
		String version = angularJS.getAngularVersion();
		ScriptResource resource = AJSResourceProvider.getAngularScriptLibrary(version);
		if (resource == null) {
			throw new FacesException("Angular JS Library with version " + version + " not found!");
		}
		UIViewRootEx rootEx = (UIViewRootEx) context.getViewRoot();
		rootEx.addEncodeResource(resource);
	}
}
