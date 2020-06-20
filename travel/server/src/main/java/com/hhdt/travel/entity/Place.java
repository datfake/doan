package com.hhdt.travel.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

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

    @Column
    private String image;

    @Column
    private String content;

    @OneToOne
    @JoinColumn(name = "image_id")
    private Image img;

    @ManyToOne
    @JoinColumn(name = "id_province")
    private Province province;
}
