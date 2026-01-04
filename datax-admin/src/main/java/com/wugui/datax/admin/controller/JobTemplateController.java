package com.wugui.datax.admin.controller;


import com.wugui.datatx.core.biz.model.ReturnT;
import com.wugui.datatx.core.util.DateUtil;
import com.wugui.datax.admin.core.cron.CronExpression;
import com.wugui.datax.admin.core.util.I18nUtil;
import com.wugui.datax.admin.entity.JobTemplate;
import com.wugui.datax.admin.service.JobTemplateService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * template controller
 *
 * @author jingwk 2019-12-22 16:13:16
 */
@Tag(name = "任务配置接口")
@RestController
@RequestMapping("/api/jobTemplate")
public class JobTemplateController extends BaseController{

    @Resource
    private JobTemplateService jobTemplateService;

    @GetMapping("/pageList")
    @Operation(summary = "任务模板列表")
    public ReturnT<Map<String, Object>> pageList(@RequestParam(required = false, defaultValue = "0") int current,
                                        @RequestParam(required = false, defaultValue = "10") int size,
                                        int jobGroup, String jobDesc, String executorHandler, int userId,Integer[] projectIds) {

        return new ReturnT<>(jobTemplateService.pageList((current-1)*size, size, jobGroup, jobDesc, executorHandler, userId, projectIds));
    }

    @PostMapping("/add")
    @Operation(summary = "添加任务模板")
    public ReturnT<String> add(HttpServletRequest request, @RequestBody JobTemplate jobTemplate) {
        jobTemplate.setUserId(getCurrentUserId(request));
        return jobTemplateService.add(jobTemplate);
    }

    @PostMapping("/update")
    @Operation(summary = "更新任务")
    public ReturnT<String> update(HttpServletRequest request,@RequestBody JobTemplate jobTemplate) {
        jobTemplate.setUserId(getCurrentUserId(request));
        return jobTemplateService.update(jobTemplate);
    }

    @PostMapping(value = "/remove/{id}")
    @Operation(summary = "移除任务模板")
    public ReturnT<String> remove(@PathVariable(value = "id") int id) {
        return jobTemplateService.remove(id);
    }

    @GetMapping("/nextTriggerTime")
    @Operation(summary = "获取近5次触发时间")
    public ReturnT<List<String>> nextTriggerTime(String cron) {
        List<String> result = new ArrayList<>();
        try {
            CronExpression cronExpression = new CronExpression(cron);
            Date lastTime = new Date();
            for (int i = 0; i < 5; i++) {
                lastTime = cronExpression.getNextValidTimeAfter(lastTime);
                if (lastTime != null) {
                    result.add(DateUtil.formatDateTime(lastTime));
                } else {
                    break;
                }
            }
        } catch (ParseException e) {
            return new ReturnT<>(ReturnT.FAIL_CODE, I18nUtil.getString("jobinfo_field_cron_invalid"));
        }
        return new ReturnT<>(result);
    }
}
