package com.grace.airbnb.domain;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "room_file")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class RoomFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_file_id", columnDefinition = "bigint(20) comment '숙소 파일 id'")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id", nullable = false)
    private Room room;

    @Column(name = "file_url", columnDefinition = "VARCHAR(500) comment '파일 url'")
    private String fileUrl;

}
