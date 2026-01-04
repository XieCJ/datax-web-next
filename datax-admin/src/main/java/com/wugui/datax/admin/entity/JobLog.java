package com.wugui.datax.admin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * datax-web log, used to track trigger process
 *
 * @author jingwk  2019-11-17 22:08:11
 */
@Data
public class JobLog {

    private long id;

    // job info
    @Schema(description = "执行器主键ID")
    private int jobGroup;
    @Schema(description = "任务，主键ID")
    private int jobId;
    @Schema(description = "任务描述")
    private String jobDesc;

    // execute info
    @Schema(description = "执行器地址，本次执行的地址")
    private String executorAddress;
    @Schema(description = "执行器任务handler")
    private String executorHandler;
    @Schema(description = "执行器任务参数")
    private String executorParam;
    @Schema(description = "执行器任务分片参数，格式如 1/2")
    private String executorShardingParam;
    @Schema(description = "失败重试次数")
    private int executorFailRetryCount;

    // trigger info
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "调度-时间")
    private Date triggerTime;
    @Schema(description = "调度-结果")
    private int triggerCode;
    @Schema(description = "调度-日志")
    private String triggerMsg;

    // handle info
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Schema(description = "执行-时间")
    private Date handleTime;
    @Schema(description = "执行-状态")
    private int handleCode;
    @Schema(description = "执行-日志")
    private String handleMsg;

    // alarm info
    @Schema(description = "告警状态：0-默认、1-无需告警、2-告警成功、3-告警失败")
    private int alarmStatus;

    @Schema(description = "DataX进程Id")
    private String processId;

    @Schema(description = "增量最大id")
    private Long maxId;
}
