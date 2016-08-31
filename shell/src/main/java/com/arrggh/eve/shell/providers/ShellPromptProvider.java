package com.arrggh.eve.shell.providers;

import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.shell.ShellContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.PromptProvider;
import org.springframework.stereotype.Component;

import static com.arrggh.eve.utilities.LanguageUtilities.isNotNull;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ShellPromptProvider implements PromptProvider {
    private ShellContext context;

    @Autowired
    public ShellPromptProvider(ShellContext context) {
        this.context = context;
    }

    @Override
    public String getProviderName() {
        return "prompt";
    }

    @Override
    public String getPrompt() {
        EveAccount account = context.getActiveAccount();
        EveCharacter character = context.getActiveCharacter();

        System.out.println("Account: " + account);
        System.out.println("Character: " + character);

        String accountName = isNotNull(account) ? account.getName() : "<unset>";
        String characterName = isNotNull(character) ? character.getName() : "<unset>";

        StringBuilder prompt = new StringBuilder();

        prompt.append("Account  : ");
        prompt.append(accountName);
        prompt.append("\n");
        prompt.append("Character: ");
        prompt.append(characterName);
        prompt.append("\n");
        prompt.append("cmd> ");

        return prompt.toString();
    }
}
