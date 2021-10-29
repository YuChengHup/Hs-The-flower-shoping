package com.hs.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FrontRole {


    private Integer pageSize;
    private String comName;
    private Integer comVolume;
    private String priceDesc;
    private String priceAsc;
    private Integer sizId;
    private Integer sorId;
}
