package com.arrggh.eve.api.xml.responses.account;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public final class XmlApiCharacter {
    private final String id;
    private final String name;
    private final String corporationName;
    private final String corporationId;
    private final String allianceId;
    private final String allianceName;
    private final String factionId;
    private final String factionName;
}
