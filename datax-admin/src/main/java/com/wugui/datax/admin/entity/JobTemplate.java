package com.wugui.datax.admin.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

/**
 * xxl-job info
 *
 * @author jingwk  2019-11-17 14:25:49
 */
@Data
public class JobTemplate {

	@Schema(description = "主键ID")
	private int id;

	@Schema(description = "执行器主键ID")
	private int jobGroup;

	@Schema(description = "任务执行CRON表达式")
	private String jobCron;

	@Schema(description = "排序")
	private String jobDesc;

	private Date addTime;

	private Date updateTime;

	@Schema(description = "修改用户")
	private int userId;

	@Schema(description = "报警邮件")
	private String alarmEmail;

	@Schema(description = "执行器路由策略")
	private String executorRouteStrategy;

	@Schema(description = "执行器，任务Handler名称")
	private String executorHandler;

	@Schema(description = "执行器，任务参数")
	private String executorParam;

	@Schema(description = "阻塞处理策略")
	private String executorBlockStrategy;

	@Schema(description = "任务执行超时时间，单位秒")
	private int executorTimeout;

	@Schema(description = "失败重试次数")
	private int executorFailRetryCount;

	@Schema(description = "GLUE类型\t#com.wugui.datatx.core.glue.GlueTypeEnum")
	private String glueType;

	@Schema(description = "GLUE源代码")
	private String glueSource;

	@Schema(description = "GLUE备注")
	private String glueRemark;

	@Schema(description = "GLUE更新时间")
	private Date glueUpdatetime;

	@Schema(description = "子任务ID")
	private String childJobId;

	@Schema(description = "上次调度时间")
	private long triggerLastTime;

	@Schema(description = "下次调度时间")
	private long triggerNextTime;

	@Schema(description = "datax运行json")
	private String jobJson;

	@Schema(description = "jvm参数")
	private String jvmParam;

    @Schema(description = "所属项目")
	private int projectId;

	@TableField(exist=false)
	private String projectName;

	@TableField(exist=false)
	private String userName;
}
