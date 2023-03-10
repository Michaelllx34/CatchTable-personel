package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.DeclareReview;

import java.time.LocalDateTime;

public record DeclareReviewDto(
        Long derIdx,
        ReviewDto reviewDto,    // rev_idx
        String derNick,             // derNick
        ProfileDto profileDto,      // prNick
        String derTitle,            // 추가
        String derContent,
        LocalDateTime regDate
) {
    public static DeclareReviewDto from(DeclareReview declareReview){
        return new DeclareReviewDto(
                declareReview.getDerIdx(),
                ReviewDto.from(declareReview.getReview()),
                declareReview.getDerNick(),
                ProfileDto.from(declareReview.getProfile()),
                declareReview.getDerTitle(),
                declareReview.getDerContent(),
                declareReview.getRegDate()
        );
    }
}
