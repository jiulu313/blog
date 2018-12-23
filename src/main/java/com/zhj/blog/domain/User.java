package com.zhj.blog.domain;

/**
 * User实体
 */
public class User {
    private Long id;    //实体的唯一标识
    private String name;
    private String email;

    public User(){
    }

    public User(Long id,String name,String emial){
        this.id = id;
        this.name = name;
        this.email = emial;
    }


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
