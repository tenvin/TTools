package com.twg.ttools.serial;

import java.io.Serializable;

/**
 * Created by twg on 2017/4/5.
 * 默认情况下Intellij IDEA是关闭了继承了java.io.Serializable的类生成serialVersionUID的警告。如果需要ide提示生成serialVersionUID
 * 1、setting->Inspections->Serialization issues，将serialzable class without "serialVersionUID"打上勾
 * 2、将光标放到类名上，按atl＋enter键，就会提示生成serialVersionUID了
 */
public class TestSerial implements Serializable {
    private String name;
    private String address;
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getAddress(){
        return address;
    }
    public void setAddress(String address){
        this.address =address;
    }
}
