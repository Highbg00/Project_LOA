package com.example.project_loa.entity;

import lombok.Getter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@EntityListeners(value = { AuditingEntityListener.class})
@Getter
public abstract class BaseEntity {
}
