package com.wugui.datax.admin.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * xxl-job log for glue, used to track job code process
 *
 * @author xuxueli 2016-5-19 17:57:46
 */
@Data
public class JobLogGlue {

    private int id;

    @Schema(description = "任务主键ID")
    private int jobId;

    @Schema(description = "GLUE类型\t#com.xxl.job.core.glue.GlueTypeEnum")
    private String glueType;

    @Schema(description = "GLUE源代码")
    private String glueSource;

    @Schema(description = "GLUE备注")
    private String glueRemark;

    private Date addTime;

    private Date updateTime;

}
