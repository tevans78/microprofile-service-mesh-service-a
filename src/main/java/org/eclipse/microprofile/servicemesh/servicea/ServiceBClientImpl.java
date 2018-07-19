package org.eclipse.microprofile.servicemesh.servicea;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Dependent
public class ServiceBClientImpl {

    @Inject
    @RestClient
    ServiceBClient serviceBClient;
    
    private int tries;
    
    @Retry(maxRetries=2)
    public ServiceData callServiceB() throws Exception {
        ++tries;

        ServiceData serviceBData = serviceBClient.call();

        return serviceBData;
    }
    
    public int getTries() {
        return tries;
    }
    
    
    
}
