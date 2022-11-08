package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 【请填写功能名称】对象 pt_case_category
 * 
 * @author ruoyi
 * @date 2022-11-07
 */
public class PtCaseCategory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long caseCategoryId;

    /** $column.columnComment */
    private Long caseId;

    /** $column.columnComment */
    private Long categoryId;

    public void setCaseCategoryId(Long caseCategoryId) 
    {
        this.caseCategoryId = caseCategoryId;
    }

    public Long getCaseCategoryId() 
    {
        return caseCategoryId;
    }
    public void setCaseId(Long caseId) 
    {
        this.caseId = caseId;
    }

    public Long getCaseId() 
    {
        return caseId;
    }
    public void setCategoryId(Long categoryId) 
    {
        this.categoryId = categoryId;
    }

    public Long getCategoryId() 
    {
        return categoryId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("caseCategoryId", getCaseCategoryId())
            .append("caseId", getCaseId())
            .append("categoryId", getCategoryId())
            .toString();
    }
}
