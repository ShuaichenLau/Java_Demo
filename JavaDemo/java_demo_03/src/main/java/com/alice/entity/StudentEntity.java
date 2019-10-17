package com.alice.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author liusc
 * @date 2019-4-29 16:18:29
 */
@Data
@TableName(value = "student")
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = 24652264586530520L;
    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField(value = "name")
    private String name;

    @TableField(value = "address")
    private String address;

    @TableField(value = "age")
    private Integer age;

    @TableField(value = "sex")
    private Integer sex;

    @TableField(value = "school")
    private String school;


}
