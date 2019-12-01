package com.atguigu.mybatis;

import com.oracle.webservices.internal.api.databinding.DatabindingMode;
import lombok.Data;

/**
 * @program: mybatis
 * @description: ${description}
 * @author: Mr.Wang
 * @create: 2019-12-01 21:55
 **/
@Data
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private String gender;
}
