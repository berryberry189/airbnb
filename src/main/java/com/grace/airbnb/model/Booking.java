package com.grace.airbnb.model;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id", columnDefinition = "bigint(20) comment '숙소 종류 id'")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orders_id", nullable = false)
    private Orders orders;

    @Column(name = "amount", columnDefinition = "int comment '1일 결제 금액'")
    private Long amount;

    @Column(name = "booking_date", columnDefinition = "date comment '예약 날짜'")
    private LocalDate bookingDate;

    @Column(name = "cancel_date", columnDefinition = "date comment '취소날짜'")
    private LocalDate cancelDate;

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
