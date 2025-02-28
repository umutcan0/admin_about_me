package com.etiya.crmlite.entities.concretes.order;

import com.etiya.crmlite.entities.abstracts.BaseEntity;
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
@Table(name = "CUST_ORD")
@Builder
public class CustOrd extends BaseEntity {
    @Id
    @SequenceGenerator(name = "custOrdSeq", sequenceName = "CUST_ORD_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "custOrdSeq")
    @Column(name = "CUST_ORD_ID")
    private Long custOrdId;

    @Column(name = "ORD_ST_ID")
    private Long OrdStId;

    @Column(name = "CUST_ID")
    private Long custId;

    @Column(name = "BSN_INTER_ID")
    private Long bsnInterId;

    @Column(name = "BSN_INTER_SPEC_ID")
    private Long bsnInterSpecId;

    @OneToMany(mappedBy = "custOrd")
    private List<CustOrdItem> custOrdItems;

    @OneToMany(mappedBy = "custOrd")
    private List<CustOrdCharVal> custOrdCharVals;

}
