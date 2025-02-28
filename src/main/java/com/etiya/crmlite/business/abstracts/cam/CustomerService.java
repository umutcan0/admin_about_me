package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustomerResponse;;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import java.util.List;

public interface CustomerService {
    DataResult<Slice<List<SearchCustomerResponse>>> searchCustomers
            (Long nationalityId, Long customerId, String accountNumber, String gsmNumber,
             String firstName, String lastName, Long orderNumber, Pageable pageable);

 void  addcust(Cust cust);

}
