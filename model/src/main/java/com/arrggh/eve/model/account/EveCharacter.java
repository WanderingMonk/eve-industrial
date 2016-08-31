package com.arrggh.eve.model.account;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class EveCharacter {
    private final long id;
    private final String name;
}
