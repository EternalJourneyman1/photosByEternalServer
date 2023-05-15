package dev.robinsond.photosbyeternal.photos.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMVCConfig: WebMvcConfigurer {
    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
            .allowedOrigins("http://localhost:8081")
            .allowedMethods("*")
            .allowedHeaders("*")
    }
}