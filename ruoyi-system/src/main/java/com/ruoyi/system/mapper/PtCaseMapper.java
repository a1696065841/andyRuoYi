package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.PtCase;
import com.ruoyi.system.domain.PtCaseModel;

/**
 * 【请填写功能名称】Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-08
 */
public interface PtCaseMapper
{
    /**
     * 查询【请填写功能名称】
     * 
     * @param caseId 【请填写功能名称】主键
     * @return 【请填写功能名称】
     */
    public PtCase selectPtCaseByCaseId(Long caseId);

    /**
     * 查询【请填写功能名称】列表
     * 
     * @param ptCase 【请填写功能名称】
     * @return 【请填写功能名称】集合
     */
    public List<PtCase> selectPtCaseList(PtCase ptCase);

    /**
     * 根据案例列表id查询案列model下级
     * @param ptCaseId
     * @return
     */
    public List<PtCaseModel> selectPtCaseModelByCaseId(Long ptCaseId);

    /**
     * 新增【请填写功能名称】
     * 
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    public int insertPtCase(PtCase ptCase);

    /**
     * 批量添加案例下级模块
     * @param ptCaseModels
     * @return
     */
    public int insertPtCaseModels(List<PtCaseModel> ptCaseModels);


    /**
     * 修改【请填写功能名称】
     * 
     * @param ptCase 【请填写功能名称】
     * @return 结果
     */
    public int updatePtCase(PtCase ptCase);

    public int updatePtCaseModel(PtCaseModel ptCaseModel);
    /**
     * 删除【请填写功能名称】
     * 
     * @param caseId 【请填写功能名称】主键
     * @return 结果
     */
    public int deletePtCaseByCaseId(Integer caseId);


    /**
     * 删除案例下级模块
     * @param caseIds 案例id
     * @return
     */
    public int deleteModelByCaseId(String caseIds);
    /**
     * 批量删除【请填写功能名称】
     * 
     * @param caseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePtCaseByCaseIds(String[] caseIds);

}
