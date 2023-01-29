package com.catchmind.catchtable.domain.network.request;

import com.catchmind.catchtable.dto.AskDto;
import com.catchmind.catchtable.dto.ImprovementDto;
import com.catchmind.catchtable.dto.ProfileDto;

public record ImprovementRequest(
        String impTitle,
        String impContent,
        Long prIdx,
        String impAnswer
) {
    public ImprovementRequest of(
            String impTitle,
            String impContent,
            Long prIdx,
            String impAnswer
    ){
        return new ImprovementRequest(impTitle, impContent, prIdx, impAnswer);
    }

    public ImprovementDto toDto(){
        return ImprovementDto.of(impTitle, impContent, ProfileDto.of(prIdx), impAnswer);
    }
}
