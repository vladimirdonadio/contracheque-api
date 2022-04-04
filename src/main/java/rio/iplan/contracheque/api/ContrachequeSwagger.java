package rio.iplan.contracheque.api;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
	    info = @Info(
	        title="CONTRACHEQUE API",
	        version = "0.0.1",
	        contact = @Contact(
	            name = "CONTRACHEQUE API Support",
	            url = "http://contracheque-api.com/contact",
	            email = "techsupport@contracheque-api.com"),
	        license = @License(
	            name = "License Apache 2.0",
	            url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
	)
public class ContrachequeSwagger extends Application {

}
