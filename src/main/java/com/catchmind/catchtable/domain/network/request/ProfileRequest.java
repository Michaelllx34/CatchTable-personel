package com.catchmind.catchtable.domain.network.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProfileRequest {
    private String prNick;
    private String prName;
    private String prIntro;
    private String prRegion;
    private String prHp;
    private String prUserpw;
    private String prGender;
    private String prBirth;
}
