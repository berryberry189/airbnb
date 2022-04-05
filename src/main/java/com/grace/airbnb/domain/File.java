package com.grace.airbnb.domain;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "file")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "file_id", columnDefinition = "bigint(20) comment '파일 id'")
    private String id;

    @Column(name = "origin_name", columnDefinition = "VARCHAR(256) comment '원본 파일 명'")
    private String originName;

    @Column(name = "file_url", columnDefinition = "VARCHAR(500) comment '파일 url'")
    private String fileUrl;

    // enum 으로 지정
    @Column(name = "file_type", columnDefinition = "VARCHAR(256) comment '파일 타입'")
    private String fileType;

    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "datetime comment '등록일'")
    @CreationTimestamp
    private LocalDateTime createAt;

    @CreatedBy
    @Column(name = "create_id", updatable = false, columnDefinition = "bigint comment '작성직원 ID'")
    private Long createBy;

}
