package com.wugui.datax.admin.controller;

import com.wugui.datax.admin.common.Result;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wugui.datax.admin.core.util.LocalCacheUtil;
import com.wugui.datax.admin.entity.JobDatasource;
import com.wugui.datax.admin.service.JobDatasourceService;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * jdbc数据源配置控制器层
 *
 * @author zhouhongfa@gz-yibo.com
 * @version v1.0
 * @since 2019-07-30
 */
@RestController
@RequestMapping("/api/jobJdbcDatasource")
@Tag(name = "jdbc数据源配置接口")
public class JobDatasourceController extends BaseController {
    /**
     * 服务对象
     */
    @Autowired
    private JobDatasourceService jobJdbcDatasourceService;

    /**
     * 分页查询所有数据
     *
     * @return 所有数据
     */
    @GetMapping
    @Operation(summary = "分页查询所有数据")
    public Result<IPage<JobDatasource>> selectAll() {
        BaseForm form = new BaseForm();
        QueryWrapper<JobDatasource> query = (QueryWrapper<JobDatasource>) form.pageQueryWrapperCustom(form.getParameters(), new QueryWrapper<JobDatasource>());
        return success(jobJdbcDatasourceService.page(form.getPlusPagingQueryEntity(), query));
    }

    /**
     * 获取所有数据源
     * @return
     */
    @Operation(summary = "获取所有数据源")
    @GetMapping("/all")
    public Result<List<JobDatasource>> selectAllDatasource() {
        return success(this.jobJdbcDatasourceService.selectAllDatasource());
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @Operation(summary = "通过主键查询单条数据")
    @GetMapping("{id}")
    public Result<JobDatasource> selectOne(@PathVariable Serializable id) {
        return success(this.jobJdbcDatasourceService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param entity 实体对象
     * @return 新增结果
     */
    @Operation(summary = "新增数据")
    @PostMapping
    public Result<Boolean> insert(@RequestBody JobDatasource entity) {
        return success(this.jobJdbcDatasourceService.save(entity));
    }

    /**
     * 修改数据
     *
     * @param entity 实体对象
     * @return 修改结果
     */
    @PutMapping
    @Operation(summary = "修改数据")
    public Result<Boolean> update(@RequestBody JobDatasource entity) {
        LocalCacheUtil.remove(entity.getDatasourceName());
        JobDatasource d = jobJdbcDatasourceService.getById(entity.getId());
        if (null != d.getJdbcUsername() && entity.getJdbcUsername().equals(d.getJdbcUsername())) {
            entity.setJdbcUsername(null);
        }
        if (null != entity.getJdbcPassword() && entity.getJdbcPassword().equals(d.getJdbcPassword())) {
            entity.setJdbcPassword(null);
        }
        return success(this.jobJdbcDatasourceService.updateById(entity));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    @Operation(summary = "删除数据")
    public Result<Boolean> delete(@RequestParam("idList") List<Long> idList) {
        return success(this.jobJdbcDatasourceService.removeByIds(idList));
    }

    /**
     * 测试数据源
     * @param jobJdbcDatasource
     * @return
     */
    @PostMapping("/test")
    @Operation(summary = "测试数据")
    public Result<Boolean> dataSourceTest (@RequestBody JobDatasource jobJdbcDatasource) throws IOException {
        return success(jobJdbcDatasourceService.dataSourceTest(jobJdbcDatasource));
    }
}