package com.etiya.crmlite.repositories.abstracts;

import com.etiya.crmlite.entities.concretes.cam.CustTp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustTpDao extends JpaRepository<CustTp,Long> {

    CustTp findByShrtCode(String statusCode);
}
