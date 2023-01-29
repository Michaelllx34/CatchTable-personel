package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.Comment;
import com.catchmind.catchtable.domain.Profile;
import com.catchmind.catchtable.domain.Review;

import java.time.LocalDateTime;

public record CommentDto(
        Long comIdx,
        ProfileDto profileDto,
        String comContent,
        ReviewDto Id,
        LocalDateTime regDate
) {
    public static CommentDto from(Comment comment){
        return new CommentDto(
                comment.getComIdx(),
                ProfileDto.from(comment.getProfile()),
                comment.getComContent(),
                ReviewDto.from(comment.getId()),
                comment.getRegDate()
        );
    }
}
