package com.catchmind.catchtable.domain.network.request;

import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.dto.AskDto;
import com.catchmind.catchtable.dto.ProfileDto;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public record AskRequest(

        String askTitle,
        String askContent,
        Long prIdx,
        String askAnswer

) {

    public AskRequest of(
            String askTitle,
            String askContent,
            Long prIdx,
            String askAnswer){
        return new AskRequest(askTitle, askContent, prIdx, askAnswer);
    }

    public AskDto toDto(){
        return AskDto.of(askTitle, askContent, ProfileDto.of(prIdx), askAnswer);
    }

}
