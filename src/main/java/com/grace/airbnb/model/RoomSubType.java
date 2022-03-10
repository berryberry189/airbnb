package com.grace.airbnb.model;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "room_sub_type")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class RoomSubType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_sub_type_id", columnDefinition = "bigint(20) comment '숙소 서브 유형 id'")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;

    @Column(name = "room_sub_type_code", columnDefinition = "VARCHAR(256) comment '숙소 서브 유형 코드'")
    private String roomSubTypeCode;

    @Column(name = "room_type_name", columnDefinition = "VARCHAR(500) comment '숙소 서브 유형명'")
    private String roomSubTypeName;
}
