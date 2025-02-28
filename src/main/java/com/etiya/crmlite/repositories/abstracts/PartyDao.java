package com.etiya.crmlite.repositories.abstracts;

import com.etiya.crmlite.entities.concretes.cam.Party;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartyDao extends JpaRepository<Party, Long> {
}
