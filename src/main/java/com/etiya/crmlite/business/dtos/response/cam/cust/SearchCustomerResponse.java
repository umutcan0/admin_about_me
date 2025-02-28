package com.etiya.crmlite.business.dtos.response.cam.cust;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCustomerResponse {
    private Long nationalityId;
    private Long customerId;
    private String roleName;
    private String firstName;
    private String secondName;
    private String lastName;


}

