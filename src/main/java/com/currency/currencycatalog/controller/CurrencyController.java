package com.currency.currencycatalog.controller;

import com.currency.currencycatalog.entity.Currency;
import com.currency.currencycatalog.model.Criteria;
import com.currency.currencycatalog.services.dto.CurrencyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CurrencyController {

    @Autowired
    CurrencyService currencyService;

    @PostMapping("/currencies/{pageSize}")
    public ResponseEntity<?> getAllCurrencies(@RequestBody Criteria criteria,
                                              @PathVariable("pageSize") int pageSize) throws IOException {

        List<Currency> ppl2 = currencyService.generateListInitial();
        if(criteria.getField() != null &&  criteria.getText() != null) {
            return new ResponseEntity<>(currencyService.paginationList(currencyService.generateResultCurrencies(criteria, ppl2), pageSize), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(currencyService.paginationList(ppl2, pageSize), HttpStatus.OK);
        }
    }
 @GetMapping("/currency/{id}")
    public ResponseEntity<?> getCurrencyById( @PathVariable("id") String id) throws IOException {
     List<Currency> ppl2 = currencyService.generateListInitial();
     Currency result = Collections.unmodifiableList(ppl2.stream()                // convert list to stream
                           .filter(line -> line.getId().equals(id)).collect(Collectors.toList())).get(0);
     return new ResponseEntity<>(result, HttpStatus.OK);
 }
}
