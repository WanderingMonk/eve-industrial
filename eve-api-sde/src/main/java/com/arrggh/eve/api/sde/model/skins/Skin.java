package com.arrggh.eve.api.sde.model.skins;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@JsonDeserialize(builder = Skin.SkinBuilder.class)
public class Skin {
    private final Boolean allowCCPDevs;
    private final String internalName;
    private final Long skinID;
    private final Long skinMaterialID;
    private final Long[] types;
    private final Boolean visibleSerenity;
    private final Boolean visibleTranquility;

    @JsonPOJOBuilder(withPrefix = "")
    public static class SkinBuilder {
    }
}
