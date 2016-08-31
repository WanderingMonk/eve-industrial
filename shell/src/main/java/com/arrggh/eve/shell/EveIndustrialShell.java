package com.arrggh.eve.shell;

import com.arrggh.eve.api.xml.EveXmlApi;
import com.arrggh.eve.api.xml.queries.TranquilityQueryUriBuilder;
import com.arrggh.eve.database.DatabaseConnection;
import com.arrggh.eve.database.DatabaseResponseCache;
import com.arrggh.eve.database.DatabaseSchemaUpdator;
import com.arrggh.eve.database.dao.cache.ICacheDao;
import com.arrggh.eve.utilities.queries.CachedExternalQueryService;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.shell.CommandLine;
import org.springframework.shell.ShellException;
import org.springframework.shell.SimpleShellCommandLineOptions;
import org.springframework.shell.core.ExitShellRequest;
import org.springframework.shell.core.JLineShellComponent;
import org.springframework.util.StopWatch;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class EveIndustrialShell {
    private final StopWatch sw = new StopWatch("Spring Shell");
    private final CommandLine commandLine;
    private final GenericApplicationContext ctx;
    private final ShellContext shellContext;

    private EveIndustrialShell(String[] args, String[] contextPath) throws SQLException {
        sw.start();
        try {
            commandLine = SimpleShellCommandLineOptions.parseCommandLine(args);
        } catch (IOException e) {
            throw new ShellException(e.getMessage(), e);
        }

        ctx = new GenericApplicationContext();

        File dbDirectory = new File("/home/monk/eve-industrial/database/eve-industrial-db");
        dbDirectory.mkdirs();

        DatabaseConnection dbConnection = new DatabaseConnection(dbDirectory);
        dbConnection.executeQuery(new DatabaseSchemaUpdator());

        ICacheDao cacheDao = dbConnection.getDao(ICacheDao.class);
        DatabaseResponseCache responseCache = new DatabaseResponseCache(cacheDao);
        CachedExternalQueryService queryCache = new CachedExternalQueryService(responseCache);

        EveXmlApi xmlApi = new EveXmlApi(queryCache, new TranquilityQueryUriBuilder());

        DataManager manager = new DataManager(dbConnection, xmlApi);

        ShellContext.ShellContextBuilder contextBuilder = ShellContext.builder();
        contextBuilder.dataManager(manager);
        this.shellContext = contextBuilder.build();

        ctx.addBeanFactoryPostProcessor(beanFactory -> beanFactory.registerResolvableDependency(ShellContext.class, shellContext));

        ctx.registerShutdownHook();
        configureApplicationContext(ctx);

        ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(ctx);
        TypeFilter excludeFilter = new TypeFilter() {
            @Override
            public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
                return metadataReader.getClassMetadata().getClassName().endsWith("DateCommands") || //
                        metadataReader.getClassMetadata().getClassName().endsWith("SystemCommands") || //
//                        metadataReader.getClassMetadata().getClassName().endsWith("ScriptCommands") || //
//                        metadataReader.getClassMetadata().getClassName().endsWith("InlineCommentCommands") || //
                        metadataReader.getClassMetadata().getClassName().endsWith("OsCommands") || //
                        metadataReader.getClassMetadata().getClassName().endsWith("SystemPropertyCommands");
            }
        };
        scanner.addExcludeFilter(excludeFilter);

        scanner.scan("org.springframework.shell.commands", //
                "org.springframework.shell.converters", //
                "org.springframework.shell.plugin.support");

        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(ctx);
        reader.loadBeanDefinitions(contextPath);
        ctx.refresh();
    }

    private void configureApplicationContext(GenericApplicationContext annctx) {
        createAndRegisterBeanDefinition(annctx, org.springframework.shell.core.JLineShellComponent.class, "shell");
        annctx.getBeanFactory().registerSingleton("commandLine", commandLine);
    }

    private void createAndRegisterBeanDefinition(GenericApplicationContext annctx, Class<?> clazz, String name) {
        RootBeanDefinition rbd = new RootBeanDefinition();
        rbd.setBeanClass(clazz);
        DefaultListableBeanFactory bf = (DefaultListableBeanFactory) annctx.getBeanFactory();
        if (name != null) {
            bf.registerBeanDefinition(name, rbd);
        } else {
            bf.registerBeanDefinition(clazz.getSimpleName(), rbd);
        }
    }

    private ExitShellRequest run() {
        // The shell is used
        JLineShellComponent shell = ctx.getBean("shell", JLineShellComponent.class);
        ExitShellRequest exitShellRequest;

        shell.start();
        shell.promptLoop();
        exitShellRequest = shell.getExitShellRequest();
        if (exitShellRequest == null) {
            // shouldn't really happen, but we'll fallback to this anyway
            exitShellRequest = ExitShellRequest.NORMAL_EXIT;
        }
        shell.waitForComplete();

        shellContext.shutdown();

        ctx.close();
        sw.stop();
        return exitShellRequest;
    }

    public static void main(String[] args) throws IOException, SQLException {
        EveIndustrialShell shell = new EveIndustrialShell(args, new String[]{"/com/arrggh/eve/shell/spring-shell-plugin.xml"});
        shell.run();
    }
}