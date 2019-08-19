package com.currency.currencycatalog.services.dto;

import com.currency.currencycatalog.entity.Currency;
import com.currency.currencycatalog.model.Criteria;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface CurrencyService {
    List<Currency> generateResultCurrencies(Criteria criteria , List<Currency> ppl2) ;
    Map<Integer, List<?>> paginationList(List<Currency> list, int pageSize);
    List<Currency> generateListInitial() throws IOException;
}
