package com.flaremars.interstingdb.db;

import com.flaremars.annotations.Column;
import com.flaremars.annotations.Entity;

import org.litepal.crud.DataSupport;

/**
 * Created by FlareMars on 2016/10/21.
 */
@Entity(name = "Example", objectClass = Example.class)
public class Example extends DataSupport {

    @Column(updated = false, findBy = true)
    private Long id;
    @Column(findBy = true)
    private String name;
    @Column(updated = false)
    private String description;
    @Column(required = false)
    private Long number;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }
}
