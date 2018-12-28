package jll.history_browsing.controller;

import com.cn.zyzs.utils.utils.PageView;
import jll.history_browsing.service.HistoryBrowseService;
import jll.model.history_browsing.HistoryBrowsing;
import jll.utils.JsonUtils;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
public class HistoryBrowseController {

    @Autowired
    private HistoryBrowseService historyBrowseService;


    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/addhistory")
    public @ResponseBody
    XinfuResult addHisttory(@RequestBody Map map){
        HistoryBrowsing historyBrowsing = JsonUtils.jsonToPojo((String)map.get("historyBrowsing"),HistoryBrowsing.class);
        return historyBrowseService.addHistoryBrowsing(historyBrowsing);
    }

    /**
     * 查看历史浏览记录列表
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/historylist")
    public @ResponseBody
    PageView findNoteList(String userId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return historyBrowseService.findHistoryList(userId,currentPage,rows);
    }

}
