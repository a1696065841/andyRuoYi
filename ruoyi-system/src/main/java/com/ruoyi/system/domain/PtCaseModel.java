package com.ruoyi.system.domain;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 【案例列表新增模块】对象 pt_case_model
 * 
 * @author ruoyi
 * @date 2023/3/22
 */
@Data
public class PtCaseModel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long id;
    /**
     * 图片
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String picInfo;

    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String width;

    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String length;

    /**
     * 内容
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private String describe;
    /**
     * 案例列表id
     */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long ptCaseId;

}
