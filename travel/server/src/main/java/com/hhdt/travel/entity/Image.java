package com.hhdt.travel.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Data
@Entity(name="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    @Type(type = "org.hibernate.type.BinaryType")
    private byte[] data;
}
