package com.fake.travel.dto;

import lombok.Data;

@Data
public class PlaceDTO {
    private long id;

    private String address;

    private String name;

    private String image;

    private String Content;

    private long idProvince;
}
