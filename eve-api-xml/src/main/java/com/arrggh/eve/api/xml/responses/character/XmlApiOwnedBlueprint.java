package com.arrggh.eve.api.xml.responses.character;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public final class XmlApiOwnedBlueprint {
    private final long itemId;
    private final long locationId;
    private final long typeId;
    private final String typeName;
    private final long flagId;
    private final String quantity;
    private final String timeEfficiency;
    private final String materialEfficiency;
    private final String runs;
}
