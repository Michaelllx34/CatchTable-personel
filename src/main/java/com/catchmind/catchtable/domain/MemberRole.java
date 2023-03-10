package com.catchmind.catchtable.domain;

import lombok.Getter;

public enum MemberRole {
    USER("USER");

    @Getter
    private final String prHp;

    MemberRole(String prHp) {
        this.prHp = prHp;
    }
}
