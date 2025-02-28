package com.etiya.crmlite.entities.concretes.common;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import com.etiya.crmlite.entities.concretes.prod.ProdCharVal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="GNL_CHAR_VAL")
@Builder
public class GnlCharVal extends BaseEntity {
    @Id
    @SequenceGenerator(name = "gnlCharValSeq", sequenceName = "GNL_CHAR_VAL_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gnlCharValSeq")
    @Column(name = "CHAR_VAL_ID")
    private Long charValId;

    @Column(name = "CHAR_ID")
    private int charId;

    @Column(name = "IS_DFLT")
    private int isDflt;

    @Column(name = "VAL")
    private String val;

    @Column(name = "SHRT_CODE")
    private String shrtCode;

    @Column(name = "SDATE")
    private LocalDate sDate;

    @Column(name = "EDATE")
    private LocalDate eDate;

    @Column(name = "IS_ACTV")
    private int isActv;

    @OneToMany(mappedBy = "gnlCharVal")
    private List<ProdCharVal> prodCharVals;
}