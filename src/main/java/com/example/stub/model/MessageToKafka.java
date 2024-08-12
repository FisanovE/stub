package com.example.stub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MessageToKafka {

    @JsonProperty("msg_id")
    private String id;

    @JsonProperty("timestamp")
    private String timestamp;

    @JsonProperty("method")
    private String method;

    @JsonProperty("uri")
    private String uri;
}
