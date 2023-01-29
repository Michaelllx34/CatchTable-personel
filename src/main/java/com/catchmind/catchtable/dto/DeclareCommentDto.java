package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.*;

import java.time.LocalDateTime;

public record DeclareCommentDto(
        Long decIdx,
        ReviewDto revIdx,
        CommentDto commentDto ,           // comIdx
        ProfileDto profileDto,
        String decNick ,           // decNick
        String decContent,
        LocalDateTime regDate
) {
    public static DeclareCommentDto from(DeclareComment declareComment){
        return new DeclareCommentDto(
                declareComment.getDecIdx(),
                ReviewDto.from(declareComment.getId()),
                CommentDto.from(declareComment.getComment()),
                ProfileDto.from(declareComment.getProfile()),
                declareComment.getDecNick(),
                declareComment.getDecContent(),
                declareComment.getRegDate()
        );
    }
}
