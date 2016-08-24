package com.arrggh.eve.api.xml.authentication;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = XmlApiKey.XmlApiKeyBuilder.class)
public class XmlApiKey {
    private String name;
    private String keyId;
    private String verificationCode;

    @JsonPOJOBuilder(withPrefix = "")
    public static class XmlApiKeyBuilder {
    }
}
