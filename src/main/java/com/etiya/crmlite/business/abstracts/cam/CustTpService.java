package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.CustTp;

public interface CustTpService {

    void AddCustType(CustTp custTp);

    CustTp findCustTypeByStatusCode(String shortCode );
}
