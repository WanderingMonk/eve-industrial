package com.arrggh.eve.database.jdbi.character;

import com.arrggh.eve.model.account.EveAccount;
import com.arrggh.eve.model.character.EveBlueprint;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

import java.lang.annotation.*;

@BindingAnnotation(BindEveBlueprint.BindEveBlueprintFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindEveBlueprint {
    public static class BindEveBlueprintFactory implements BinderFactory {
        public Binder build(Annotation annotation) {
            return (Binder<BindEveBlueprint, EveBlueprint>) (q, bind, arg) -> {
                q.bind("id", arg.getId());
                q.bind("name", arg.getName());
            };
        }
    }
}