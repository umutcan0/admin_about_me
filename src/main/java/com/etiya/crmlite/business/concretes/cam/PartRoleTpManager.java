package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.PartyRoleTpService;
import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import com.etiya.crmlite.repositories.abstracts.PartyRoleTpDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PartRoleTpManager implements PartyRoleTpService {

    private final PartyRoleTpDao partyRoleTpDao;

    @Override
    public PartyRoleTp GetPartyRoleByStatusCode(String statusCode) {
       PartyRoleTp partyRoleTp= partyRoleTpDao.findByShrtCode(statusCode);
       return partyRoleTp;

    }
}
