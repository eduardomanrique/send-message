package com.eduardomanrique.sendmessage.entity;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class Phone {

    private Integer country;

    private String number;

    @Override
    public String toString(){
        return (country != null ? String.format("+%d ", country) : "") + number;
    }
}
