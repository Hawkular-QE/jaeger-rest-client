package com.uber.jaeger.rest;

import static com.google.common.base.Preconditions.checkNotNull;

import org.hawkular.client.core.ClientInfo;

import com.uber.jaeger.rest.clients.DefaultTraceClient;
import com.uber.jaeger.rest.clients.DefaultUtilsClient;
import com.uber.jaeger.rest.clients.TraceClient;
import com.uber.jaeger.rest.clients.UtilsClient;

/**
 * @author Jeeva Kandasamy (jkandasa)
 */
public class JaegerRestClient {
    static final String KEY_HEADER_AUTHORIZATION = "Authorization";

    private final UtilsClient utilsClient;
    private final TraceClient traceClient;

    private ClientInfo clientInfo;

    public JaegerRestClient(ClientInfo clientInfo) {
        checkNotNull(clientInfo);
        this.clientInfo = clientInfo;
        traceClient = new DefaultTraceClient(clientInfo);
        utilsClient = new DefaultUtilsClient(clientInfo);
    }

    public static JaegerRestClientBuilder builder() {
        return new JaegerRestClientBuilder();
    }

    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    public UtilsClient utils() {
        return utilsClient;
    }

    public TraceClient trace() {
        return traceClient;
    }

    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        JaegerRestClient that = (JaegerRestClient) o;

        return clientInfo != null ? clientInfo.equals(that.clientInfo) : that.clientInfo == null;

    }

    public int hashCode() {
        return clientInfo != null ? clientInfo.hashCode() : 0;
    }

    public String toString() {
        return "JaegerRestClient{" +
                "traceClient=" + traceClient +
                ", utilsClient=" + utilsClient +
                '}';
    }
}
