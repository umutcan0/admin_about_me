package com.etiya.crmlite.business.dtos.requests.cam.ind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndUpdateRequest {

    private String frstName;
    private String mName;
    private String brthDate;
    private Long gendrId;
    private String mthrName;
    private String fthrName;
    private Long natId;


}
