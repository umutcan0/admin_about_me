package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.CustomerService;
import com.etiya.crmlite.business.abstracts.cam.IndService;
import com.etiya.crmlite.business.abstracts.cam.PartyService;;
import com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustomerResponse;

import com.etiya.crmlite.core.internationalization.MessageService;
import com.etiya.crmlite.core.utilities.mapping.ModelMapperService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.ErrorDataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import com.etiya.crmlite.repositories.abstracts.CustomerDao;
import lombok.AllArgsConstructor;
import com.etiya.crmlite.business.constants.Messages;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CostomerMaanager implements CustomerService {

    private final CustomerDao customerDao;
    private final MessageService messageService;
    private final ModelMapperService modelMapperService;


    public DataResult<Slice<List<SearchCustomerResponse>>> searchCustomers(Long nationalityId, Long customerId, String accountNumber, String gsmNumber, String firstName, String lastName, Long orderNumber, Pageable pageable) {
        Slice<List<SearchCustomerResponse>> response = customerDao.findCustomersBySearchFilters(nationalityId,
                customerId, accountNumber, gsmNumber, firstName, lastName, orderNumber, pageable);
        return checkCustomersExistsByFilter(response);
    }

    @Override
    public void addcust(Cust cust) {
        customerDao.save(cust);
    }


    private DataResult<Slice<List<SearchCustomerResponse>>> checkCustomersExistsByFilter(Slice<List<SearchCustomerResponse>>
                                                                                                response) {
        if (response.getContent().size() < 1) {
            return new ErrorDataResult<>(response,Messages.Customer.customerNotFound);
        } else if (response.getContent().size() > 1) {
            return new SuccessDataResult<>(response, messageService.getMessage(Messages.Customer.customersListed));
        } else {
            return new SuccessDataResult<>(response, messageService.getMessage(Messages.Customer.customerFetched));
        }
    }
}
