package com.hhdt.travel.dto;

import lombok.Data;

@Data
public class PlaceInputDTO {
    private long id;

    private String address;

    private String name;

    private String Content;

    private long idProvince;

    private long idImage;
}
