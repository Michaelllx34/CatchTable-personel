package com.catchmind.catchtable.domain.type;

import lombok.Getter;

public enum AskStatus {
    COMPLETE("답변완료"),
    STANDBY("답변대기");

    @Getter private final String description;

    AskStatus(String description) {
        this.description = description;
    }
}
