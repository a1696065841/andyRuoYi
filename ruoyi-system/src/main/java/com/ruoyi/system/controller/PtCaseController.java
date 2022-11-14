package com.ruoyi.system.controller;

import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping()
    public String caseView()
    {
        return prefix + "/case";
    }

    /**
     * 查询【请填写功能名称】列表
     */
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(@RequestBody(required = false) PtCase ptCase)
    {
        List<PtCase> list = ptCaseService.selectPtCaseList(ptCase);
        return getDataTable(list);
    }

    /**
     * 导出【请填写功能名称】列表
     */
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
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(@RequestBody(required = false) PtCase ptCase)
    {
        return toAjax(ptCaseService.insertPtCase(ptCase));
    }

    @PostMapping("/selectPtCaseByCaseId")
    @ResponseBody
    public AjaxResult selectPtCaseByCaseId(@RequestBody(required = false) PtCase ptCase  )
    {
        return AjaxResult.success(ptCaseService.selectPtCaseByCaseId(ptCase));
    }

    /**
     * 修改保存【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(@RequestBody(required = false) PtCase ptCase)
    {
        return toAjax(ptCaseService.updatePtCase(ptCase));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(@RequestBody(required = false) PtCase ptCase )
    {
        String ids = ptCase.getIds();
        return toAjax(ptCaseService.deletePtCaseByCaseIds(ids));
    }
}
