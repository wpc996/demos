package com.wpc.powermock;

/**
 * @author wangpeican
 * @date 2022/9/20 22:58
 */
public class User {
    private String name;
    private int age;
    private String address;

    private String Id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }
}
