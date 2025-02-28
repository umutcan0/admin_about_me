package com.etiya.crmlite.repositories.abstracts;

import com.etiya.crmlite.entities.concretes.cam.PartyRoleTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyRoleTpDao extends JpaRepository<PartyRoleTp, Long> {
    PartyRoleTp findByShrtCode(String shortCode);
}
