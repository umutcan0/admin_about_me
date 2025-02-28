package com.etiya.crmlite.repositories.abstracts;

import com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustomerResponse;
import com.etiya.crmlite.entities.concretes.cam.Cust;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CustomerDao extends JpaRepository<Cust ,Long> {


    /* Tablo birleştirmeleri yapıldı ardından iletişim bilgisinin bulunduğu tablodan data tipi 9 olan partyid ye eşit olduğu
    için  birleştirme sağlandı ama bu birleştme birinci kısmın hepsini 2. kısmında kesişen verilerini getirerek sağlandı
    bunun yanında datatp i 13 olan tablonun id si yani cust accountdan da veri çekildi
    arama sonucunda bunların boş olabileceğini düşünerek ve  db de büyük yazdığımızı düşünürsek bunları küçültüp case sensivite engellendi
    ayrıca boş bırakılma detayı düşünerek sayfalama ile listelenme sağlandı
     */
    @Query("SELECT DISTINCT new com.etiya.crmlite.business.dtos.response.cam.cust.SearchCustomerResponse(i.natId," +
            " c.custId, prt.name, i.frstName, i.mName, i.lstName)" +
            "FROM Party p JOIN p.ind i JOIN p.partyRoles pr JOIN  pr.cust c JOIN  pr.partyRoleTp prt " +
            "LEFT JOIN c.custAccts ca " +
            "LEFT JOIN CustOrd co on co.custId = c.custId " +
            "LEFT JOIN CntcMedium cm on (cm.rowId = p.partyId and cm.dataTpId = 9 and cm.cntcMediumTpId = 172) " +
            "LEFT JOIN CntcMedium cm2 on (cm.rowId = ca.custAcctId and cm.dataTpId = 13 and cm.cntcMediumTpId = 172) " +
            "where(:nationalityId is null or i.natId =:nationalityId)" +
            "and(:customerId is null or c.custId =:customerId)" +
            "and(:accountNumber is null or ca.acctNo =:accountNumber)" +
            "and(:gsmNumber is null or cm2.cntcData=:gsmNumber or cm.cntcData =:gsmNumber  )" +
            "and(:firstName is null or  lower(i.frstName) LIKE CONCAT(lower(:firstName) ,'%'))" +
            "and(:orderNumber is null or co.custOrdId =:orderNumber)" +
            "and(:lastName is null or lower(i.lstName) LIKE CONCAT(lower(:lastName),'%'))")
    Slice<List<SearchCustomerResponse>> findCustomersBySearchFilters(@Param("nationalityId") Long natId,
                                                                    @Param("customerId") Long custId,
                                                                    @Param("accountNumber") String acctNumber,
                                                                    @Param("gsmNumber") String gsmNumber,
                                                                    @Param("firstName") String frstName,
                                                                    @Param("lastName") String lstName,
                                                                    @Param("orderNumber") Long ordrNumber,
                                                                    Pageable pageable);
}
