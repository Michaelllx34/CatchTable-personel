package com.catchmind.catchtable.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@ToString(callSuper = true)
@Entity
public class Improvement extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long impIdx;
    private String impTitle;
    private String impContent;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pr_idx")
    private Profile profile;
    private String impAnswer;
    private String impStatus;

    protected Improvement(){}

    public Improvement(Long impIdx, String impTitle, String impContent, Profile profile, String impAnswer, String impStatus) {
        this.impIdx = impIdx;
        this.impTitle = impTitle;
        this.impContent = impContent;
        this.profile = profile;
        this.impAnswer = impAnswer;
        this.impStatus = impStatus;
    }


}
