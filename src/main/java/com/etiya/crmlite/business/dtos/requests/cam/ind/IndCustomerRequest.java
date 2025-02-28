package com.etiya.crmlite.business.dtos.requests.cam.ind;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class IndCustomerRequest {

    private long natId;
    private String frstName;
    private String mName;
    private String lstName;
    private Long gendrId;
    private LocalDate brthDate;
    private String mthrName;
    private String fthrName;
   private AddrRequest addrRequest;
   private CntcMediumRequest cntcMediumRequest;

}
