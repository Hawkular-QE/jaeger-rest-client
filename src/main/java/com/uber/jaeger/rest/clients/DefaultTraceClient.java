package com.uber.jaeger.rest.clients;

import javax.ws.rs.core.Response;

import org.hawkular.client.core.BaseClient;
import org.hawkular.client.core.ClientInfo;
import org.hawkular.client.core.ClientResponse;
import org.hawkular.client.core.DefaultClientResponse;
import org.hawkular.client.core.jaxrs.Empty;
import org.hawkular.client.core.jaxrs.ResponseCodes;
import org.hawkular.client.core.jaxrs.RestFactory;

import com.fasterxml.jackson.databind.JavaType;
import com.uber.jaeger.rest.jaxrs.handlers.JaegerRestHandler;
import com.uber.jaeger.rest.model.Criteria;
import com.uber.jaeger.rest.model.Result;
import com.uber.jaeger.rest.model.Trace;

/**
 * @author Jeeva Kandasamy (jkandasa)
 */
public class DefaultTraceClient extends BaseClient<JaegerRestHandler> implements
        TraceClient {

    public DefaultTraceClient(ClientInfo clientInfo) {
        super(clientInfo, new RestFactory<>(JaegerRestHandler.class));
    }

    @Override
    public ClientResponse<Result<Trace>> get(String traceId) {
        Response response = null;
        try {
            response = restApi().getTrace(traceId);
            JavaType javaType = simpleResolver().get(Result.class, Trace.class);
            return new DefaultClientResponse<>(javaType, response, ResponseCodes.GET_SUCCESS_200);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    public ClientResponse<Result<Trace>> list(Criteria criteria) {
        Response response = null;
        try {
            response = restApi().listTrace(criteria.getOperation(), criteria.getService(), criteria.getTag(),
                    criteria.getStart(), criteria.getEnd(), criteria.getLimit(), criteria.getMinDuration(),
                    criteria.getMaxDuration());
            JavaType javaType = simpleResolver().get(Result.class, Trace.class);
            return new DefaultClientResponse<>(javaType, response, ResponseCodes.GET_SUCCESS_200);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    public ClientResponse<Empty> archive(String traceId) {
        Response response = null;
        try {
            response = restApi().archiveTrace(traceId);
            JavaType javaType = simpleResolver().get(Empty.class);
            return new DefaultClientResponse<>(javaType, response, ResponseCodes.NO_CONTENT_204);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

    @Override
    public ClientResponse<Result<Trace>> getArchived(String traceId) {
        Response response = null;
        try {
            response = restApi().getArchivedTrace(traceId);
            JavaType javaType = simpleResolver().get(Result.class, Trace.class);
            return new DefaultClientResponse<>(javaType, response, ResponseCodes.GET_SUCCESS_200);
        } finally {
            if (response != null) {
                response.close();
            }
        }
    }

}
