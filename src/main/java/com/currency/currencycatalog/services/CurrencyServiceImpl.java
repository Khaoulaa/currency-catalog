package com.currency.currencycatalog.services;

import com.currency.currencycatalog.entity.Currency;
import com.currency.currencycatalog.model.Criteria;
import com.currency.currencycatalog.services.dto.CurrencyService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.Math.min;
import static java.util.stream.Collectors.toMap;

@Service
@Slf4j
public class CurrencyServiceImpl implements CurrencyService {
    @Override
    public List<Currency> generateResultCurrencies(Criteria criteria , List<Currency> ppl2) {
        List<Currency> result = new ArrayList<>();
        if(criteria.getField() != null &&  criteria.getText() != null) {
            if(criteria.getField().equals("id")) {
                result = Collections.unmodifiableList(ppl2.stream()                // convert list to stream
                        .filter(line -> line.getId().equals(criteria.getText())).collect(Collectors.toList()));
            } else {
                result = Collections.unmodifiableList(ppl2.stream()                // convert list to stream
                        .filter(line -> {
                            //log.error("content field ::" ,line.getAttributes().getClass().getField(criteria.getField()).equals(criteria.getText()));
                            if(criteria.getField().equals("name"))
                                return line.getAttributes().getName().equals(criteria.getText());
                            else if(criteria.getField().equals("code"))
                                return line.getAttributes().getCode().equals(criteria.getText());
                            else
                                return line.getAttributes().getCurrency_type().equals(criteria.getText());

                        }).collect(Collectors.toList()));

            }
        }
        return result;
    }
    @Override
    public Map<Integer, List<?>> paginationList(List<Currency> list, int pageSize) {
        return IntStream.iterate(0, i -> i + pageSize)
                .limit((list.size() + pageSize - 1) / pageSize)
                .boxed()
                .collect(toMap(i -> i / pageSize,
                        i -> list.subList(i, min(i + pageSize, list.size()))));
    }

    @Override
    public List<Currency> generateListInitial() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("src/main/resources/data.json");
        String absolutePath = file.getAbsolutePath();
        List<Currency> ppl2 = Arrays.asList(objectMapper.readValue(new FileInputStream(absolutePath), Currency[].class));
     return ppl2;
    }
}

