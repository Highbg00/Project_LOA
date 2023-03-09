package com.example.project_loa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="member")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Member extends BaseEntity{
    @Id
    private String id;

    @Column(length = 50)
    private String naver;

    @Column(length = 50)
    private String kakao;

    @Column(length = 40)
    private String pw;

    @Column(length = 40)
    private String email;

    @Column(length = 5)
    private String gender;

    @Column(length = 40)
    private String post;

    @Column(length = 40)
    private String addr;

    @Column(length = 40)
    private String birth;


}
