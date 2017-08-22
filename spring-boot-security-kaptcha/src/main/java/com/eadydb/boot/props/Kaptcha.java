package com.eadydb.boot.props;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author eadydb {dengbin1201@163.com}
 * @Date 17-5-4 下午1:52
 * <p>
 * @Description 验证码
 **/
@ConfigurationProperties(prefix = "kaptcha")
@Getter
@Setter
public class Kaptcha {

    // 图片宽度
    private String imageWidth;

    // 图片高度
    private String imageHeight;

    // session　key
    private String sessionKey;

    // 字体颜色
    private String textFontColor;

    // 验证码长度
    private String textCharLength;

    // 字体
    private String textFontNames;

    // 字体大小
    private String textFontSize;

    // 验证码背景颜色渐进
    private String backgroundColorFrom;

    // 验证码背景颜色渐进
    private String backgroundColorTo;


}
