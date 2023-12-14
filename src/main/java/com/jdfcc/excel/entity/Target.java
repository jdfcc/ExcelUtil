package com.jdfcc.excel.entity;

import com.jdfcc.excel.annotation.ExcelExport;
import com.jdfcc.excel.annotation.ExcelImport;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Jdfcc
 * @HomePage <a href="https://github.com/Jdfcc">Jdfcc</a>
 * @Description 示例配置实体类
 * @DateTime 2023/12/11 17:13
 */

@Data
@Getter
@Setter
public class Target {
    /**
     * 主表关联字段
     */
    @ExcelImport("主表关联字段")
    @ExcelExport(value = "主表关联字段", sort = 0)
    private String filed;

    /**
     * 评价项
     */
    @ExcelImport("评价项")
    @ExcelExport(value = "评价项", sort = 1)
    private String evaluationItem;

    /**
     * 评价细则
     */
    @ExcelImport("评价细则")
    @ExcelExport(value = "评价细则", sort = 2)
    private String evaluationDetail;

    /**
     * 单位
     */
    @ExcelImport("单位")
    @ExcelExport(value = "单位", sort = 3)
    private String unit;

    /**
     * 规格需求_下限值
     */
    @ExcelExport("规格需求_下限值")
    @ExcelImport("规格需求_下限值")
    private String specificationRequirements_Lower;

    /**
     * 规格需求_典型值
     */
    @ExcelImport("规格需求_典型值")
    @ExcelExport("规格需求_典型值")
    private String specificationRequirements_Typical;

    /**
     * 规格需求_上限值
     */
    @ExcelImport("规格需求_上限值")
    @ExcelExport("规格需求_上限值")
    private String specificationRequirements_Higher;

    /**
     * 是否核心字段
     */
    @ExcelImport("是否核心字段")
    @ExcelExport("是否核心字段")
    private String center;



    /**
     * 填写部门
     */
    @ExcelImport("填写部门")
    @ExcelExport("填写部门")
    private String writeDepartment;

    /**
     * 审核部门
     */
    @ExcelImport("审核部门")
    @ExcelExport("审核部门")
    private String auditDepartment;

    /**
     * 是否必填
     */
    @ExcelImport("是否必填")
    @ExcelExport("是否必填")
    private String ask;

}
