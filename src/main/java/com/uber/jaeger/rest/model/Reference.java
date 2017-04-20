package com.uber.jaeger.rest.model;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Jeeva Kandasamy (jkandasa)
 */
@Data
@NoArgsConstructor
public class Reference {
    private String refType;
    private String traceID;
    private String spanID;
}
