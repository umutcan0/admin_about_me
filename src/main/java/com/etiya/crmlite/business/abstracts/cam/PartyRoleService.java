package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.Party;
import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;

public interface PartyRoleService {

    PartyRole AddPartyRole(PartyRole partyRole, Party party, PartyRoleTp partyRoleTp);
}
