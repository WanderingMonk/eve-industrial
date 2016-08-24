package com.arrggh.eve.api.xml.authentication;

import com.arrggh.eve.api.xml.responses.account.EveCharacter;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public final class EveAccount {
    private final String name;
    private final List<EveCharacter> characters;
}
