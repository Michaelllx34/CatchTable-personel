package com.catchmind.catchtable.domain;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@ToString(callSuper = true)
@Table(name = "review")
public class Review extends AuditingFields{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rev_idx")
    private Long id;                        // [지헌 수정] id -> revIdx ? (취소)
    @ManyToOne(optional = false)
    @JoinColumn(name = "pr_idx")            // pr_idx로 찾기
    private Profile profile;                // 리뷰 작성자 닉네임(rev_nick) FK       // 회원 정보 테이블의 닉네임
    private int revLike;
    private String revContent;
    private double revScore;
//    @ManyToOne(optional = false)
//    @JoinColumn(name = "resa_bis_name")
//    private ResAdmin resAdmin;
    private String orgNm;                   // ?? 얘네들은 어떤 컬럼?
    private String savedNm;
    private String savedPath;


    protected Review(){}


    @Builder
    public Review(Long id, Profile profile, int revLike, String revContent, double revScore, String orgNm, String savedNm, String savedPath) {
        this.id = id;
        this.profile = profile;
        this.revLike = revLike;
        this.revContent = revContent;
        this.revScore = revScore;
        this.orgNm = orgNm;
        this.savedNm = savedNm;
        this.savedPath = savedPath;
    }
}
