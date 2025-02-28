package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.business.dtos.requests.cam.ind.CntcMediumRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddCntcMediumResponse;
import com.etiya.crmlite.entities.concretes.common.CntcMedium;

public interface CntcMediumService {

    AddCntcMediumResponse addEmail(Long partyId, CntcMediumRequest cntcMediumRequest);
    AddCntcMediumResponse addFax(Long partyId, CntcMediumRequest cntcMediumRequest);
    AddCntcMediumResponse addMobilePhone(Long partyId, CntcMediumRequest cntcMediumRequest);
    AddCntcMediumResponse addHomePhone(Long partyId, CntcMediumRequest cntcMediumRequest);

}
