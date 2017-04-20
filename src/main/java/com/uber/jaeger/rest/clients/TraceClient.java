package com.uber.jaeger.rest.clients;

import org.hawkular.client.core.ClientResponse;
import org.hawkular.client.core.jaxrs.Empty;

import com.uber.jaeger.rest.model.Criteria;
import com.uber.jaeger.rest.model.Result;
import com.uber.jaeger.rest.model.Trace;

/**
 * @author Jeeva Kandasamy (jkandasa)
 */
public interface TraceClient {
	ClientResponse<Empty> archive(String traceId);

	ClientResponse<Result<Trace>> getArchived(String traceId);

	ClientResponse<Result<Trace>> get(String traceId);

	ClientResponse<Result<Trace>> list(Criteria criteria);
}