package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.PartyService;

import com.etiya.crmlite.core.internationalization.MessageService;
import com.etiya.crmlite.core.utilities.enums.GnlSt;
import com.etiya.crmlite.core.utilities.enums.GnlTps;
import com.etiya.crmlite.core.utilities.enums.PartyRoleTps;
import com.etiya.crmlite.core.utilities.mapping.ModelMapperService;

import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.repositories.abstracts.PartyDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public  class PartyManager implements PartyService {

    private final PartyDao partyDao;
    private final ModelMapperService modelMapperService;
    private final MessageService messageService;


    @Override
    public Party AddParty(Party party) {
       party.setPartyTpId(GnlTps.INDV);
       party.setStId(GnlSt.PARTY_ROLE_ACTV);
        partyDao.save(party);
        return party;
    }
}
