package org.test;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.UUID;

@Path("/test")
public class GreetingResource {

    @GET
    @Path("/{word}")
    @Produces(MediaType.APPLICATION_JSON)
    public String echo(@PathParam String word) {
        return UUID.randomUUID().toString() + " " + word + " " + extractIP();
    }

    private String extractIP(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return e.getMessage();
        }
    }
}