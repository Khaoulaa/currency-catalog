package com.currency.currencycatalog.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Attribute {
    private String code ;
    private String name;
    private String currency_type ;
    private String code_iso_numeric3;
    private String code_iso_alpha3;
    private String symbol;
    private String native_symbol;
    private String category;
    private Integer decimal_e;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getCurrency_type() {
        return currency_type;
    }

    public String getCode_iso_numeric3() {
        return code_iso_numeric3;
    }

    public String getCode_iso_alpha3() {
        return code_iso_alpha3;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getNative_symbol() {
        return native_symbol;
    }

    public String getCategory() {
        return category;
    }
}
