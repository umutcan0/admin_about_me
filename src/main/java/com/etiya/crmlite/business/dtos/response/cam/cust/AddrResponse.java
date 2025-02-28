package com.etiya.crmlite.business.dtos.response.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AddrResponse {

   //" private Long addrId;
    private String addrDesc;
    private int isActv;
    private String cityName;
    private String strtName;
    private String bldgName;
}
