package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.CntcMediumService;
import com.etiya.crmlite.business.dtos.requests.cam.ind.CntcMediumRequest;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddCntcMediumResponse;
import com.etiya.crmlite.business.dtos.response.cam.cust.AddrResponse;
import com.etiya.crmlite.core.utilities.enums.CntcMediumType;
import com.etiya.crmlite.core.utilities.enums.StatusCode;
import com.etiya.crmlite.core.utilities.enums.TypeValues;
import com.etiya.crmlite.core.utilities.mapping.ModelMapperService;
import com.etiya.crmlite.entities.concretes.cam.CustTp;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.common.CntcMedium;
import com.etiya.crmlite.repositories.abstracts.CntcMediumDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class CntcMediumManager implements CntcMediumService {

    private final CntcMediumDao cntcMediumDao;
    private final ModelMapperService modelMapperService;

    @Override
    public AddCntcMediumResponse addEmail(Long partyId, CntcMediumRequest cntcMediumRequest) {
        CntcMedium cntcMedium = modelMapperService.forRequest().map(cntcMediumRequest, CntcMedium.class);
        cntcMedium.setCntcData(cntcMediumRequest.getEmail());
        cntcMedium.setCntcMediumTpId(CntcMediumType.EML);
        cntcMedium.setRowId(partyId);
        cntcMedium.setStId(StatusCode.CNTC_MEDIUM_ACTV);
        cntcMedium.setDataTpId(TypeValues.PARTY);
        cntcMediumDao.save(cntcMedium);
        AddCntcMediumResponse response = modelMapperService.forResponse().map(cntcMedium, AddCntcMediumResponse.class);
        return response;
    }

    @Override
    public AddCntcMediumResponse addFax(Long partyId, CntcMediumRequest cntcMediumRequest) {
        CntcMedium cntcMedium = modelMapperService.forRequest().map(cntcMediumRequest, CntcMedium.class);
        cntcMedium.setCntcData(cntcMediumRequest.getFax());
        cntcMedium.setCntcMediumTpId(CntcMediumType.FAX);
        cntcMedium.setRowId(partyId);
        cntcMedium.setStId(StatusCode.CNTC_MEDIUM_ACTV);
        cntcMedium.setDataTpId(TypeValues.PARTY);
        cntcMediumDao.save(cntcMedium);
        AddCntcMediumResponse response = modelMapperService.forResponse().map(cntcMedium, AddCntcMediumResponse.class);
        return response;
    }

    @Override
    public AddCntcMediumResponse addMobilePhone(Long partyId, CntcMediumRequest cntcMediumRequest) {
        CntcMedium cntcMedium = modelMapperService.forRequest().map(cntcMediumRequest, CntcMedium.class);
        cntcMedium.setCntcData(cntcMediumRequest.getMobilePhone());
        cntcMedium.setCntcMediumTpId(CntcMediumType.GSM);
        cntcMedium.setRowId(partyId);
        cntcMedium.setStId(StatusCode.CNTC_MEDIUM_ACTV);
        cntcMedium.setDataTpId(TypeValues.PARTY);
        cntcMediumDao.save(cntcMedium);
        AddCntcMediumResponse response = modelMapperService.forResponse().map(cntcMedium, AddCntcMediumResponse.class);
        return response;
    }

    @Override
    public AddCntcMediumResponse addHomePhone(Long partyId, CntcMediumRequest cntcMediumRequest) {
        CntcMedium cntcMedium = modelMapperService.forRequest().map(cntcMediumRequest, CntcMedium.class);
        cntcMedium.setCntcData(cntcMediumRequest.getHomePhone());
        cntcMedium.setCntcMediumTpId(CntcMediumType.PSTN);
        cntcMedium.setRowId(partyId);
        cntcMedium.setStId(StatusCode.CNTC_MEDIUM_ACTV);
        cntcMedium.setDataTpId(TypeValues.PARTY);
        cntcMediumDao.save(cntcMedium);
        AddCntcMediumResponse response = modelMapperService.forResponse().map(cntcMedium, AddCntcMediumResponse.class);
        return response;
    }
}
