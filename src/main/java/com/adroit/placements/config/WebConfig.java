package com.adroit.placements.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")               // Allow CORS for all endpoints
                .allowedOrigins(
                        "http://35.188.150.92",  // First IP
                        "http://192.168.0.140:3000",  // Second IP
                        "http://192.168.0.139:3000", // Third IP
                        "https://mymulya.com", // Forth IP
                        "http://localhost:3000", // Fifth IP
                        "http://192.168.0.135:8080", // Sixth IP
                        "http://182.18.177.16:443", // Seventh IP
                        "http://192.168.0.135:80", // Eighth IP
                        "http://localhost/", // Ninth IP
                        "http://mymulya.com:443", // Tenth IP
                        "http://192.168.0.246:3002"
                )
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allowed HTTP methods
                .allowedHeaders("*")                      // Allow all headers
                .allowCredentials(true);                  // Allow credentials (cookies, headers, etc.)
    }

}