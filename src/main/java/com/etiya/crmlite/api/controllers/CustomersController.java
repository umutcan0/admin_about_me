package com.etiya.crmlite.api.controllers;

import com.etiya.crmlite.business.abstracts.cam.CustomerService;

import com.etiya.crmlite.business.constants.ApiPrefix;
import com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustomerResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(ApiPrefix.apiPrefix+"customers")
public class CustomersController {

    private final CustomerService customerService;
    @GetMapping("")
    public DataResult<Slice<List<SearchCustomerResponse>>> searchCustomers(@RequestParam(required = false) Long nationalityId,
                                                                           @RequestParam(required = false) Long customerId,
                                                                           @RequestParam(required = false) String accountNumber,
                                                                           @RequestParam(required = false) String gsmNumber,
                                                                           @RequestParam(required = false) String firstName,
                                                                           @RequestParam(required = false) String lastName,
                                                                           @RequestParam(required = false) Long orderNumber,
                                                                           @RequestParam int page, @RequestParam int pageSize){
        Pageable pageable = PageRequest.of(page-1, pageSize);
        return customerService.searchCustomers(nationalityId, customerId, accountNumber, gsmNumber, firstName, lastName,
                orderNumber, pageable);
    }

}
