package com.etiya.crmlite.business.concretes.cam;

import com.etiya.crmlite.business.abstracts.cam.PartyRoleService;
import com.etiya.crmlite.core.utilities.enums.GnlSt;
import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import com.etiya.crmlite.repositories.abstracts.PartyRoleDao;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class PartyRoleManager implements PartyRoleService {

    private final PartyRoleDao partyRoleDao;


    @Override
    public PartyRole AddPartyRole(PartyRole partyRole, Party party, PartyRoleTp partyRoleTp) {
        partyRole.setPartyRoleTp(partyRoleTp);
        partyRole.setParty(party);
        partyRole.setStId(GnlSt.PARTY_ROLE_ACTV);
        partyRoleDao.save(partyRole);
        return partyRole;

    }

}
