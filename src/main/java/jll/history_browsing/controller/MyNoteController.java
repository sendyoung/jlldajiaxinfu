package jll.history_browsing.controller;

import jll.history_browsing.service.MyNoteService;
import jll.model.history_browsing.MyNotes;
import jll.utils.JsonUtils;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 我的笔记
 */
@Controller
@Scope("prototype")
public class MyNoteController {

    @Autowired
    private MyNoteService myNoteService;

    /**
     * 查看我的笔记列表
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/notelist")
    public @ResponseBody
    List findNoteList(String userId){
        return myNoteService.findNoteList(userId);
    }

    /**
     * 添加笔记
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/writenote")
    public @ResponseBody
    XinfuResult addNewNote(@RequestBody Map map){
        MyNotes mynotes = JsonUtils.jsonToPojo((String)map.get("myNotes"),MyNotes.class);
        return myNoteService.addNewNote(mynotes);
    }

    /**
     * 修改笔记内容
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/modifynote")
    public @ResponseBody
    XinfuResult updateMyNote(String noteContent,String noteId){
        return myNoteService.updateMyNote(noteContent,noteId);
    }

    /**
     * 删除笔记
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST}, value = "/delnote")
    public @ResponseBody
    XinfuResult deleteMyNote(String noteId){
        return myNoteService.deleteMyNote(noteId);
    }

}
