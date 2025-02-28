package com.etiya.crmlite.repositories.abstracts;

import com.etiya.crmlite.entities.concretes.cam.Addr;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddrDao extends JpaRepository<Addr,Long> {
}
