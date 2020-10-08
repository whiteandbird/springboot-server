package com.itwang.eduservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itwang.eduservice.entity.EduTeacher;
import com.itwang.eduservice.entity.vo.TeacherVo;
import com.itwang.eduservice.service.EduTeacherService;
import com.itwang.utils.MException;
import com.itwang.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wangduanyue
 * @since 2020-10-06
 */
@RestController
@RequestMapping("/eduservice/edu-teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    //rest 风格
    @GetMapping("/findAll")
    public R findAll()
    {

        List<EduTeacher> eduTeacherList=eduTeacherService.list(null);
        System.out.println(eduTeacherList);
        return R.ok().data("items",eduTeacherList);
    }

    //@PathVariable获取url路径中的
    @GetMapping("/deleteById/{id}")
    public R deleteById(@PathVariable String id)
    {
        System.out.println(id);
        boolean res=eduTeacherService.removeById(id);
        if(res)
            return R.ok();
        return R.error();
    }

    @GetMapping("/test/{id}&{name}")
    public String testid(@PathVariable String id,@PathVariable String name)
    {
        System.out.println(id);
        System.out.println(name);
        return "test";
    }

    @GetMapping("/pageTeacher/{current}/{limit}")
    public R pageTeacher(@PathVariable(required = false) Integer current,
                         @PathVariable(required = false) Integer limit)
    {
        QueryWrapper<EduTeacher> queryWrapper=new QueryWrapper<>();
        current = current==null?1:current;
        limit = limit==null?3:limit;
        Page<EduTeacher> pages=new Page<>(current,limit);
        eduTeacherService.page(pages,null);
        long total=pages.getTotal();
        List<EduTeacher> eduTeacherList=pages.getRecords();
        pages.hasNext();
        pages.setCurrent(2l);
        System.out.println(pages.getRecords());
        System.out.println(eduTeacherList);
        return R.ok().data("total",total).data("items",eduTeacherList);
    }

    @PostMapping("/pageTeacherCondition/{current}/{limit}")
    public R getTeacherCondition(@PathVariable Integer current,
                                 @PathVariable Integer limit,
                                 @RequestBody(required = false) TeacherVo query)
    {
        Page<EduTeacher> page=new Page<>(current,limit);
        QueryWrapper<EduTeacher> queryWrapper=new QueryWrapper<>();

        String name=query.getName();
        Integer level=query.getLevel();
        String begin=query.getBegin();
        String end=query.getEnd();
        if(!StringUtils.isEmpty(name))
            queryWrapper.like("name",name);
        if(!StringUtils.isEmpty(level))
            queryWrapper.eq("level",level);
        if(!StringUtils.isEmpty(begin))
            queryWrapper.ge("gmt_create",begin);
        if(!StringUtils.isEmpty(end))
            queryWrapper.le("gmt_modified",end);
        eduTeacherService.page(page,queryWrapper);
        return R.ok().data("total",page.getTotal()).data("records",page.getRecords());
    }

    @PostMapping("/addTeacher")
    public R addTeacher(@RequestBody EduTeacher eduTeacher)
    {
        boolean res=eduTeacherService.save(eduTeacher);
        return res?R.ok():R.error();
    }

    @GetMapping("/getTeacher/{id}")
    public R getTeacher(@PathVariable Integer id)
    {
        int x=1/0;
        EduTeacher teacher=eduTeacherService.getById(id);
        return R.ok().data("teacher",teacher);
    }

    @PostMapping("/updateTeacher")
    public R updateTeacher(@RequestBody EduTeacher teacher)
    {
        return eduTeacherService.updateById(teacher)?R.ok():R.error();

    }

    @GetMapping("/testError")
    public R errortest()
    {
        throw new MException(200,"抛了个异常");
    }
}

