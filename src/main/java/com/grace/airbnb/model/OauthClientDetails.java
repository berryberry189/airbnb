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
@Table(name = "oauth_client_details")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class OauthClientDetails {

    @Id
    @Column(name = "client_id", columnDefinition = "VARCHAR(191)")
    private String clientId;

    @Column(name = "resource_ids", columnDefinition = "VARCHAR(256)")
    private String resourceIds;

    @Column(name = "client_secret", columnDefinition = "VARCHAR(256)")
    private String clientSecret;

    @Column(name = "scope", columnDefinition = "VARCHAR(256)")
    private String scope;

    @Column(name = "authorized_grant_types", columnDefinition = "VARCHAR(256)")
    private String authorizedGrantTypes;

    @Column(name = "web_server_redirect_uri", columnDefinition = "VARCHAR(256)")
    private String webServerRedirectUri;

    @Column(name = "authorities", columnDefinition = "VARCHAR(256)")
    private String authorities;

    @Column(name = "access_token_validity", columnDefinition = "INTEGER")
    private int accessTokenValidity;

    @Column(name = "refresh_token_validity", columnDefinition = "INTEGER")
    private int refreshTokenValidity;

    @Column(name = "additional_information", columnDefinition = "VARCHAR(4096)")
    private String additionalInformation;

    @Column(name = "autoapprove", columnDefinition = "VARCHAR(256)")
    private String autoapprove;

}
