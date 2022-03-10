package com.grace.airbnb.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id", columnDefinition = "bigint(20) comment '회원 id'")
    private String id;

    @Column(name = "email", columnDefinition = "VARCHAR(256) comment '이메일'")
    private String email;

    @Column(name = "login_id", columnDefinition = "VARCHAR(256) comment '로그인 id'")
    private String loginId;

    @Column(name = "password", columnDefinition = "VARCHAR(256) comment '비밀번호'")
    private String password;

    @Column(name = "cellphone", columnDefinition = "VARCHAR(256) comment '전화번호'")
    private String cellphone;

    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "datetime comment '등록일'")
    @CreationTimestamp
    private LocalDateTime createAt;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "datetime comment '수정일'")
    private LocalDateTime updateAt;
}
