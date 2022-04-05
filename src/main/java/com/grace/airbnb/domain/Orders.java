package com.grace.airbnb.domain;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders")
@Getter
@EntityListeners(AuditingEntityListener.class)

public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id", columnDefinition = "bigint(20) comment '숙소 종류 id'")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Payment payment;

    @Column(name = "amount", columnDefinition = "int comment '결제 금액'")
    private Long amount;

    @Column(name = "check_in_date", columnDefinition = "date comment '체크인 날짜'")
    private LocalDate checkInDate;

    @Column(name = "check_out_date", columnDefinition = "date comment '체크아웃 날짜'")
    private LocalDate checkOutDate;

    @Column(name = "cancel_date", columnDefinition = "date comment '취소날짜'")
    private LocalDate cancelDate;

    @Column(name = "cancel_member_id", columnDefinition = "int comment '취소 직원 id'")
    private Long cancelMemberId;



}
