package jll.history_browsing.service.impl;

import jll.history_browsing.dao.MyNoteDao;
import jll.history_browsing.service.MyNoteService;
import jll.model.history_browsing.MyNotes;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
@Service("myNoteService")
@Transactional
public class MyNoteServiceImpl implements MyNoteService {

    @Autowired
    private MyNoteDao myNoteDao;

    //查看我的笔记列表
    @Override
    public List findNoteList(String userId) {
        return myNoteDao.findNoteList(userId);
    }

    //添加新的笔记
    @Override
    public XinfuResult addNewNote(MyNotes myNotes) {
        try {
            myNotes.setCreate_time(new Date());
            myNoteDao.addNewNote(myNotes);
            return XinfuResult.build(200,"添加笔记成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"添加笔记失败");
        }
    }

    //修改笔记内容
    @Override
    public XinfuResult updateMyNote(String note_content, String note_id) {
        try {
            myNoteDao.updateMyNote(note_content,note_id);
            return XinfuResult.build(200,"修改笔记内容失败");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"修改笔记内容失败");
        }
    }

    //删除笔记
    @Override
    public XinfuResult deleteMyNote(String note_id) {
        try {
            myNoteDao.deleteMyNote(note_id);
            return XinfuResult.build(200,"删除笔记成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"删除笔记失败");
        }
    }
}
