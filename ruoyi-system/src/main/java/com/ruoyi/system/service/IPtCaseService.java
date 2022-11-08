package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.PtCase;

/**
 * 【请填写功能名称】Service接口
 * 
 * @author ruoyi
 * @date 2022-11-08
 */
public interface IPtCaseService 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param caseId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PtCase selectPtCaseByCaseId(Integer caseId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ptCase 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PtCase> selectPtCaseList(PtCase ptCase);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    public int insertPtCase(PtCase ptCase);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    public int updatePtCase(PtCase ptCase);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param caseIds 需要删除的【请填写功能名称】主键集合
     * @return 结果
     */
    public int deletePtCaseByCaseIds(String caseIds);

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param caseId 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePtCaseByCaseId(Integer caseId);
}
