package com.currency.currencycatalog.model;

public class Criteria {
    private String field ;
    private String text;

    public Criteria(String field, String text) {
        this.field = field;
        this.text = text;
    }

    public String getField() {
        return field;
    }

    public String getText() {
        return text;
    }

    public void setField(String field) {
        this.field = field;
    }

    public void setText(String text) {
        this.text = text;
    }
}
