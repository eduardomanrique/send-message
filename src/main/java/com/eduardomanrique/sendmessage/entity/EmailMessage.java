package com.eduardomanrique.sendmessage.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
@JsonTypeName("email")
public class EmailMessage extends Message{

    @Column(name = "email_from", nullable = false)
    private String from;

    @Column(name = "email_to", nullable = false)
    private String to;

    private String title;

    private String body;
}
