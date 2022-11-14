package com.ruoyi.system.service.impl;

import java.util.List;

import com.ruoyi.common.utils.uuid.UIDUtil;
import com.ruoyi.system.mapper.PtCaseCategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.PtCategoryMapper;
import com.ruoyi.system.domain.PtCategory;
import com.ruoyi.system.service.IPtCategoryService;
import com.ruoyi.common.core.text.Convert;

/**
 * 【请填写功能名称】Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-07
 */
@Service
public class PtCategoryServiceImpl implements IPtCategoryService {
    @Autowired
    private PtCategoryMapper ptCategoryMapper;
    @Autowired
    private PtCaseCategoryMapper ptCaseCategoryMapper;

    /**
     * 查询【请填写功能名称】
     *
     * @param cid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    @Override
    public PtCategory selectPtCategoryByCid(Long cid) {
        return ptCategoryMapper.selectPtCategoryByCid(cid);
    }

    public List<PtCategory> selectPtCategoryByPid(PtCategory ptCategory) {
        return ptCategoryMapper.selectPtCategoryList(ptCategory);
    }

    /**
     * 查询【请填写功能名称】列表
     *
     * @param ptCategory 【请填写功能名称】
     * @return 【请填写功能名称】
     */
    @Override
    public List<PtCategory> selectPtCategoryList(PtCategory ptCategory) {
        ptCategory.setLevels(0L);
        List<PtCategory> ptCategories = ptCategoryMapper.selectPtCategoryList(ptCategory);
        for (PtCategory category : ptCategories) {
            PtCategory ptCategory1 = new PtCategory();
            ptCategory1.setParentid(category.getCid().toString());
            List<PtCategory> ptCategories1 = ptCategoryMapper.selectPtCategoryList(ptCategory1);
            category.setChildCategory(ptCategories1);
        }
        return ptCategories;
    }

    /**
     * 新增【请填写功能名称】
     *
     * @param ptCategory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int insertPtCategory(PtCategory ptCategory) {
        if (ptCategory.getCid()==null){
            ptCategory.setCid(UIDUtil.nextId());
        }
        return ptCategoryMapper.insertPtCategory(ptCategory);
    }

    /**
     * 修改【请填写功能名称】
     *
     * @param ptCategory 【请填写功能名称】
     * @return 结果
     */
    @Override
    public int updatePtCategory(PtCategory ptCategory) {
        return ptCategoryMapper.updatePtCategory(ptCategory);
    }

    /**
     * 批量删除【请填写功能名称】
     *
     * @param cids 需要删除的【请填写功能名称】主键
     * @return 结果
     */
    @Override
    public int deletePtCategoryByCids(String cids) {
        for (String s : Convert.toStrArray(cids)) {
            ptCaseCategoryMapper.deleteByCid(Long.parseLong(s));
        }
        return ptCategoryMapper.deletePtCategoryByCids(Convert.toStrArray(cids));
    }
    public void editBatch(PtCategory ptCategory){
        ptCategoryMapper.deleteByPid(String.valueOf(ptCategory.getCid()));
        ptCategoryMapper.updatePtCategory(ptCategory);
        for (int i = 0; i < ptCategory.getChildName().size(); i++) {
            String s=ptCategory.getChildName().get(i);
            PtCategory ptCategory2 = new PtCategory();
            ptCategory2.setNames(s);
            ptCategory2.setLevels(1L);
            ptCategory2.setParentid(String.valueOf(ptCategory.getCid()));
            ptCategory2.setSort(i);
            insertPtCategory(ptCategory2);
        }
    }
}
