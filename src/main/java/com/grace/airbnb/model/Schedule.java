package com.grace.airbnb.model;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedule")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id", columnDefinition = "bigint(20) comment '숙소 종류 id'")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "schedule_date", columnDefinition = "date comment '숙소 유형 코드'")
    private LocalDate scheduleDate;

    @Column(name = "price", columnDefinition = "int comment '금액'")
    private Long price;

    @Column(name = "reserve_step", columnDefinition = "VARCHAR(256) comment '예약단계타입'")
    private String reserveStep;

    @Column(name = "reserve_date", columnDefinition = "datetime comment '예약 일시'")
    private LocalDateTime reserveDate;

    @Column(name = "payment_date", columnDefinition = "datetime comment '결제일시'")
    private LocalDateTime paymentDate;

    @Column(name = "secret_memo", columnDefinition = "text comment '비공개 메모'")
    private String secretMemo;



}
