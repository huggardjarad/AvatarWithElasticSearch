package com.qa.application.playerproducer.domain;



import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Document(indexName = "application", type = "avatars")
public class Avatar {

    @Id
    @Min(0)
    @Max(2000)
    private Long seedNumber;

    public Avatar(){

    }

    public Avatar(Long seedNumber){
        this.seedNumber = seedNumber;
}

    public Long getSeedNumber() {
        return seedNumber;
    }

    public void setSeedNumber(Long seedNumber) {
        this.seedNumber = seedNumber;
    }

}
