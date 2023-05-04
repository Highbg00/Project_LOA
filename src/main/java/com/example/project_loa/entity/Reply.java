package com.example.project_loa.entity;

import lombok.*;

import javax.persistence.*;


@Entity
@Table(name="Reply")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reply extends BaseEntity{
    @Id
    private int reply_id;

    @Column(length = 500)
    private int notice_id;

    @Column(length = 500)
    private int step;

    @Column(length = 500)
    private String content;

    @Column(length = 50)
    private String writer, name;
}
