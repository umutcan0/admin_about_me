package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.CustTpService;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import com.etiya.crmlite.repositories.abstracts.CustTpDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CustTpManager  implements CustTpService {

    private final CustTpDao custTpDao;

    @Override
    public void AddCustType(CustTp custTp) {
        custTpDao.save(custTp);
    }

    @Override
    public CustTp findCustTypeByStatusCode(String shortCode) {
        CustTp custTp = custTpDao.findByShrtCode(shortCode);
        return custTp;
    }


}
