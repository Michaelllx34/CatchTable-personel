package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.domain.Review;

import java.time.LocalDateTime;

public record ReviewDto(
//        Long revIdx,
//        ProfileDto profileDto,
//        int revLike,
//        String revContent,
//        double revScore,
//        ResAdminDto resAdminDto,
//        String orgNm,
//        String savedNm,
//        String savedPath,
//        LocalDateTime regDate,
//        LocalDateTime updateDate

//        [지헌 추가]
        Long revIdx,
        ProfileDto profileDto,                  //
        int revLike,                            // ?? int인지 Long인지
        String revContent,
        double revScore,
//        ResAdminDto resAdminDto,
        String orgNm,
        String savedNm,
        String savedPath,
        LocalDateTime regDate,
        LocalDateTime updateDate

) {

//    public static ReviewDto from(Review review){
//        return new ReviewDto(
//                review.getRevIdx(),
//                ProfileDto.from(review.getProfile()),
//                review.getRevLike(),
//                review.getRevContent(),
//                review.getRevScore(),
//                ResAdminDto.from(review.getResAdmin()),
//                review.getOrgNm(),
//                review.getSavedNm(),
//                review.getSavedPath(),
//                review.getRegDate(),
//                review.getUpdateDate()
//        );
//    }

    // [지헌 수정] 필요
    public static ReviewDto from(Review review){
        return new ReviewDto(
                review.getId(),
                ProfileDto.from(review.getProfile()),
                review.getRevLike(),
                review.getRevContent(),
                review.getRevScore(),
                review.getOrgNm(),
                review.getSavedNm(),
                review.getSavedPath(),
                review.getRegDate(),
                review.getUpdateDate()
        );
    }
}
