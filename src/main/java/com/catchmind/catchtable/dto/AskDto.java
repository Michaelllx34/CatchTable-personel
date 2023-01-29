package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.Ask;
import com.catchmind.catchtable.domain.type.AskStatus;
import lombok.Builder;

import java.time.LocalDateTime;

public record AskDto(
        Long askIdx,
        String askTitle,
        String askContent,
        ProfileDto profileDto,
        String askAnswer,
        String askStatus,
        LocalDateTime regDate,
        LocalDateTime updateDate
) {

    public static AskDto from(Ask ask){
        return new AskDto(
                ask.getAskIdx(),
                ask.getAskTitle(),
                ask.getAskContent(),
                ProfileDto.from(ask.getProfile()),
//                ask.getProfile().getPrIdx(),
                ask.getAskAnswer(),
                ask.getAskStatus().getDescription(),
                ask.getRegDate(),
                ask.getUpdateDate()
        );
    }

    public static AskDto of(
            String askTitle,
            String askContent,
            ProfileDto profileDto,
            String askAnswer){
        return  new AskDto(0L, askTitle, askContent,profileDto, askAnswer, null, null, null );
    }

    public Ask toEntity(){
        return Ask.of(
                askTitle,
                askContent,
                profileDto.toEntity(),
                askAnswer

        );
    }

}
