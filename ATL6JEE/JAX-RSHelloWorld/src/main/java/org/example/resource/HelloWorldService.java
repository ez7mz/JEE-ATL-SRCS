package org.example.resource;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/restapi")
public class HelloWorldService extends Application {
    private Set< Object > singletons = new HashSet< Object >();

    public HelloWorldService() {
        singletons.add(new HelloWorldResource());
    }

    @Override
    public Set < Object > getSingletons() {
        return singletons;
    }
}
