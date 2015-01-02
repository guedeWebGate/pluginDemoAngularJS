package ch.christianguedemann.demoplugin.angular.library;

import com.ibm.xsp.library.AbstractXspLibrary;

public class AJSLibrary extends AbstractXspLibrary {

	public AJSLibrary() {
	}

	@Override
	public String getLibraryId() {
		return "ch.christianguedemann.demoplugin.angular.library";
	}

	@Override
	public String[] getFacesConfigFiles() {
		return new String[]{"ch/christianguedemann/demoplugin/angular/config/angular-faces-config.xml"};
	}
	
	@Override
	public String[] getXspConfigFiles() {
		return new String[]{"ch/christianguedemann/demoplugin/angular/config/angular.xsp-config"};
	}
}
