package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/credentialForPracticeFormWithPageObject.properties")
public interface CredentialConfigForPracticeFormWithPageObject extends Config {
    String login();

    String password();
}
