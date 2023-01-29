package com.catchmind.catchtable.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@ToString(callSuper = true)
@Table(name = "review")
public class DeclareComment extends AuditingField {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long decIdx;                // 댓글 신고 번호
    @ManyToOne(optional = false)
    @JoinColumn(name = "rev_idx")
    private Review id;                  // 리뷰 번호(revIdx)         // 리뷰 테이블의 번호
    @ManyToOne(optional = false)
    @JoinColumn(name = "com_idx")
    private Comment comment;             // 댓글 번호(com_idx)        // 댓글 테이블의 번호

    private String decNick;
    @ManyToOne(optional = false)
    @JoinColumn(name = "pr_idx")       // pr_idx로 찾기
    private Profile profile;            // 댓글 신고 당한 사람(decNick)       // 회원테이블의 닉네임

    private String decContent;          // 신고 사유                // 회원테이블의 닉네임
}
