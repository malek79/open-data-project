package com.tcb.repository;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@EnableConfigurationProperties(ElasticsearchProperties.class)
public class ElasticsearchConfiguration {

    @Autowired
    private ElasticsearchProperties elasticsearchProperties;

    @Bean
    public TransportClient client() {
        Settings settings = Settings.builder()
                .put("cluster.name", elasticsearchProperties.getClusterName())
                .build();
        return new PreBuiltTransportClient(settings)
                .addTransportAddress(createTransportAddress());

    }
    private TransportAddress createTransportAddress() {
        String clusterNodes = elasticsearchProperties.getClusterNodes();
        Assert.hasText(clusterNodes, "[Assertion failed] clusterNodes settings missing.");
        String hostName = clusterNodes.substring(0, clusterNodes.indexOf(":"));
        String port = clusterNodes.substring(clusterNodes.indexOf(":") + 1);
        Assert.hasText(hostName, "[Assertion failed] missing host name in \'clusterNodes\'");
        Assert.hasText(port, "[Assertion failed] missing port in \'clusterNodes\'");
        try {
            return new InetSocketTransportAddress(InetAddress.getByName(hostName), Integer.valueOf(port).intValue());
        } catch (UnknownHostException e) {
        	System.out.println("Not able to create transport client for ES using hostName: {}");
//            LOGGER.error("Not able to create transport client for ES using hostName: {}", hostName, e);
            return null;
        }
    }
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

