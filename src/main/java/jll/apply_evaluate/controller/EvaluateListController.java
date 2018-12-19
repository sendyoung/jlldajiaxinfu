package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.EvaluateListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
@RequestMapping("/EvaluateList")
public class EvaluateListController {

    @Autowired
    private EvaluateListService evaluateListService;//评价榜单

    /**
     * 生成评价榜单
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditEvaluateList",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editEvaluateList(@RequestParam String authOrgId,@RequestParam String title,@RequestParam String content){
       evaluateListService.editEvaluateList(authOrgId,title,content);
       return "success";
    }


}
