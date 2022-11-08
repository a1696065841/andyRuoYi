package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequiresPermissions("system:category:view")
    @GetMapping()
    public String category()
    {
        return prefix + "/category";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:category:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PtCategory ptCategory)
    {
        startPage();
        List<PtCategory> list = ptCategoryService.selectPtCategoryList(ptCategory);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:category:export")
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
    @RequiresPermissions("system:category:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PtCategory ptCategory)
    {
        return toAjax(ptCategoryService.insertPtCategory(ptCategory));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:category:edit")
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
    @RequiresPermissions("system:category:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PtCategory ptCategory)
    {
        return toAjax(ptCategoryService.updatePtCategory(ptCategory));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:category:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ptCategoryService.deletePtCategoryByCids(ids));
    }
}
