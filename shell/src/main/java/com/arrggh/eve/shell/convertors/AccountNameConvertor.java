package com.arrggh.eve.shell.convertors;

import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.shell.ShellContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountNameConvertor implements Converter<EveAccount> {
    private ShellContext context;

    @Autowired
    public AccountNameConvertor(ShellContext context) {
        this.context = context;
    }

    @Override
    public boolean supports(Class<?> type, String optionContext) {
        return type == EveAccount.class;
    }

    @Override
    public EveAccount convertFromText(String value, Class<?> targetType, String optionContext) {
        List<EveAccount> accounts = context.getDataManager().getAccountList();
        for (EveAccount account : accounts) {
            if (account.getName().equals(value)) {
                return account;
            }
        }
        return null;
    }

    @Override
    public boolean getAllPossibleValues(List<Completion> completions, Class<?> targetType, String existingData, String optionContext, MethodTarget target) {
        List<EveAccount> accounts = context.getDataManager().getAccountList();
        for (EveAccount account : accounts) {
            completions.add(new Completion(account.getName()));
        }
        return true;
    }
}
