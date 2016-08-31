package com.arrggh.eve.shell.commands;

import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.shell.ShellContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.arrggh.eve.utilities.LanguageUtilities.isNotNull;

@Component
public class CharacterCommands implements CommandMarker {
    private final ShellContext context;

    @Autowired
    public CharacterCommands(ShellContext context) {
        this.context = context;
    }

    @CliAvailabilityIndicator({"list-characters", "select-character"})
    public boolean isCommandAvailable() {
        return isNotNull(context.getActiveAccountId());
    }

    @CliCommand(value = "list-characters", help = "List all the characters currently authorised")
    public String listCharacters() {
        List<EveCharacter> characters = context.getDataManager().getCharacterList(context.getActiveAccountId());

        if (characters.size() == 0) {
            return "No characters found";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%14s  %-30s\n", "Id", "Name"));
        builder.append(String.format("%14s  %-30s\n", "--------------", "------------------------------"));
        for (EveCharacter character : characters) {
            builder.append(String.format("%14s  %-30s\n", character.getId(), character.getName()));
        }
        return builder.toString();
    }

    @CliCommand(value = "select-character", help = "Select a character to use with other commands")
    public String activateCharacters(@CliOption(key = {"name"}, mandatory = true, help = "The character name") final EveCharacter character) {
        context.setActiveCharacterId(character.getId());
        return "Character " + character.getName() + " (" + character.getId() + ") is now the active character";
    }
}