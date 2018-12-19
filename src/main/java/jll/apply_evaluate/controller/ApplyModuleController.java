package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.ApplyModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/ApplyModule")
public class ApplyModuleController {

    @Autowired
    private ApplyModuleService applyModuleService;//申请模块

    /**
     * 根据请求ID查询模块
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindApplyModuleByApplyEvaluateId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findApplyModuleByApplyEvaluateId(@RequestParam String applyEvaluateId){
       return applyModuleService.findApplyModuleByApplyEvaluateId(applyEvaluateId);
    }
    /**
     * 审核模块通过
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditApplyModuleForStatus",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editApplyModuleForStatus(@RequestParam String applyModuleId,@RequestParam(defaultValue = "") String remarks){
        applyModuleService.editApplyModuleForStatus(applyModuleId,remarks);
        return "success";
    }
    /**
     * 审核模块不通过
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditApplyModuleForStatusToNot",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editApplyModuleForStatusToNot(@RequestParam String applyModuleId){
        applyModuleService.editApplyModuleForStatusToNot(applyModuleId);
        return "success";
    }
    /**
     * 审核全部通过
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditApplyModuleForStatusByAll",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editApplyModuleForStatusByAll(@RequestParam String applyEvaluateId){
        applyModuleService.editApplyModuleForStatusByAll(applyEvaluateId);
        return "success";
    }

}
