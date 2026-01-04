package com.wugui.datax.admin.entity;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * @author xuxueli 2019-05-04 16:43:12
 */
public class JobRole {

    private int id;
    @Schema(description = "账号")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
