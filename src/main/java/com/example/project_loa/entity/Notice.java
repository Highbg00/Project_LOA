package com.example.project_loa.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name="notice")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Notice extends BaseEntity{
    @Id
    private int id;

    @Column(length = 500)
    private int readcnt, root;

    @Column(length = 500)
    @ColumnDefault("0")
    private int step, indent;

    @Column(length = 300)
    private String title, writer, filename, filepath;

    @Column(length = 4000)
    private String content;

    @Column(length = 500)
    private Date writedate;

}
