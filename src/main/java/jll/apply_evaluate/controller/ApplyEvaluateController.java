package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.ApplyEvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/ApplyEvaluate")
public class ApplyEvaluateController {

    @Autowired
    private ApplyEvaluateService applyEvaluateService;//申请评价

    /**
     * entId企业ID
     * page当前页数
     * rows每页条数
     *查询企业已有关联关系的组织信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindApplyEvaluateForApplyStatus",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findApplyEvaluateForApplyStatus(@RequestParam String entId,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows){
       return applyEvaluateService.findApplyEvaluateForApplyStatus(entId,page,rows);
    }
    /**
     * entId企业ID
     * page当前页数
     * rows每页条数
     * 根据日期查询企业历史申请信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindApplyEvaluateByDate",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findApplyEvaluateByDate(@RequestParam String entId,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows,@RequestParam(required = false) String date){
        return applyEvaluateService.findApplyEvaluateByDate(entId,page,rows,date);
    }
    /**
     * 查看历史申请信息详情
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindApplyEvaluateDetailByApplyEvaluateId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findApplyEvaluateDetailByApplyEvaluateId(@RequestParam String applyEvaluateId){
        return applyEvaluateService.findApplyEvaluateDetailByApplyEvaluateId(applyEvaluateId);
    }
    /**
     *  申请评价完成
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditApplyEvaluateForAuditStatus",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editApplyEvaluateForAuditStatus(@RequestParam String applyEvaluateId,@RequestParam String module){
        System.out.println(applyEvaluateId+"-------------"+module);
        //applyEvaluateService.editApplyEvaluateForAuditStatus(applyEvaluateId,module);
        return "success";
    }
    /**
     * 查询组织的所有审核
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindApplyEvaluateForAuditStatus",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findApplyEvaluateForAuditStatus(@RequestParam String authOrgId,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows,@RequestParam(required = false) String name,@RequestParam(required = false) String date,@RequestParam(required = false) String type,@RequestParam(required = false) String status){
        return applyEvaluateService.findApplyEvaluateForAuditStatus(authOrgId,page,rows,name,date,type,status);
    }
    /**
     * 查询组织所有的信用评价
     * 根据审核状态查询信用评价信息（authOrgId,auditStatus）
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindApplyEvaluateForCreditEvaluate",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findApplyEvaluateForCreditEvaluate(@RequestParam String authOrgId,@RequestParam(required = false) String name,@RequestParam(required = false) String date,@RequestParam(required = false) String level,@RequestParam(required = false) String auditStatus,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows){
        Map map=new HashMap();
        map.put("daishenhe",applyEvaluateService.findApplyEvaluateByAuditStatusForCount(authOrgId,"1"));
        map.put("shenhezhong",applyEvaluateService.findApplyEvaluateByAuditStatusForCount(authOrgId,"2"));
        map.put("daipingjia",applyEvaluateService.findApplyEvaluateByAuditStatusForCount(authOrgId,"3"));
        map.put("yiwancheng",applyEvaluateService.findApplyEvaluateByAuditStatusForCount(authOrgId,"4"));
        map.put("info",applyEvaluateService.findApplyEvaluateForCreditEvaluate(authOrgId,name,date,level,auditStatus,page,rows));
        return map;
    }

}
