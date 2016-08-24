package com.arrggh.eve.api.xml.responses.character;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class OwnedAsset {
    private final long itemID;
    private final long locationID;
    private final long typeID;
    private final long quantity;
    private final String flag;
    private final String singleton;
    private final String rawQuantity;
}
