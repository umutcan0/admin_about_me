package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.*;
import com.etiya.crmlite.business.constants.Messages;
import com.etiya.crmlite.business.dtos.requests.cam.ind.CntcMediumRequest;
import com.etiya.crmlite.business.dtos.requests.cam.ind.IndCustomerRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddCntcMediumResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddrResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddCustomerResponse;
import com.etiya.crmlite.core.exceptions.types.BusinessException;
import com.etiya.crmlite.core.internationalization.MessageService;
import com.etiya.crmlite.core.utilities.enums.GnlSt;
import com.etiya.crmlite.core.utilities.enums.GnlTps;
import com.etiya.crmlite.core.utilities.enums.PartyRoleTps;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.mapping.ModelMapperService;
import com.etiya.crmlite.core.utilities.results.DataResult;
import com.etiya.crmlite.core.utilities.results.SuccessDataResult;
import com.etiya.crmlite.entities.concretes.cam.*;
import com.etiya.crmlite.entities.concretes.common.CntcMedium;
import com.etiya.crmlite.repositories.abstracts.IndDao;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.NewConstructorTypeMunger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class IndManager implements IndService {

    private final IndDao indDao;
    private final ModelMapperService modelMapperService;
    private final PartyService partyService;
    private final CustomerService customerService;
    private final PartyRoleService partyRoleService;
    private final CustTpService custTpService;
    private final PartyRoleTpService partyRoleTpService;
    private final MessageService messageService;
    private final AddrService addrService;
    private final CntcMediumService cntcMediumService;


    @Transactional
    @Override
    public DataResult<AddCustomerResponse> AddIndCustomer(IndCustomerRequest indCustomerRequest) {

        checkIfIndCustomerWithSameNatIdExsist(indCustomerRequest.getNatId());
        Party party =AddParty();
        var addedPartyRole = AddPartyRole(party);
        Ind ind = modelMapperService.forRequest().map(indCustomerRequest, Ind.class);
        ind.setParty(party);
        indDao.save(ind);

        Cust cust = new Cust(null, addedPartyRole, StatusCode.PARTY_ROLE_ACTV, AddCustTp(), null);
        customerService.addcust(cust);


        addrService.addAddr(indCustomerRequest.getAddrRequest(), party.getPartyId());
        AddrResponse addrResponse = modelMapperService.forResponse().map(indCustomerRequest, AddrResponse.class);
        AddCntcMediumResponse addCntcMediumResponse=addContactMedium(indCustomerRequest,party);
        AddCustomerResponse addCustomerResponse = modelMapperService.forResponse().map(indCustomerRequest, AddCustomerResponse.class);
        addCustomerResponse.setAddrResponse(addrResponse);
        addCustomerResponse.setAddCntcMediumResponse(addCntcMediumResponse);
        addCustomerResponse.setIndId(ind.getIndId());
        return new SuccessDataResult<>(addCustomerResponse);
    }


    private Party AddParty(){
       Party party= partyService.AddParty(new Party());
      return party;
    }

    private PartyRole AddPartyRole(Party party) {

        PartyRoleTp partyRoleTp = AddPartyRoleTp();
     PartyRole partyRole=  partyRoleService.AddPartyRole(new PartyRole(),party,partyRoleTp);
     return partyRole;
    }


    private PartyRoleTp AddPartyRoleTp() {
     PartyRoleTp partyRoleTp=partyRoleTpService.GetPartyRoleByStatusCode("p8");
     return partyRoleTp;
    }

    private CustTp AddCustTp() {
        var result = custTpService.findCustTypeByStatusCode("GOV_AGNCY");
        return result;
    }

private AddCntcMediumResponse addContactMedium(IndCustomerRequest indCustomerRequest, Party party){

    AddCntcMediumResponse addCntcMediumResponse= modelMapperService.forResponse().map(indCustomerRequest,AddCntcMediumResponse.class);
    cntcMediumService.addEmail(party.getPartyId(),indCustomerRequest.getCntcMediumRequest());
    cntcMediumService.addFax(party.getPartyId(),indCustomerRequest.getCntcMediumRequest());
    cntcMediumService.addHomePhone(party.getPartyId(),indCustomerRequest.getCntcMediumRequest());
    cntcMediumService.addMobilePhone(party.getPartyId(),indCustomerRequest.getCntcMediumRequest());
    return addCntcMediumResponse;


}

    private void checkIfIndCustomerWithSameNatIdExsist(Long natId) {
        Ind indCustomerToFind = indDao.findByNatId(natId);
        if (indCustomerToFind != null) {
            throw new BusinessException(messageService.getMessageWithParams(Messages.Customer.notFoundCustomerById, natId));
        }
    }
}
