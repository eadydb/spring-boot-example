package com.eadydb.boot.config;

import com.eadydb.boot.props.Kaptcha;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author eadydb {dengbin1201@163.com}
 * @Date 17-5-4 下午2:02
 * <p>
 * @Description kaptcha　验证码配置文件
 **/

@Configuration
@EnableConfigurationProperties({Kaptcha.class})
public class KaptchaConfig {

    @Autowired
    private Kaptcha kaptchaProps;


    @Bean
    public DefaultKaptcha captchaProducer() {
        DefaultKaptcha kaptcha = new DefaultKaptcha();
        Properties props = new Properties();
        props.setProperty("kaptcha.image.width", kaptchaProps.getImageWidth());
        props.setProperty("kaptcha.image.height", kaptchaProps.getImageHeight());
        props.setProperty("kaptcha.session.key", kaptchaProps.getSessionKey());
        props.setProperty("kaptcha.textproducer.font.color", kaptchaProps.getTextFontColor());
        props.setProperty("kaptcha.textproducer.char.length", kaptchaProps.getTextCharLength());
        props.setProperty("kaptcha.textproducer.font.names", kaptchaProps.getTextFontNames());
        props.setProperty("kaptcha.textproducer.font.size", kaptchaProps.getTextFontSize());
        props.setProperty("kaptcha.background.color.from", kaptchaProps.getBackgroundColorFrom());
        props.setProperty("kaptcha.background.color.to", kaptchaProps.getBackgroundColorTo());
        Config config = new Config(props);
        kaptcha.setConfig(config);
        return kaptcha;
    }
}
