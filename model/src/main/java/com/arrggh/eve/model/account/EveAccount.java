package com.arrggh.eve.model.account;

import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class EveAccount {
    private final long id;
    private final String name;
    private final List<EveCharacter> characters;
}
