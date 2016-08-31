package com.arrggh.eve.model.character;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EveBlueprint {
    private final long id;
    private final String name;
}
