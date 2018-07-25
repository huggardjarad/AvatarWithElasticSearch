package com.qa.application.playerproducer.repository;

import com.qa.application.playerproducer.domain.Avatar;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;


public interface AvatarRepository extends ElasticsearchRepository<Avatar, Long> {

    Avatar findBySeedNumber(Long seedNumber);


    default Long generateSeedNumber() {
        return (long) new Random().nextInt(2000);
    }


}
