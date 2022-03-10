package com.grace.airbnb.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member_auth")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class MemberAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_auth_id", columnDefinition = "bigint(20) comment '회원 권한 id'")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // common code
    @Column(name = "auth_code", columnDefinition = "VARCHAR(256) comment '권한 코드'")
    private String authCode;

    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "datetime comment '등록일'")
    @CreationTimestamp
    private LocalDateTime createAt;
}
