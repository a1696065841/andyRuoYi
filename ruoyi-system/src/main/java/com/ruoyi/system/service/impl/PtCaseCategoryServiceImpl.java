package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PtCaseCategoryMapper;
import com.ruoyi.system.domain.PtCaseCategory;
import com.ruoyi.system.service.IPtCaseCategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-07
 */
@Service
public class PtCaseCategoryServiceImpl implements IPtCaseCategoryService 
{
    @Autowired
    private PtCaseCategoryMapper ptCaseCategoryMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param caseCategoryId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PtCaseCategory selectPtCaseCategoryByCaseCategoryId(Long caseCategoryId)
    {
        return ptCaseCategoryMapper.selectPtCaseCategoryByCaseCategoryId(caseCategoryId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ptCaseCategory 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PtCaseCategory> selectPtCaseCategoryList(PtCaseCategory ptCaseCategory)
    {
        return ptCaseCategoryMapper.selectPtCaseCategoryList(ptCaseCategory);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ptCaseCategory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPtCaseCategory(PtCaseCategory ptCaseCategory)
    {
        return ptCaseCategoryMapper.insertPtCaseCategory(ptCaseCategory);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ptCaseCategory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePtCaseCategory(PtCaseCategory ptCaseCategory)
    {
        return ptCaseCategoryMapper.updatePtCaseCategory(ptCaseCategory);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param caseCategoryIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCaseCategoryByCaseCategoryIds(String caseCategoryIds)
    {
        return ptCaseCategoryMapper.deletePtCaseCategoryByCaseCategoryIds(Convert.toStrArray(caseCategoryIds));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param caseCategoryId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCaseCategoryByCaseCategoryId(Long caseCategoryId)
    {
        return ptCaseCategoryMapper.deletePtCaseCategoryByCaseCategoryId(caseCategoryId);
    }
}
