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
import com.ruoyi.system.domain.PtCase;
import com.ruoyi.system.service.IPtCaseService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 【请填写功能名称】Controller
 * 
 * @author ruoyi
 * @date 2022-11-08
 */
@Controller
@RequestMapping("/system/case")
public class PtCaseController extends BaseController
{
    private String prefix = "system/case";

    @Autowired
    private IPtCaseService ptCaseService;

    @RequiresPermissions("system:case:view")
    @GetMapping()
    public String caseView()
    {
        return prefix + "/case";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @RequiresPermissions("system:case:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(PtCase ptCase)
    {
        startPage();
        List<PtCase> list = ptCaseService.selectPtCaseList(ptCase);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
    @RequiresPermissions("system:case:export")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(PtCase ptCase)
    {
        List<PtCase> list = ptCaseService.selectPtCaseList(ptCase);
        ExcelUtil<PtCase> util = new ExcelUtil<PtCase>(PtCase.class);
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
    @RequiresPermissions("system:case:add")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(PtCase ptCase)
    {
        return toAjax(ptCaseService.insertPtCase(ptCase));
    }

    /**
     * 修改【请填写功能名称】
     */
    @RequiresPermissions("system:case:edit")
    @GetMapping("/edit/{caseId}")
    public String edit(@PathVariable("caseId") Integer caseId, ModelMap mmap)
    {
        PtCase ptCase = ptCaseService.selectPtCaseByCaseId(caseId);
        mmap.put("ptCase", ptCase);
        return prefix + "/edit";
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @RequiresPermissions("system:case:edit")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(PtCase ptCase)
    {
        return toAjax(ptCaseService.updatePtCase(ptCase));
    }

    /**
     * 删除【请填写功能名称】
     */
    @RequiresPermissions("system:case:remove")
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(ptCaseService.deletePtCaseByCaseIds(ids));
    }
}
