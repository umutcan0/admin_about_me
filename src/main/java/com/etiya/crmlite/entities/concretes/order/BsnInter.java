package com.etiya.crmlite.entities.concretes.order;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "BSN_INTER")
@Builder
@Data
public class BsnInter extends BaseEntity {
    @Id
    @SequenceGenerator(name = "bsnInterSeq", sequenceName = "BSN_INTER_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bsnInterSeq")
    @Column(name = "BSN_INTER_ID")
    private Long bsnInterId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "BSN_INTER_SPEC_ID")
    private BsnInterSpec bsnInterSpec;

    @Column(name = "CUST_ID")
    private Long custId;

    @Column(name = "DESCR")
    private String descr;

    @ManyToOne
    @JoinColumn(name = "BSN_INTER_ST_ID")
    private BsnInterSt bsnInterSt;

    @OneToMany(mappedBy = "prntBsnInter",cascade = CascadeType.MERGE)
    private List<BsnInter> childBsnInters;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "PRNT_BSN_INTER_ID")
    private BsnInter prntBsnInter;

    @Column(name = "ROW_ID")
    private Long rowId;

    @Column(name = "DATA_TP_ID")
    private Long dataTpId;

    @OneToMany(mappedBy = "bsnInter")
    private List<BsnInterItem> bsnInterItems;

    @OneToMany(mappedBy = "bsnInter",cascade = CascadeType.MERGE)
    private List<CustOrdItem> custOrdItems;
}
