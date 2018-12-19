package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.ApplyPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/ApplyPermission")
public class ApplyPermissionController {

    @Autowired
    private ApplyPermissionService applyPermissionService;//申请模块

    /**
     * 查询所有申请模块
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindApplyPermission",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findApplyPermission(){
       return applyPermissionService.findApplyPermission();
    }


}
