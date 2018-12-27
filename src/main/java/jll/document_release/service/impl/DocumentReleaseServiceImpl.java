package jll.document_release.service.impl;

import com.cn.zyzs.utils.utils.PageView;
import jll.document_release.dao.DocumentReleaseDao;
import jll.document_release.service.DocumentReleaseService;
import jll.model.document_release.DocumentRelease;
import jll.utils.HibernatePageUtil;
import jll.utils.MapTrunPojo;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("documentReleaseService")
@Transactional
public class DocumentReleaseServiceImpl implements DocumentReleaseService {

    @Autowired
    private DocumentReleaseDao documentReleaseDao;

    //添加新的公文
    @Override
    public XinfuResult addNewDocument(DocumentRelease documentRelease) {
        try {
            //documentRelease.setIsDelete("0");
            documentReleaseDao.addNewDocument(documentRelease);
            return XinfuResult.build(200,"添加新的公文成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"添加新的公文失败");
        }
    }

    //查看公文列表
    @Override
    public PageView findDocumentList(String authOrgId,int currentPage,int rows) {
        return HibernatePageUtil.sqlPageUtil(documentReleaseDao.findDocumentList(authOrgId),currentPage,rows);
    }

    //查看公文详情
    @Override
    public DocumentRelease findDocument(String documentId) {
        List list = documentReleaseDao.findDocument(documentId);
        if (list!=null&&list.size()>0){
            Map map = (Map)list.get(0);
            DocumentRelease documentRelease = (DocumentRelease)MapTrunPojo.map2Object(map,DocumentRelease.class);
            return documentRelease;
        }
        return null;
    }

    //更新公文状态(撤回公文,快捷发布等)(0草稿, 1发布 2撤回)
    @Override
    public XinfuResult updateDocumentStatus(String documentStatus, String documentId) {
        try {
            documentReleaseDao.updateDocumentStatus(documentStatus,documentId);
            return XinfuResult.build(200,"变更公文状态成功");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"变更公文状态失败");
        }
    }

    //修改公文
    @Override
    public XinfuResult updateDocumentRelease(DocumentRelease documentRelease) {
        try {
            documentReleaseDao.updateDocumentRelease(documentRelease);
            return XinfuResult.build(200,"修改公文成功!");
        } catch (Exception e) {
            e.printStackTrace();
            return XinfuResult.build(400,"修改公文失败!");
        }
    }
}
