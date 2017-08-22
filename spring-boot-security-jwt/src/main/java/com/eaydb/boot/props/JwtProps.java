package com.eaydb.boot.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @AUTHOR eadydb {dengbin1201@163.com}
 * @DATE 7/9/17 12:00 PM
 * <p/>
 * @DESCRIPTION
 **/
@Component
@ConfigurationProperties(prefix = "jwt")
@Data
public class JwtProps {

    private String header;

    private String tokenHead;

    private String secret;

    private Long expiration;


}
