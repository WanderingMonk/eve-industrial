package com.arrggh.eve.shell.convertors;

import com.arrggh.eve.model.account.EveCharacter;
import com.arrggh.eve.model.character.EveBlueprint;
import com.arrggh.eve.shell.ShellContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.core.Completion;
import org.springframework.shell.core.Converter;
import org.springframework.shell.core.MethodTarget;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlueprintNameConvertor implements Converter<EveBlueprint> {
    private ShellContext context;

    @Autowired
    public BlueprintNameConvertor(ShellContext context) {
        this.context = context;
    }

    @Override
    public boolean supports(Class<?> type, String optionContext) {
        return type == EveBlueprint.class;
    }

    @Override
    public EveBlueprint convertFromText(String value, Class<?> targetType, String optionContext) {
        List<EveBlueprint> blueprints = context.getDataManager().getBlueprintList(context.getActiveAccountId(), context.getActiveCharacterId());
        for (EveBlueprint blueprint : blueprints) {
            if (blueprint.getName().equals(value)) {
                return blueprint;
            }
        }
        return null;
    }

    @Override
    public boolean getAllPossibleValues(List<Completion> completions, Class<?> targetType, String existingData, String optionContext, MethodTarget target) {
        List<EveBlueprint> blueprints = context.getDataManager().getBlueprintList(context.getActiveAccountId(), context.getActiveCharacterId());
        for (EveBlueprint blueprint : blueprints) {
            completions.add(new Completion(blueprint.getName()));
        }
        return true;
    }
}
