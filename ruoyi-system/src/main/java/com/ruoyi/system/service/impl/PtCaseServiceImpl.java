package com.ruoyi.system.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.IdUtils;
import com.ruoyi.common.utils.uuid.UIDUtil;
import com.ruoyi.system.domain.PtCaseCategory;
import com.ruoyi.system.domain.PtCaseModel;
import com.ruoyi.system.domain.PtCategory;
import com.ruoyi.system.mapper.PtCategoryMapper;
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
    private PtCategoryMapper ptCategoryMapper;
    @Autowired
    private IPtCaseCategoryService ptCaseCategoryService;

    /**
     * 查询【请填写功能名称】
     *
     * @param caseId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PtCase selectPtCaseByCaseId(PtCase ptCase) {
        PtCaseCategory ptCaseCategory = new PtCaseCategory();
        ptCaseCategory.setCaseId(ptCase.getCaseId());
        //删除空元素
        if (ptCase.getCategoryId()!=null){
            List<String> collect = ptCase.getCategoryId().stream().filter(e -> StringUtils.isNotEmpty(e)).collect(Collectors.toList());
            ptCase.setCategoryId(collect);
        }
        List<PtCaseCategory> ptCaseCategories = ptCaseCategoryService.selectPtCaseCategoryList(ptCaseCategory);
        List<Long> collect = ptCaseCategories.stream().map(PtCaseCategory::getCategoryId).collect(Collectors.toList());
        PtCase ptCase2 = ptCaseMapper.selectPtCaseByCaseId(ptCase.getCaseId());
        if (ptCase2==null){
            return null;
        }
        List<PtCategory> ptCategories = new ArrayList<>();
        List<String> collect2 = new ArrayList<>();
        for (Long aLong : collect) {
            PtCategory ptCategory = ptCategoryMapper.selectPtCategoryByCid(aLong);
            if (ptCategory!=null){
                ptCategories.add(ptCategory);
                collect2.add(String.valueOf(aLong));
            }
        }
        ptCase2.setPtCategories(ptCategories);
        ptCase2.setCategoryId(collect2);
        return ptCase2;
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param ptCase 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PtCase> selectPtCaseList(PtCase ptCase) {
        List<PtCase> ptCases = ptCaseMapper.selectPtCaseList(ptCase);
        //删除空元素
        if (ptCase.getCategoryId()!=null){
            List<String> collect = ptCase.getCategoryId().stream().filter(e -> StringUtils.isNotEmpty(e)).collect(Collectors.toList());
            ptCase.setCategoryId(collect);
        }
        for (PtCase aCase : ptCases) {
            PtCaseCategory ptCaseCategory = new PtCaseCategory();
            ptCaseCategory.setCaseId(aCase.getCaseId());
            List<PtCaseCategory> ptCaseCategories = ptCaseCategoryService.selectPtCaseCategoryList(ptCaseCategory);
            List<Long> collect = ptCaseCategories.stream().map(PtCaseCategory::getCategoryId).collect(Collectors.toList());
            List<PtCategory> ptCategories = new ArrayList<>();
            List<String> collect2 = new ArrayList<>();
            for (Long aLong : collect) {
                PtCategory ptCategory = ptCategoryMapper.selectPtCategoryByCid(aLong);
                if (ptCategory!=null){
                    ptCategories.add(ptCategory);
                    collect2.add(String.valueOf(aLong));
                }
            }
            aCase.setCategoryId(collect2);
            aCase.setPtCategories(ptCategories);
            //添加案例下级
            aCase.setPtCaseModels(ptCaseMapper.selectPtCaseModelByCaseId(aCase.getCaseId()));
        }
        return ptCases;
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
        //获取案例下级模块
        List<PtCaseModel> ptCaseModels = ptCase.getPtCaseModels();
        if(ptCaseModels!=null && ptCaseModels.size()>0){
            //设置关联
            ptCaseModels.stream().forEach(item ->{
                item.setPtCaseId(ptCase.getCaseId());
            });
            //进行案例下级添加操作
            ptCaseMapper.insertPtCaseModels(ptCaseModels);
        }
        insertPtCaseCategory(ptCase);
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
        if (ptCase.getCategoryId() != null) {
            ptCaseCategoryService.deleteByCaseId(ptCase.getCaseId());
            insertPtCaseCategory(ptCase);
        }
        if (ptCase.getPtCaseModels()!=null && ptCase.getPtCaseModels().size()>0){
            //批量修改案例下级模块
            for (PtCaseModel ptCaseModel : ptCase.getPtCaseModels()) {
                ptCaseMapper.updatePtCaseModel(ptCaseModel);
            }
        }
        return ptCaseMapper.updatePtCase(ptCase);
    }

    public void insertPtCaseCategory(PtCase ptCase) {
        for (String aLong : ptCase.getCategoryId()) {
            PtCaseCategory ptCaseCategory = new PtCaseCategory();
            ptCaseCategory.setCaseId(ptCase.getCaseId());
            ptCaseCategory.setCategoryId(Long.parseLong(aLong));
            ptCaseCategoryService.insertPtCaseCategory(ptCaseCategory);
        }
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param caseIds 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCaseByCaseIds(String caseIds) {
        for (String s : Convert.toStrArray(caseIds)) {
            ptCaseCategoryService.deleteByCaseId(Long.parseLong(s));
        }
        //删除案例下级模块
        ptCaseMapper.deleteModelByCaseId(caseIds);
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
