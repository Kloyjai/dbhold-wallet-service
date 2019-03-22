package com.oauth.social.oauthsocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.oauth.social.oauthsocial.config.AppProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class OauthSocialApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthSocialApplication.class, args);
	}

}
