package com.etiya.crmlite.repositories.abstracts;

import com.etiya.crmlite.entities.concretes.cam.PartyRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRoleDao extends JpaRepository<PartyRole,Long> {
}
