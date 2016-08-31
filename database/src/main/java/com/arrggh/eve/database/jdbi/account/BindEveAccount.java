package com.arrggh.eve.database.jdbi.account;

import com.arrggh.eve.model.account.EveAccount;
import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

import java.lang.annotation.*;

@BindingAnnotation(BindEveAccount.BindEveAccountFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindEveAccount {
    public static class BindEveAccountFactory implements BinderFactory {
        public Binder build(Annotation annotation) {
            return (Binder<BindEveAccount, EveAccount>) (q, bind, arg) -> {
                q.bind("id", arg.getId());
                q.bind("name", arg.getName());
            };
        }
    }
}