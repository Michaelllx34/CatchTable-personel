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
public class BisNotice extends AuditingFields {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long binIdx;
    private String binTitle;
    @ManyToOne(optional = false)
    @JoinColumn(name = "resa_bis_name")
    private ResAdmin resaBisName;
    private String binContent;

    protected BisNotice(){}

    public BisNotice(String binTitle, ResAdmin resaBisName, String binContent) {
        this.binTitle = binTitle;
        this.resaBisName = resaBisName;
        this.binContent = binContent;
    }
}
