package com.fake.travel.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false,length = 3000)
    private String Content;

    @ManyToOne
    @JoinColumn(name = "id_province")
    private Province province;
}
