package com.eadydb.boot.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by eadydb on 17-5-4.
 */
@ConfigurationProperties(prefix = "druid.datasource.jdbc")
@Getter
@Setter
public class Druid {

    private String driverClassName;

    private String url;

    private String username;

    private String password;

}
