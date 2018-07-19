package org.eclipse.microprofile.servicemesh.servicea;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient
@Path("/serviceB")
public interface ServiceBClient {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ServiceData call() throws Exception;
    
}
