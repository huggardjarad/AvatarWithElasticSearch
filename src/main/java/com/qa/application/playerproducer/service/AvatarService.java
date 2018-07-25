package com.qa.application.playerproducer.service;

import com.qa.application.playerproducer.domain.Avatar;





public interface AvatarService {

    Avatar findBySeedNumber(Long seedNumber);


    Long generateSeedNumber();

}
