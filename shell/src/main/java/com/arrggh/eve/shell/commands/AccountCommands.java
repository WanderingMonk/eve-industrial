package com.arrggh.eve.shell.commands;

import com.arrggh.eve.model.account.EveAccount;
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
public class AccountCommands implements CommandMarker {
    private final ShellContext context;

    @Autowired
    public AccountCommands(ShellContext context) {
        this.context = context;
    }

    @CliCommand(value = "list-accounts", help = "List all the accounts currently known")
    public String listAccounts() {
        List<EveAccount> accounts = this.context.getDataManager().getAccountList();

        if (accounts.size() == 0) {
            return "No accounts found ... please add one to continue";
        }

        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%14s  %-30s\n", "Id", "Name"));
        builder.append(String.format("%14s  %-30s\n", "--------------", "------------------------------"));
        for (EveAccount account : accounts) {
            builder.append(String.format("%14d  %-30s\n", account.getId(), account.getName()));
        }
        return builder.toString();
    }

    @CliCommand(value = "add-account", help = "Adds a new account")
    public String addAccount(@CliOption(key = {"name"}, mandatory = true, help = "The account name") final String name) {
        EveAccount account = this.context.getDataManager().createNewAccount(name);
        this.context.setActiveAccountId(account.getId());
        return "Account '" + account.getName() + "' created";
    }

    @CliCommand(value = "select-account")
    public String selectAccount(@CliOption(key = {"name"}, mandatory = true, help = "The account name") final EveAccount account) {
        this.context.setActiveAccountId(account.getId());
        return "Account '" + account.getName() + "' selected";
    }

    @CliAvailabilityIndicator({"add-account-key-xml", "add-account-key-crest"})
    public boolean isCommandAvailable() {
        return isNotNull(context.getActiveAccountId());
    }

    @CliCommand(value = "add-account-key-xml", help = "Add a XML API Key to the current account")
    public String addXmlKey(@CliOption(key = {"id"}, mandatory = true, help = "The XML key id") final String id,
                            @CliOption(key = {"code"}, mandatory = true, help = "The XML key verification code") final String code) {
        context.getDataManager().addXmlKey(context.getActiveAccountId(), id, code);
        context.getDataManager().reloadCharacters(context.getActiveAccountId());

        return "Key added, to account";
    }

//    @CliCommand(value = "add-account-key-crest", help = "Authorise a CREST API access using the current account")
//    public String addCrestAuthorisation(@CliOption(key = {"name"}, mandatory = true, help = "The account name") final String name) {
//        return "Please open a browser to 'http://localhost:8336/' and authorise the access.";
//    }
}