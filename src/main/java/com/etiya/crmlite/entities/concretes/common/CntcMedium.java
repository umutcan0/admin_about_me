package com.etiya.crmlite.entities.concretes.common;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "CNTC_MEDIUM")
@Builder
public class CntcMedium extends BaseEntity {
    @Id
    @SequenceGenerator(name = "cntcMediumSeq", sequenceName = "CNTC_MEDIUM_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "cntcMediumSeq")
    @Column(name = "CNTC_MEDIUM_ID")
    private Long cntcMediumId;

    @Column(name = "ROW_ID")
    private Long rowId;

    @Column(name = "DATA_TP_ID")
    private Long dataTpId;

    @Column(name = "CNTC_DATA")
    private String cntcData;

    @Column(name = "ST_ID")
    private Long stId;

    @Column(name = "CNTC_MEDIUM_TP_ID")
    private Long cntcMediumTpId;

}
