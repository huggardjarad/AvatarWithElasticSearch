package com.qa.application.playerproducer.service;

import com.qa.application.playerproducer.domain.Avatar;
import com.qa.application.playerproducer.repository.AvatarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;


@Service
public class AvatarServiceImpl implements AvatarService {


    private AvatarRepository avatarRepository;

    @Autowired
    public void setAvatarRepository(AvatarRepository avatarRepository){
        this.avatarRepository = avatarRepository;
    }


    public Avatar findBySeedNumber(Long seedNumber) {
        return avatarRepository.findBySeedNumber(seedNumber);
    }


    @Override
    public Long generateSeedNumber() {
        Avatar avatar = new Avatar();
        avatar.setSeedNumber(avatarRepository.generateSeedNumber());
        avatarRepository.save(avatar);
        return avatarRepository.generateSeedNumber();
    }
}
