package com.example.book;

import javax.lang.model.element.NestingKind;

public class User {
    private String id;
    private String name;
  //  private String money;
    private String spec;
    private String sost;
    private String format;

    public User(String[] parameters) {
        this.id = parameters[0];
        this.name = parameters[1];
        this.spec = parameters[2];
        this.sost = parameters[3];
        //this.format = parameters[4];

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getSost() {
        return sost;
    }

    public void setSost(String sost) {
        this.sost = sost;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
