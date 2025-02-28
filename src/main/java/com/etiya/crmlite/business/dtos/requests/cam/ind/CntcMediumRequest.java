package com.etiya.crmlite.business.dtos.requests.cam.ind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CntcMediumRequest {
    private String email;
    private String mobilePhone;
    private String homePhone;
    private String fax;
}
