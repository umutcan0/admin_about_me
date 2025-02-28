package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.requests.cam.ind.IndCustomerRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddCustomerResponse;
import com.etiya.crmlite.core.utilities.results.DataResult;

public interface IndService {

     DataResult<AddCustomerResponse> AddIndCustomer(IndCustomerRequest indCustomerRequest);
}
