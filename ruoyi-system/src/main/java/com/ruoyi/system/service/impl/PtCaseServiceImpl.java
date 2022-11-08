package com.ruoyi.system.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.uuid.UIDUtil;
import com.ruoyi.system.domain.PtCaseCategory;
import com.ruoyi.system.service.IPtCaseCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PtCaseMapper;
import com.ruoyi.system.domain.PtCase;
import com.ruoyi.system.service.IPtCaseService;
import com.ruoyi.common.core.text.Convert;
import org.springframework.util.IdGenerator;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-08
 */
@Service
public class PtCaseServiceImpl implements IPtCaseService {
    @Autowired
    private PtCaseMapper ptCaseMapper;
    @Autowired
    private IPtCaseCategoryService ptCaseCategoryService;

    /**
     * 查询【请填写功能名称】
     *
     * @param caseId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PtCase selectPtCaseByCaseId(Integer caseId) {
        PtCaseCategory ptCaseCategory = new PtCaseCategory();
        ptCaseCategory.setCaseId(Integer.toUnsignedLong(caseId));
        List<PtCaseCategory> ptCaseCategories = ptCaseCategoryService.selectPtCaseCategoryList(ptCaseCategory);
        List<Long> collect = ptCaseCategories.stream().map(PtCaseCategory::getCategoryId).collect(Collectors.toList());
        PtCase ptCase = ptCaseMapper.selectPtCaseByCaseId(caseId);
        ptCase.setCategoryId(collect);
        return ptCase;
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param ptCase 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PtCase> selectPtCaseList(PtCase ptCase) {
        return ptCaseMapper.selectPtCaseList(ptCase);
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPtCase(PtCase ptCase) {

        ptCase.setCaseId(UIDUtil.nextId());
        int i = ptCaseMapper.insertPtCase(ptCase);
        for (Long aLong : ptCase.getCategoryId()) {
            PtCaseCategory ptCaseCategory = new PtCaseCategory();
            ptCaseCategory.setCaseId(ptCase.getCaseId());
            ptCaseCategory.setCategoryId(aLong);
            ptCaseCategoryService.insertPtCaseCategory(ptCaseCategory);
        }
        return i;
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePtCase(PtCase ptCase) {
        return ptCaseMapper.updatePtCase(ptCase);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param caseIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCaseByCaseIds(String caseIds) {
        return ptCaseMapper.deletePtCaseByCaseIds(Convert.toStrArray(caseIds));
    }

    /**
     * 删除【请填写功能名称】信息
     *
     * @param caseId 【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCaseByCaseId(Integer caseId) {
        return ptCaseMapper.deletePtCaseByCaseId(caseId);
    }
}
