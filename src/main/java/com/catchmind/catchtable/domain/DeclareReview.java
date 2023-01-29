package com.catchmind.catchtable.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@ToString(callSuper = true)
@Entity
public class DeclareReview extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long derIdx;            // 리뷰 신고 번호
    @ManyToOne(optional = false)
    @JoinColumn(name = "rev_idx")
    private Review id;              // 리뷰 번호 FK
    @ManyToOne(optional = false)
    @JoinColumn(name = "pr_idx")    // pr_idx로 찾기
    private Profile profile;        // 리뷰 신고당한 사람(derNick) FK       // 회원 정보 테이블의 닉네임      // ??profile1

    private String derNick;
    private String derContent;      // 신고 사유

    protected DeclareReview() {}

    public DeclareReview(Long derIdx, Review id, Profile profile, String derNick, String derContent) {
        this.derIdx = derIdx;
        this.id = id;
        this.profile = profile;
        this.derNick = derNick;
        this.derContent = derContent;
    }
}
