package com.arrggh.eve.shell;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.PromptProvider;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ShellPromptProvider implements PromptProvider {

    @Override
    public String getProviderName() {
        return "prompt";
    }

    @Override
    public String getPrompt() {
        return "prompt";
    }
}
