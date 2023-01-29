package com.catchmind.catchtable.dto;

import com.catchmind.catchtable.domain.BisNotice;

import java.time.LocalDateTime;

public record BisNoticeDto(
        Long binIdx,
        String binTitle,
        ResAdminDto resaBisName,
        String binContent,
        LocalDateTime regDate,
        LocalDateTime updateDate
) {
    public static BisNoticeDto from(BisNotice bisNotice){
        return new BisNoticeDto(
                bisNotice.getBinIdx(),
                bisNotice.getBinTitle(),
                ResAdminDto.from(bisNotice.getResaBisName()),
                bisNotice.getBinContent(),
                bisNotice.getRegDate(),
                bisNotice.getUpdateDate()
        );
    }
}
