package com.etiya.crmlite.api.controllers;

import com.etiya.crmlite.business.abstracts.cam.IndService;
import com.etiya.crmlite.business.dtos.requests.cam.ind.IndCustomerRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddCustomerResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/inds")
public class IndsController {

    private final IndService indService;

    @PostMapping()
    DataResult<AddCustomerResponse> AddIndCustomer(@Valid @RequestBody IndCustomerRequest indCustomerRequest){
        return indService.AddIndCustomer(indCustomerRequest);
    }
}
