package com.tacoxiang.pojo;

import java.io.Serializable;

/**
 * ****************************************************************************************
 * Programs are meant to be read by humans and only incidentally for computers to execute
 * ****************************************************************************************
 * Author : tacoxiang
 * Time : 2020/3/29
 * Package : com.tacoxiang.pojo
 * ProjectName: TacoJaScala
 * Describe :
 * ============================================================
 */
public class PersonPojo implements Serializable {
    private String name;

    public PersonPojo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("PersonPojo{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
