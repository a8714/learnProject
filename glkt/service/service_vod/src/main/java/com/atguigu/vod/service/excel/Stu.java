package com.atguigu.vod.service.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author roo
 * @date 2023/3/15
 */
@Data
public class Stu {
    @ExcelProperty("年龄")
    private int age;
    @ExcelProperty("姓名")
    private String name;
}
