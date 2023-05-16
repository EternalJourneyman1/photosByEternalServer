package dev.robinsond.photosbyeternal.photos.config

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebMVCConfig: WebMvcConfigurer {

    @Value("\${allowed.origins}")
    private val allowedOrigins: String? = null

    @Autowired
    private var env: Environment? = null

    init {
        println(env?.getProperty("allowed.origins"))
    }

// Inside a method or constructor
    override fun addCorsMappings(corsRegistry: CorsRegistry) {
        corsRegistry.addMapping("/**")
            .allowedOrigins(allowedOrigins)
            .allowedMethods("*")
            .allowedHeaders("*")
    }
}