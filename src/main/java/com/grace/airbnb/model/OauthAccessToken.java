package com.grace.airbnb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "oauth_access_token")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class OauthAccessToken {

    @Id
    @Column(name = "token_id", columnDefinition = "VARCHAR(256)")
    private String tokenId;

    @Column(name = "token", columnDefinition = "TEXT")
    private String token;

    @Column(name = "authentication_id", columnDefinition = "VARCHAR(191)")
    private String authenticationId;

    @Column(name = "user_name", columnDefinition = "VARCHAR(256)")
    private String userName;

    @Column(name = "client_id", columnDefinition = "VARCHAR(256)")
    private String clientId;

    @Column(name = "authentication", columnDefinition = "TEXT")
    private String authentication;

    @Column(name = "refresh_token", columnDefinition = "VARCHAR(256)")
    private String refreshToken;

}
