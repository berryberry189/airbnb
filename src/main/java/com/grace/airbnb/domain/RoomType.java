package com.grace.airbnb.domain;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "room_type")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_type_id", columnDefinition = "bigint(20) comment '숙소 유형 id'")
    private String id;

    @Column(name = "room_type_code", columnDefinition = "VARCHAR(256) comment '숙소 유형 코드'")
    private String roomTypeCode;

    @Column(name = "room_type_name", columnDefinition = "VARCHAR(500) comment '숙소 유형명'")
    private String roomTypeName;

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
