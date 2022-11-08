package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PtCaseMapper;
import com.ruoyi.system.domain.PtCase;
import com.ruoyi.system.service.IPtCaseService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-08
 */
@Service
public class PtCaseServiceImpl implements IPtCaseService 
{
    @Autowired
    private PtCaseMapper ptCaseMapper;

    /**
     * 查询【请填写功能名称】
     * 
     * @param caseId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PtCase selectPtCaseByCaseId(Integer caseId)
    {
        return ptCaseMapper.selectPtCaseByCaseId(caseId);
    }

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ptCase 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PtCase> selectPtCaseList(PtCase ptCase)
    {
        return ptCaseMapper.selectPtCaseList(ptCase);
    }

    /**
     * 新增【请填写功能名称】
     * 
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPtCase(PtCase ptCase)
    {
        return ptCaseMapper.insertPtCase(ptCase);
    }

    /**
     * 修改【请填写功能名称】
     * 
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePtCase(PtCase ptCase)
    {
        return ptCaseMapper.updatePtCase(ptCase);
    }

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param caseIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCaseByCaseIds(String caseIds)
    {
        return ptCaseMapper.deletePtCaseByCaseIds(Convert.toStrArray(caseIds));
    }

    /**
     * 删除【请填写功能名称】信息
     * 
     * @param caseId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCaseByCaseId(Integer caseId)
    {
        return ptCaseMapper.deletePtCaseByCaseId(caseId);
    }
}
