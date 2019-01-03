package jll.history_browsing.controller;

import com.cn.zyzs.utils.utils.PageView;
import jll.history_browsing.service.MonitorFollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@Scope("prototype")
public class MonitorFollowController {

    @Autowired
    private MonitorFollowService monitorFollowService;

    /**
     *
     * @param userId  用户ID
     * @param type  1监控 2关注
     * @param behaviorClassification  行为分类 1不良 2良好  3新闻舆情
     * @param currentPage
     * @param rows
     * @return
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/monitorFollowList")
    public @ResponseBody
    PageView findMonitorFollowList(@RequestParam String userId,@RequestParam String type, @RequestParam(required = false) String behaviorClassification, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return monitorFollowService.findMonitorFollowList(userId,type,behaviorClassification,currentPage,rows);
    }

    /**
     * 查看我的监控中的未变化的企业最近的动态
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/monitorUnchangedList")
    public @ResponseBody
    PageView findMonitorUnchangedList(String userId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return monitorFollowService.findMonitorUnchangedList(userId,currentPage,rows);
    }

    /**
     * 查看我的监控中的未认证的企业数据
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/monitorUncertified")
    public @ResponseBody
    PageView findMonitorUncertified(String userId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return monitorFollowService.findMonitorUncertified(userId,currentPage,rows);
    }

}
