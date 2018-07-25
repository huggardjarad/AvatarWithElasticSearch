package com.qa.application.playerproducer;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.net.InetAddress;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.qa.application.playerproducer.repository")
public class EsConfig {

    @Value("localhost")
    private String EsHost;

    @Value("9300")
    private int EsPort;

    @Value("avatar-cluster")
    private String esClusterName;

    @Bean
    public Client client() throws Exception{
        Settings esSettings = Settings.settingsBuilder()
                .put("cluster.name", esClusterName)
                .build();
        return TransportClient.builder()
                .settings(esSettings)
                .build()
                .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(EsHost), EsPort));
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() throws Exception{
        return new ElasticsearchTemplate(client());
    }
}
