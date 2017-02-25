package com.di.entity;

import com.di.entity.infoentity.Position;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers;

/**
 * Created by beerman on 25.02.2017.
 */
public class Employee {
    String name;
    Position position;
    Long id;

    public String getInnerCode() {
        return innerCode;

    }

    public void setInnerCode(String innerCode) {
        this.innerCode = innerCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String innerCode;
}
