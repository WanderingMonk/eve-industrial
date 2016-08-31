package com.arrggh.eve.api.sde.model.certificates;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.util.Map;

@Value
@Builder
@JsonDeserialize(builder = Certificate.CertificateBuilder.class)
public class Certificate {
    private final String description;
    private final Long groupID;
    private final String name;
    private final Long[] recommendedFor;
    private final Map<Long,SkillLevel> skillTypes;

    @JsonPOJOBuilder(withPrefix = "")
    public static class CertificateBuilder {
    }
}
