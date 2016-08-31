package com.arrggh.eve.shell.commands;

import com.arrggh.eve.api.sde.StaticDataExportImporter;
import com.arrggh.eve.shell.ShellContext;
import com.arrggh.eve.shell.commands.debug.DumpTableExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.CommandMarker;
import org.springframework.shell.core.annotation.CliCommand;
import org.springframework.shell.core.annotation.CliOption;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Component
public class StaticDataExportCommands implements CommandMarker {
    private final ShellContext context;

    @Autowired
    public StaticDataExportCommands(ShellContext context) {
        this.context = context;
    }

    @CliCommand(value = "import-sde", help = "Import Static Data Export file")
    public String importStaticData(@CliOption(key = {"filename"}, mandatory = true, help = "The character name") String filename) {
        File file = new File(filename);
        if (file.exists()) {
            StaticDataExportImporter importer = new StaticDataExportImporter();
            try {
                importer.importFile(file);
            } catch (IOException e) {
                return e.getMessage();
            }
        }
        return "Static Data Imported";
    }
}