package com.uber.jaeger.rest.model;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Jeeva Kandasamy (jkandasa)
 */
@Getter
@ToString
@NoArgsConstructor
public class Span {
    private String traceID;
    private String spanID;
    private String operationName;
    private Long startTime;
    private Long duration;
    private List<Tag> tags;
}