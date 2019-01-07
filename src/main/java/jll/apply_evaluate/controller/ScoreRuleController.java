package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.ScoreRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/ScoreRule")
public class ScoreRuleController {

    @Autowired
    private ScoreRuleService scoreRuleService;//评分规则


    /**
     * 查询评分规则
     * authOrgId组织ID
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindScoreRule",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findScoreRule(@RequestParam String authOrgId,@RequestParam String applyEvaluateId){
        return scoreRuleService.findScoreRule(authOrgId,applyEvaluateId);
    }

}
