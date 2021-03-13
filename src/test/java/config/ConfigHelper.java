package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getTestUsername() {
        return getAuthorizationConfig().testUsername();
    }

    public static String getTestPassword() {
        return getAuthorizationConfig().testPassword();
    }

    private static AuthorizationConfig getAuthorizationConfig() {
        return ConfigFactory.newInstance().create(
                AuthorizationConfig.class, System.getProperties());
    }
}
