package com.arrggh.eve.shell.convertors;

import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.shell.ShellContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CharacterNameConvertor implements Converter<EveCharacter> {
    private ShellContext context;

    @Autowired
    public CharacterNameConvertor(ShellContext context) {
        this.context = context;
    }

    @Override
    public boolean supports(Class<?> type, String optionContext) {
        return type == EveCharacter.class;
    }

    @Override
    public EveCharacter convertFromText(String value, Class<?> targetType, String optionContext) {
        List<EveCharacter> characters = context.getDataManager().getCharacterList(context.getActiveAccountId());
        for (EveCharacter character : characters) {
            if (character.getName().equals(value)) {
                return character;
            }
        }
        return null;
    }

    @Override
    public boolean getAllPossibleValues(List<Completion> completions, Class<?> targetType, String existingData, String optionContext, MethodTarget target) {
        List<EveCharacter> characters = context.getDataManager().getCharacterList(context.getActiveAccountId());
        for (EveCharacter character : characters) {
            completions.add(new Completion(character.getName()));
        }
        return true;
    }
}
