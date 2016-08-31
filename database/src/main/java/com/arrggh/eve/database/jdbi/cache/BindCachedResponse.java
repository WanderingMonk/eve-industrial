package com.arrggh.eve.database.jdbi.cache;

import com.arrggh.eve.utilities.queries.CachedResponse;
import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.lang.annotation.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;

@BindingAnnotation(BindCachedResponse.BindCachedResponseFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindCachedResponse {
    public static class BindCachedResponseFactory implements BinderFactory {
        public Binder build(Annotation annotation) {
            return (Binder<BindCachedResponse, CachedResponse>) (q, bind, arg) -> {
                q.bind("expiryTime", arg.getExpiryTime().toString());
                q.bind("document", arg.getDocument());
            };
        }
    }
}