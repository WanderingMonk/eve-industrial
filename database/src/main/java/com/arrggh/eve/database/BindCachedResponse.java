package com.arrggh.eve.database;

import com.arrggh.eve.utilities.queries.CachedResponse;
import org.skife.jdbi.v2.SQLStatement;
import org.skife.jdbi.v2.sqlobject.Binder;
import org.skife.jdbi.v2.sqlobject.BinderFactory;
import org.skife.jdbi.v2.sqlobject.BindingAnnotation;

import java.lang.annotation.*;

@BindingAnnotation(BindCachedResponse.BindCachedResponseFactory.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
public @interface BindCachedResponse {
    public static class BindCachedResponseFactory implements BinderFactory
    {
        public Binder build(Annotation annotation)
        {
            return new Binder<BindCachedResponse, CachedResponse>()
            {
                public void bind(SQLStatement q, BindCachedResponse bind, CachedResponse arg)
                {
//                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withLocale(Locale.UK).withZone(ZoneId.of("UTC"));
//                    q.bind("expiryTime", formatter.format(arg.getExpiryTime()));
                    q.bind("expiryTime", arg.getExpiryTime().toString());
                    q.bind("document", arg.getDocument());
                }
            };
        }
    }
}