package com.grace.airbnb.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "oauth_refresh_token")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class OauthRefreshToken {

    @Id
    @Column(name = "token_id", columnDefinition = "VARCHAR(256)")
    private String tokenId;

    @Column(name = "token", columnDefinition = "TEXT")
    private String token;

    @Column(name = "authentication", columnDefinition = "TEXT")
    private String authentication;

    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "datetime comment '등록일'")
    @CreationTimestamp
    private LocalDateTime createAt;

}

