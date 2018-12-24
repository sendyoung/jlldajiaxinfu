package jll.history_browsing.service;

import jll.model.history_browsing.MyNotes;
import jll.utils.XinfuResult;

import java.util.List;

public interface MyNoteService {
    //查看笔记
    public List findNoteList(String userId);
    //添加笔记
    public XinfuResult addNewNote(MyNotes myNotes);
    //修改笔记
    public XinfuResult updateMyNote(String note_content,String note_id);
    //删除笔记
    public XinfuResult deleteMyNote(String note_id);
}
