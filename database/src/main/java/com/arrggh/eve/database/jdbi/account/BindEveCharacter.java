package com.arrggh.eve.database.jdbi.account;

import com.arrggh.eve.model.account.EveCharacter;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

import java.lang.annotation.*;

@BindingAnnotation(BindEveCharacter.BindEveCharacterFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindEveCharacter {
    public static class BindEveCharacterFactory implements BinderFactory {
        public Binder build(Annotation annotation) {
            return (Binder<BindEveCharacter, EveCharacter>) (q, bind, arg) -> {
                q.bind("id", arg.getId());
                q.bind("name", arg.getName());
            };
        }
    }
}