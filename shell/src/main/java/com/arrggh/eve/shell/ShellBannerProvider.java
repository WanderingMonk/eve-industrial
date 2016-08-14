package com.arrggh.eve.shell;

import org.apache.commons.io.IOUtils;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.BannerProvider;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ShellBannerProvider implements BannerProvider {
    private String banner;
    private String version;

    public ShellBannerProvider() {
        try {
            banner = IOUtils.toString(ShellBannerProvider.class.getResourceAsStream("banner.txt"), "utf-8");

            Properties properties = new Properties();
            properties.load(ShellBannerProvider.class.getResourceAsStream("banner.txt"));
            version = properties.getProperty("git.build.version", "Un-versioned");
        } catch (IOException e) {
            banner = "EVE Online Industrial Manager";
        }
    }

    @Override
    public String getProviderName() {
        return "Provider Name";
    }

    @Override
    public String getBanner() {
        return banner;
    }

    @Override
    public String getVersion() {
        return version;
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the EVE Online Industrial Manager (" + getVersion() + "), command line interface.";
    }
}
