package com.catchmind.catchtable.domain;

import com.catchmind.catchtable.domain.type.AskStatus;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Entity
@Getter
@ToString(callSuper = true)
public class Ask extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long askIdx;                // 문의사항 번호
    private String askTitle;            // 문의사항 제목              // ** 길이제한 등등 조건 넣기
    private String askContent;          // 문의사항 내용              // ** 길이제한 등등 조건 넣기
    @ManyToOne(optional = false)
    @JoinColumn(name = "pr_idx")        // pr_idx로 찾기
    private Profile profile;           // 문의사항 작성자 닉네임      // 회원테이블의 닉네임
    private String askAnswer;           // 문의사항 답변
    @Enumerated(EnumType.STRING)
    private AskStatus askStatus;           // 문의사항 답변 상태

    protected Ask() {}

    @Builder
    public Ask(Long askIdx, String askTitle, String askContent, Profile profile, String askAnswer, AskStatus askStatus) {
        this.askIdx = askIdx;
        this.askTitle = askTitle;
        this.askContent = askContent;
        this.profile = profile;
        this.askAnswer = askAnswer;
        this.askStatus = askStatus;
    }

    public Ask(String askTitle, String askContent, Profile profile, String askAnswer) {
        this.askTitle = askTitle;
        this.askContent = askContent;
        this.profile = profile;
        this.askAnswer = askAnswer;
    }

    public static Ask of(String askTitle, String askContent, Profile profile, String askAnswer) {
        return new Ask(askTitle, askContent, profile, askAnswer);
    }


}
