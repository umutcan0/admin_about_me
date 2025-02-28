package com.etiya.crmlite.entities.concretes.common;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.prod.ProdSpecSrvcSpec;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "SRVC_SPEC")
@Builder
public class SrvcSpec extends BaseEntity {
    @Id
    @SequenceGenerator(name = "srvcSpecSeq", sequenceName = "SRVC_SPEC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "srvcSpecSeq")
    @Column(name = "SRVC_SPEC_ID")
    private Long srvcSpecId;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCR")
    private String descr;

    @Column(name = "SRVC_CODE")
    private String srvcCode;

    @Column(name = "ST_ID")
    private Long stId;

    @OneToMany(mappedBy = "srvcSpec")
    private List<ProdSpecSrvcSpec> prodSpecSrvcSpecs;

}
