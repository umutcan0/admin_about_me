package com.etiya.crmlite.business.abstracts.cam;

import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;

public interface PartyRoleTpService {

    PartyRoleTp GetPartyRoleByStatusCode (String statusCode);
}
