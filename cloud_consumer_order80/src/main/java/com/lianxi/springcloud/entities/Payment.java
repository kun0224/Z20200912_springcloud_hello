package com.lianxi.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

//lombok，简化javabean开发
@Data   //相当与get、set方法
@AllArgsConstructor //所有有参的构造器
@NoArgsConstructor  //无参构造器
@ToString   //tostring方法
public class Payment implements Serializable {

    private Long id;
    private String serial;

}
