package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PtCategory;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-07
 */
public interface PtCategoryMapper 
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param cid 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PtCategory selectPtCategoryByCid(Long cid);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ptCategory 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PtCategory> selectPtCategoryList(PtCategory ptCategory);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ptCategory 【请填写功能名称】
     * @return 结果
     */
    public int insertPtCategory(PtCategory ptCategory);

    /**
     * 修改【请填写功能名称】
     * 
     * @param ptCategory 【请填写功能名称】
     * @return 结果
     */
    public int updatePtCategory(PtCategory ptCategory);

    /**
     * 删除【请填写功能名称】
     * 
     * @param cid 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePtCategoryByCid(Long cid);

    /**
     * 批量删除【请填写功能名称】
     * 
     * @param cids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePtCategoryByCids(String[] cids);
}
