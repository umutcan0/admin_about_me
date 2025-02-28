package com.etiya.crmlite.business.dtos.response.cam.party;


import com.etiya.crmlite.business.dtos.response.cam.cust.AddrResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddCustomerResponse {

    private Long indId;
    private long natId;
    private String frstName;
    private String mName;
    private String lstName;
    private Long gendrId;
    private LocalDate brthDate;
    private String mthrName;
    private String fthrName;
    private AddrResponse addrResponse;

}
