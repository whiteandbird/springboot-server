package com.itwang.eduservice.controller;

import com.itwang.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: whiteanbird
 * @Descripter:
 * @Date: 2020:10:08  0:38
 */
@RestController
@RequestMapping("/eduservice/user")
@CrossOrigin
public class EduloginController {
    @PostMapping("/login")
    public R login()
    {
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info()
    {
        return R.ok().data("roles","[admin]").data("name","admin").data("avatar","https://online-teach-file.oss-cn-beijing.aliyuncs.com/teacher/2019/11/07/91871e25-fd83-4af6-845f-ea8d471d825d.png");
    }

}
