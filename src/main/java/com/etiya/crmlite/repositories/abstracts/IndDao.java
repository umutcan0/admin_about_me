package com.etiya.crmlite.repositories.abstracts;

import com.etiya.crmlite.entities.concretes.cam.Ind;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IndDao extends JpaRepository<Ind,Long> {

    Ind findByNatId(Long natId);
}
