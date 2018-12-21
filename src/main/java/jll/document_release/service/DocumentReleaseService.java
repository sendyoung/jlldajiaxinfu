package jll.document_release.service;

import com.cn.zyzs.utils.utils.PageView;
import jll.model.document_release.DocumentRelease;
import jll.utils.XinfuResult;

public interface DocumentReleaseService {

    //新的公文
    public XinfuResult addNewDocument(DocumentRelease documentRelease);
    //历史公文列表
    public PageView findDocumentList(String authOrgId,int currentPage,int rows);
    //公文详情
    public DocumentRelease findDocument(String documentId);
     //修改公文状态(快捷发布,撤回公文)(0草稿,1发布 2撤回)
    public XinfuResult updateDocumentStatus(String documentStatus,String documentId);
    //修改公文
    public XinfuResult updateDocumentRelease(DocumentRelease documentRelease);
}
