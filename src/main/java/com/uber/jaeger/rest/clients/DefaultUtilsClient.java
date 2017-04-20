package com.uber.jaeger.rest.clients;

import javax.ws.rs.core.Response;

import org.hawkular.client.core.BaseClient;
import org.hawkular.client.core.ClientInfo;
import org.hawkular.client.core.ClientResponse;
import org.hawkular.client.core.DefaultClientResponse;
import org.hawkular.client.core.jaxrs.ResponseCodes;
import org.hawkular.client.core.jaxrs.RestFactory;

import com.fasterxml.jackson.databind.JavaType;
import com.uber.jaeger.rest.jaxrs.handlers.JaegerRestHandler;
import com.uber.jaeger.rest.model.Dependency;
import com.uber.jaeger.rest.model.Result;

/**
 * @author Jeeva Kandasamy (jkandasa)
 */
public class DefaultUtilsClient extends BaseClient<JaegerRestHandler> implements
        UtilsClient {

    public DefaultUtilsClient(ClientInfo clientInfo) {
        super(clientInfo, new RestFactory<>(JaegerRestHandler.class));
    }

    @Override
    public ClientResponse<Result<String>> getServices() {
        Response response = null;
        try {
            response = restApi().getServices();
            JavaType javaType = simpleResolver().get(Result.class, String.class);
            return new DefaultClientResponse<>(javaType, response, ResponseCodes.GET_SUCCESS_200);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    public ClientResponse<Result<String>> getOperations(String service) {
        Response response = null;
        try {
            response = restApi().getOperations(service);
            JavaType javaType = simpleResolver().get(Result.class, String.class);
            return new DefaultClientResponse<>(javaType, response, ResponseCodes.GET_SUCCESS_200);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    public ClientResponse<Result<Dependency>> getDependencies(long endTs, long lookback) {
        Response response = null;
        try {
            response = restApi().getDependencies(endTs, lookback);
            JavaType javaType = simpleResolver().get(Result.class, Dependency.class);
            return new DefaultClientResponse<>(javaType, response, ResponseCodes.GET_SUCCESS_200);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }
}
