package com.qa.application.playerproducer;


import com.qa.application.playerproducer.service.AvatarService;
import com.qa.application.playerproducer.service.AvatarServiceImpl;
import org.elasticsearch.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;

import java.util.Map;


@SpringBootApplication
public class PlayerProducerApplication implements CommandLineRunner {

    @Autowired
    private ElasticsearchOperations es;

    @Autowired
    private AvatarServiceImpl service;

    public static void main(String args[]) {

        SpringApplication.run(PlayerProducerApplication.class);
    }
    @Override
    public void run(String... args)throws Exception {
        printElasticSearchInfo();

        System.out.println(service.generateSeedNumber());
        System.out.println(service.generateSeedNumber());
        System.out.println(service.generateSeedNumber());
        System.out.println(service.generateSeedNumber());


    }

    private void printElasticSearchInfo() {
        System.out.println("--ElasticSearch--");
        Client client = es.getClient();
        Map<String, String> asMap = client.settings().getAsMap();
        asMap.forEach((k,v) -> {
            System.out.println(k + "=" + v);
        });
        System.out.println("--ElasticSearch--");
    }
}