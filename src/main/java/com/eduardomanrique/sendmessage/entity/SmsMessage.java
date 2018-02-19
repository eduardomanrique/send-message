package com.eduardomanrique.sendmessage.entity;


import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@PrimaryKeyJoinColumn(name = "id")
@JsonTypeName("sms")
public class SmsMessage extends Message {

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="country", column = @Column(name="fromCountry", nullable = false) ),
            @AttributeOverride(name="number", column = @Column(name="fromNumber", nullable = false) )
    } )
    private Phone from;

    @Embedded
    @AttributeOverrides( {
            @AttributeOverride(name="country", column = @Column(name="toCountry", nullable = false) ),
            @AttributeOverride(name="number", column = @Column(name="toNumber", nullable = false) )
    } )
    private Phone to;

    @Column(length = 140, nullable = false)
    private String text;
}
