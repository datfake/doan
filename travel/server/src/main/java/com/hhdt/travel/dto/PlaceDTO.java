package com.hhdt.travel.dto;

import lombok.Data;

@Data
public class PlaceDTO {
    private long id;

    private String address;

    private String name;

    private String image;

    private String content;

    private long idProvince;

    private byte[] idImage;
}
