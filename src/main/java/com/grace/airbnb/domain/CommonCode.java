package com.grace.airbnb.domain;

import com.grace.airbnb.util.BooleanToYNConverter;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "common_code")
@Getter
@NoArgsConstructor
public class CommonCode {

    @Id
    @Column(name = "code_type", columnDefinition = "varchar(200) comment '코드 타입'")
    private String codeType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_code_type")
    private CommonCode parentCodeType;

    @Column(name = "code_order", columnDefinition = "int comment '코드 순서'")
    private int codeOrder;

    @Column(name = "value", nullable = false, columnDefinition = "varchar(200) comment '코드 값'")
    private String value;

    @Convert(converter= BooleanToYNConverter.class)
    @Column(name = "display_yn", nullable = false, columnDefinition = "varchar(1) default 'Y' comment '노출 여부'")
    private boolean displayYN;

}
