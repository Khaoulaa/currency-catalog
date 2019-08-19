package com.currency.currencycatalog.entity;


import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@ToString
public class Currency {
    private String id;
    private Attribute attributes;

    public String getId() {
        return id;
    }

    public Attribute getAttributes() {
        return attributes;
    }
}

