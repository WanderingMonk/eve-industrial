package com.arrggh.eve.api.sde.model.skins;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = SkinLicense.SkinLicenseBuilder.class)
public class SkinLicense {
    private final Long duration;
    private final Long licenseTypeID;
    private final Long skinID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SkinLicenseBuilder {
    }
}
