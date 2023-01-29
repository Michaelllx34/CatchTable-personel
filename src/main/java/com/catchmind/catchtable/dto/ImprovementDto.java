package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.Improvement;
import com.catchmind.catchtable.domain.Notice;
import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.domain.type.AskStatus;

import java.time.LocalDateTime;

public record ImprovementDto(
        Long impIdx,
        String impTitle,
        String impContent,
        ProfileDto profileDto,
        String impAnswer,
        String impStatus,
        LocalDateTime regDate,
        LocalDateTime updateDate
) {
    public static ImprovementDto from(Improvement improvement){
        return new ImprovementDto(
                improvement.getImpIdx(),
                improvement.getImpTitle(),
                improvement.getImpContent(),
                ProfileDto.from(improvement.getProfile()),
                improvement.getImpAnswer(),
                improvement.getImpStatus().getDescription(),
                improvement.getRegDate(),
                improvement.getUpdateDate()
        );
    }
}
