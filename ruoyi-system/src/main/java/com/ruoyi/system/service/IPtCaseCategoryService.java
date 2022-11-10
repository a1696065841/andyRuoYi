package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PtCaseCategory;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-11-07
 */
public interface IPtCaseCategoryService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param caseCategoryId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PtCaseCategory selectPtCaseCategoryByCaseCategoryId(Long caseCategoryId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ptCaseCategory 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PtCaseCategory> selectPtCaseCategoryList(PtCaseCategory ptCaseCategory);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ptCaseCategory 【请填写功能名称】
     * @return 结果
     */
    public int insertPtCaseCategory(PtCaseCategory ptCaseCategory);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ptCaseCategory 【请填写功能名称】
     * @return 结果
     */
    public int updatePtCaseCategory(PtCaseCategory ptCaseCategory);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param caseCategoryIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePtCaseCategoryByCaseCategoryIds(String caseCategoryIds);
    public int deleteByCaseId(Long caseId);
    public int deleteByCid(Long categoryId);
    /**
     * 删除【请填写功能名称】信息
     * 
     * @param caseCategoryId 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePtCaseCategoryByCaseCategoryId(Long caseCategoryId);
}
