package com.arrggh.eve.shell.commands;

import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.model.character.EveBlueprint;
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
public class BlueprintsCommands implements CommandMarker {
    private final ShellContext context;

    @Autowired
    public BlueprintsCommands(ShellContext context) {
        this.context = context;
    }

    @CliAvailabilityIndicator({"list-blueprints", "optimise-blueprint"})
    public boolean isCommandAvailable() {
        return isNotNull(context.getActiveAccountId()) && isNotNull(context.getActiveCharacterId());
    }

    @CliCommand(value = "list-blueprints", help = "List all the characters current blueprints")
    public String listBlueprints() {
        List<EveBlueprint> blueprints = context.getDataManager().getBlueprintList(context.getActiveAccountId(), context.getActiveCharacterId());

        if (blueprints.size() == 0) {
            return "No blueprints found";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%14s  %-30s\n", "Id", "Name"));
        builder.append(String.format("%14s  %-30s\n", "--------------", "------------------------------"));
        for (EveBlueprint blueprint : blueprints) {
            builder.append(String.format("%14s  %-30s\n", blueprint.getId(), blueprint.getName()));
        }
        return builder.toString();
    }

    @CliCommand(value = "optimise-blueprint", help = "Select a blueprint to optimise")
    public String optimiseBlueprint(@CliOption(key = {"name"}, mandatory = true, help = "The blueprint id") final EveBlueprint blueprint) {
        return "Optimised blueprint";
    }
}