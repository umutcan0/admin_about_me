package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.requests.cam.ind.AddrRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddrResponse;
import com.etiya.crmlite.entities.concretes.cam.Addr;

public interface AddrService {

    AddrResponse addAddr(AddrRequest addrRequest, Long partId);
}
