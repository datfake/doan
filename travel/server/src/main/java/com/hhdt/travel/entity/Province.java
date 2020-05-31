package com.fake.travel.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "province")
public class Province {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    public Province() {
    }

    public Province(Long id, String nameProvince) {
        this.id = id;
        this.name = nameProvince;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProvince() {
        return name;
    }

    public void setNameProvince(String nameProvince) {
        this.name = nameProvince;
    }
}
