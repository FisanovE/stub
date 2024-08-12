package com.example.stub.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestMessage {

    @JsonProperty("msg_id")
    private String id;
}
