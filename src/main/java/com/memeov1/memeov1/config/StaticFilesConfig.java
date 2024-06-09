package com.memeov1.memeov1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class StaticFilesConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(@SuppressWarnings("null") ResourceHandlerRegistry registry) {
        registry.addResourceHandler("uploads/**")
                // .addResourceLocations("file:/Users/noeliarodriguezrodriguez/Desktop/tfg/memeov1/uploads/");
                .addResourceLocations("file:///C:/Users/alvar/OneDrive/Escritorio/SpringWithJS/noTFG/uploads/");
    }
}
