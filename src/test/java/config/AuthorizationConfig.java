package config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/authorization.properties"
})
public interface AuthorizationConfig extends Config{
    @Key("testUsername")
    String testUsername();

    @Key("testPassword")
    String testPassword();
}
