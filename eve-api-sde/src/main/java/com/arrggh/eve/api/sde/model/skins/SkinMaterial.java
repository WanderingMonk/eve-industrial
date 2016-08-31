package com.arrggh.eve.api.sde.model.skins;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = SkinMaterial.SkinMaterialBuilder.class)
public class SkinMaterial {
    private final Long displayNameID;
    private final Long materialSetID;
    private final Long skinMaterialID;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SkinMaterialBuilder {
    }
}
