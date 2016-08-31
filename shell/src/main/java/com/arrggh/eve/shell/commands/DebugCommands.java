package com.arrggh.eve.shell.commands;

import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.shell.ShellContext;
import com.arrggh.eve.shell.commands.debug.DumpTableExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliAvailabilityIndicator;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.arrggh.eve.utilities.LanguageUtilities.isNotNull;

@Component
public class DebugCommands implements CommandMarker {
    private final ShellContext context;

    @Autowired
    public DebugCommands(ShellContext context) {
        this.context = context;
    }

    @CliCommand(value = "dump-tables", help = "Dump all the tables")
    public String dumpTables() {
        List<List<String>> rows = context.getDataManager().debugExecuteSql(new DumpTableExecutor("accounts"));

        StringBuilder builder = new StringBuilder();

        builder.append(dumpTable("accounts"));
        builder.append("\n");
        builder.append(dumpTable("xml_api_keys"));
        builder.append("\n");
        builder.append(dumpTable("characters"));
        builder.append("\n");
        builder.append(dumpTable("blueprints"));
        builder.append("\n");

        return builder.toString();
    }

    private String dumpTable(String table) {
        List<List<String>> rows = context.getDataManager().debugExecuteSql(new DumpTableExecutor(table));

        StringBuilder builder = new StringBuilder();
        builder.append("--------------------------- " + table + "---------------------------");
        builder.append("\n");

        for (String cell : rows.get(0)) {
            builder.append(String.format("%-15s ", cell));
        }
        builder.append("\n");

        for (int i = 1; i != rows.size(); i++) {
            for (String cell : rows.get(i)) {
                builder.append(String.format("%15s ", cell));
            }
            builder.append("\n");
        }
        return builder.toString();
    }
}