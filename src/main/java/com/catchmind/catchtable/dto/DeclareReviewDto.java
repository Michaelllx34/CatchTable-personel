package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.DeclareReview;
import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.domain.Review;

import java.time.LocalDateTime;

public record DeclareReviewDto(
        Long derIdx,
        ReviewDto revIdx,
        String derNick,    // derNick
        ProfileDto profileDto,         // prNick
        String derContent,
        LocalDateTime regDate
) {
    public static DeclareReviewDto from(DeclareReview declareReview){
        return new DeclareReviewDto(
                declareReview.getDerIdx(),
                ReviewDto.from(declareReview.getId()),
                declareReview.getDerNick(),
                ProfileDto.from(declareReview.getProfile()),
                declareReview.getDerContent(),
                declareReview.getRegDate()
        );
    }
}
