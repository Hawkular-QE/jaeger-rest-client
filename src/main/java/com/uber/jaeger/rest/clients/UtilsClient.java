package com.uber.jaeger.rest.clients;

import org.hawkular.client.core.ClientResponse;

import com.uber.jaeger.rest.model.Dependency;
import com.uber.jaeger.rest.model.Result;

/**
 * @author Jeeva Kandasamy (jkandasa)
 */
public interface UtilsClient {
	ClientResponse<Result<String>> getServices();

	ClientResponse<Result<String>> getOperations(String service);

	ClientResponse<Result<Dependency>> getDependencies(long endTs, long lookback);
}
