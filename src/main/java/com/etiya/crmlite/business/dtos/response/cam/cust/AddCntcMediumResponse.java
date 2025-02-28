package com.etiya.crmlite.business.dtos.response.cam.cust;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddCntcMediumResponse {
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String fax;
}
