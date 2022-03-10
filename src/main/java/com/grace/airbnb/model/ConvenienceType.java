package com.grace.airbnb.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "convenience_type")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class ConvenienceType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "convenience_type_id", columnDefinition = "bigint(20) comment '편의시설 타입 id'")
    private String id;

    @Column(name = "convenience_type_name", columnDefinition = "VARCHAR(256) comment '편의시설 타입 명'")
    private String convenienceTypeName;

    @Column(name = "create_at", nullable = false, updatable = false, columnDefinition = "datetime comment '등록일'")
    @CreationTimestamp
    private LocalDateTime createAt;

    @CreatedBy
    @Column(name = "create_id", updatable = false, columnDefinition = "bigint comment '작성직원 ID'")
    private Long createBy;

    @UpdateTimestamp
    @Column(name = "update_at", nullable = false, columnDefinition = "datetime comment '수정일'")
    private LocalDateTime updateAt;

    @LastModifiedBy
    @Column(name = "update_id", columnDefinition = "bigint comment '수정직원 ID'")
    protected Long modifyBy;
}
