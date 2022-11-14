package com.ruoyi.system.controller;

import java.util.List;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.uuid.UIDUtil;
import com.ruoyi.system.domain.PtCase;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.PtCategory;
import com.ruoyi.system.service.IPtCategoryService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-11-07
 */
@Controller
@RequestMapping("/system/category")
public class PtCategoryController extends BaseController
{
    private String prefix = "system/category";

    @Autowired
    private IPtCategoryService ptCategoryService;

    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestBody PtCategory ptCategory)
    {
        List<PtCategory> list = ptCategoryService.selectPtCategoryList(ptCategory);
        return getDataTable(list);
    }
    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/selectPtCategoryByPid")
    @ResponseBody
    public TableDataInfo selectPtCategoryByPid(@RequestBody PtCategory ptCategory)
    {
        if (StringUtils.isEmpty(ptCategory.getParentid())){
            throw new RuntimeException("请填写parentid");
        }
        startPage();
        List<PtCategory> list = ptCategoryService.selectPtCategoryByPid(ptCategory);
        return getDataTable(list);
    }
    @PostMapping("/selectPtCategoryByCid")
    @ResponseBody
    public AjaxResult selectPtCategoryByCid(@RequestBody PtCategory ptCategory )
    {
        return AjaxResult.success(ptCategoryService.selectPtCategoryByCid(ptCategory.getCid()));
    }
    /**
     * 导出【请填写功能名称】列表
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtCategory ptCategory)
    {
        List<PtCategory> list = ptCategoryService.selectPtCategoryList(ptCategory);
        ExcelUtil<PtCategory> util = new ExcelUtil<PtCategory>(PtCategory.class);
        return util.exportExcel(list, "【请填写功能名称】数据");
    }

    /**
     * 新增【请填写功能名称】
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody PtCategory ptCategory)
    {
        return toAjax(ptCategoryService.insertPtCategory(ptCategory));
    }

    /**
     * 修改【请填写功能名称】
     */
    @GetMapping("/edit/{cid}")
    public String edit(@PathVariable("cid") Long cid, ModelMap mmap)
    {
        PtCategory ptCategory = ptCategoryService.selectPtCategoryByCid(cid);
        mmap.put("ptCategory", ptCategory);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody PtCategory ptCategory)
    {
        return toAjax(ptCategoryService.updatePtCategory(ptCategory));
    }
    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/editBatch")
    @ResponseBody
    public AjaxResult editBatch(@RequestBody PtCategory ptCategory)
    {
        ptCategoryService.editBatch(ptCategory);
        return toAjax(1);
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(@RequestBody PtCategory ptCategory)
    {
        String ids = ptCategory.getIds();

        return toAjax(ptCategoryService.deletePtCategoryByCids(ids));
    }


    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/addBatch")
    @ResponseBody
    public AjaxResult addBatch(@RequestBody PtCategory ptCategorys)
    {
        long l = UIDUtil.nextId();
        ptCategorys.setCid(l);
        ptCategoryService.insertPtCategory(ptCategorys);
        for (int i = 0; i < ptCategorys.getChildName().size(); i++) {
            String s=ptCategorys.getChildName().get(i);
            PtCategory ptCategory = new PtCategory();
            ptCategory.setNames(s);
            ptCategory.setLevels(1L);
            ptCategory.setParentid(String.valueOf(l));
            ptCategory.setSort(i);
            ptCategoryService.insertPtCategory(ptCategory);
        }


        return toAjax(1);
    }
}
