package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.EnterprisesPunishmentService;
import jll.apply_evaluate.service.ScoreRecordService;
import jll.apply_evaluate.service.ScoreResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/ScoreResult")
public class ScoreResultController {

    @Autowired
    private ScoreResultService scoreResultService;//评价榜单

    @Autowired
    private ScoreRecordService scoreRecordService;//评分记录

    @Autowired
    private EnterprisesPunishmentService enterprisesPunishmentService;//黑名单

    /**
     * 保存评分
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditScoreResult",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editScoreResult(@RequestParam String authOrgId,@RequestParam String applyEvaluateId,@RequestParam String content){
        //保存评分记录

        //计算总评分
        Float score=scoreRecordService.findScoreRecord(applyEvaluateId);
        //保存评分结果
        scoreResultService.editScoreResult(authOrgId,applyEvaluateId,score);
       return "success";
    }
    /**
     * 组织评分结果等级数量跟红黑榜
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindScoreResultForCount",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findScoreResultForCount(@RequestParam String authOrgId,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10")Integer rows){
        Map map=new HashMap();
        map.put("AAA",scoreResultService.findScoreResultForCount(authOrgId,"AAA"));
        map.put("AA",scoreResultService.findScoreResultForCount(authOrgId,"AA"));
        map.put("A",scoreResultService.findScoreResultForCount(authOrgId,"A"));
        map.put("B",scoreResultService.findScoreResultForCount(authOrgId,"B"));
        map.put("C",scoreResultService.findScoreResultForCount(authOrgId,"C"));
        map.put("redList",scoreResultService.findScoreResultByLevel(authOrgId,"AAA",page,rows));
        map.put("blackList",enterprisesPunishmentService.findEnterprisesPunishmentByAuthOrgId(authOrgId,page,rows));
        return map;
    }


}
