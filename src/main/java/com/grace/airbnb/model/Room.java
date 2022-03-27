package com.grace.airbnb.model;

import com.grace.airbnb.util.BooleanToYNConverter;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "room")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", columnDefinition = "bigint(20) comment '숙소 id'")
    private String id;

    // member 호스트 id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    // room_sub_type 숙소 서브 유형 id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_sub_type_id", nullable = false)
    private RoomSubType roomSubType;

    // room_type_code 숙소 유형
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_type_id", nullable = false)
    private RoomType roomType;

    // room_privacy_type 숙소 종류 id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_private_type_id", nullable = false)
    private RoomPrivacyType roomPrivacyType;

    @Column(name = "name", columnDefinition = "VARCHAR(256) comment '숙소명'")
    private String name;

    @Column(name = "postcode", columnDefinition = "VARCHAR(256) comment '우편번호'")
    private String postcode;

    @Column(name = "address1", columnDefinition = "VARCHAR(500) comment '주소1'")
    private String address1 ;

    @Column(name = "address2", columnDefinition = "VARCHAR(256) comment '주소2'")
    private String address2;

    @Column(name = "latitude", columnDefinition = "decimal(10,10) comment '위도'")
    private BigDecimal latitude;

    @Column(name = "longitude", columnDefinition = "decimal(10,10) comment '경도'")
    private BigDecimal longitude;

    // common code?
    @Column(name = "reservation_type", columnDefinition = "VARCHAR(256) comment '예약유형'")
    private String reservationType;

    @Column(name = "price", columnDefinition = "int comment '기본가격'")
    private Long price;

    @Column(name = "addition_fee", columnDefinition = "int comment '추가수수료'")
    private Long additionFee;

    @Column(name = "cleaning_fee", columnDefinition = "int comment '청소비'")
    private Long cleaningFee;

    @Column(name = "week_end_one_day_price", columnDefinition = "int comment '주말 1박 요금'")
    private Long  weekEndOneDayPrice;

    @Column(name = "head_count", columnDefinition = "smallint comment '인원'")
    private int headCount;

    @Column(name = "max_head_count", columnDefinition = "smallint comment '최대인원수'")
    private int maxHeadCount ;

    @Column(name = "bedroom_cnt", columnDefinition = "smallint comment '침실개수'")
    private int bedroomCnt;

    @Column(name = "bed_cnt", columnDefinition = "smallint comment '침대개수'")
    private int bedCnt;

    @Column(name = "toilet_cnt", columnDefinition = "smallint comment '화장실 수'")
    private int toiletCnt;

    @Column(name = "check_in_time", columnDefinition = "VARCHAR(20) comment '체크인시간'")
    private String checkInTime;

    @Column(name = "check_out_time", columnDefinition = "VARCHAR(20) comment '체크아웃시간'")
    private String checkOutTime;

    // common code 운영중, 운영중지, 비활성
    @Column(name = "room_manage_type", columnDefinition = "VARCHAR(256) comment '숙소운영상태'")
    private String roomManageType;

    @Column(name = "reservation_close_time", columnDefinition = "VARCHAR(20) comment '예약마감시간'")
    private String reservationCloseTime;

    @Column(name = "room_use_rule", columnDefinition = "text comment '숙소이용규칙'")
    private String roomUseRule;

    @Column(name = "max_stay_day", columnDefinition = "smallint comment '최대숙박일'")
    private int maxStayDay;

    @Convert(converter = BooleanToYNConverter.class)
    @Column(name = "save_room_complete_yn", columnDefinition = "char(1) default 'N' comment '저장완료여부'", nullable = false)
    private boolean saveRoomCompleteYN;

    /*@Column(name = "", columnDefinition = "VARCHAR(256) comment ''")
    private String ;*/

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
