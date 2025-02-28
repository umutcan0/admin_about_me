package com.etiya.crmlite.business.dtos.requests.cam.ind;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddrRequest {



    @Size(min = 5,max = 100,message = "{fieldCharacterRange}")
    private String addrDesc;

    @Size(min = 5,max = 40,message = "{fieldCharacterRange}")
    @NotNull(message = "{notEmpty}")
    private String cityName;

    @NotNull(message = "{notEmpty}")
    @Size(min = 5,max = 40,message = "{fieldCharacterRange}")
    private String strtName;

    @Size(min = 5,max = 40,message = "{fieldCharacterRange}")
    @NotNull(message = "{notEmpty}")
    private String bldgName;

}
