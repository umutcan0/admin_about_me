package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.AddrService;
import com.etiya.crmlite.business.dtos.requests.cam.ind.AddrRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddrResponse;
import com.etiya.crmlite.core.utilities.enums.TypeValues;
import com.etiya.crmlite.core.utilities.mapping.ModelMapperService;
import com.etiya.crmlite.entities.concretes.cam.Addr;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.repositories.abstracts.AddrDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddrManager implements AddrService {

    private final AddrDao addrDao;
    private final ModelMapperService modelMapperService;

    @Override
    public AddrResponse addAddr(AddrRequest addrRequest, Long partyId) {
        Addr addr= modelMapperService.forRequest().map(addrRequest,Addr.class);
        addr.setRowId(partyId);
        addr.setDataTpId(TypeValues.PARTY);
        addr.setCntryName("Turkey");
        addrDao.save(addr);
        AddrResponse addrResponse =modelMapperService.forResponse().map(addr,AddrResponse.class);
        return addrResponse;
    }
}
