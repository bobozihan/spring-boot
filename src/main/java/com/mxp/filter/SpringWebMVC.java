package com.mxp.filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2019-03-07
 * Time : 10:50
 */
@Configuration
public class SpringWebMVC implements WebMvcConfigurer {

//    @Autowired
//    private HandlerInterceptor timeInterceptor;
    @Autowired
    private MappingJackson2HttpMessageConverter converter;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(timeInterceptor).addPathPatterns("/**");
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converter.setSupportedMediaTypes(new LinkedList<>() {{
            add(MediaType.TEXT_HTML);
            add(MediaType.APPLICATION_JSON_UTF8);
        }});
        converters.add(new StringHttpMessageConverter());
        converters.add(converter);
    }

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter() {
            @Override
            protected void writeInternal(Object object, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
                if (object instanceof String) {
                    Charset charset = Optional.ofNullable(this.getDefaultCharset()).orElse(Charset.forName("UTF-8"));
                    StreamUtils.copy((String) object, charset, outputMessage.getBody());
                } else {
                    super.writeInternal(object, type, outputMessage);
                }
            }
        };
    }
}