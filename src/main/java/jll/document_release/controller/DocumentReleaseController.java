package jll.document_release.controller;

import com.cn.zyzs.utils.utils.PageView;
import jll.document_release.service.DocumentReleaseService;
import jll.model.document_release.DocumentRelease;
import jll.utils.JsonUtils;
import jll.utils.XinfuResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 公文发布
 */
@Controller
@Scope("prototype")
public class DocumentReleaseController {

    @Autowired
    private DocumentReleaseService documentReleaseService;

    /**
     * 新的公文
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/newdocument"})
    public @ResponseBody
    XinfuResult addNewDocument(@RequestBody Map map){
        DocumentRelease documentRelease = JsonUtils.jsonToPojo((String)map.get("documentRelease"),DocumentRelease.class);
       // System.out.println("看看有没有" + documentRelease.toString() + "aaaaaaaaaaaaaaaaaaa");
        return documentReleaseService.addNewDocument(documentRelease);
    }

    /**
     *  查看历史公文列表
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/documentlist"})
    public @ResponseBody
    PageView findDocumentList(String authOrgId, @RequestParam(defaultValue = "1") int currentPage, @RequestParam(defaultValue = "10") int rows){
        return documentReleaseService.findDocumentList(authOrgId,currentPage,rows);
    }

    /**
     *公文查看详情
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/documentdetail"})
    public @ResponseBody DocumentRelease findDocument(String documentId){
        return documentReleaseService.findDocument(documentId);
    }

    /**
     * 修改公文状态(快捷发布,撤回公文)(0草稿,1发布,2撤回)
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/updatedocumentstatus"})
    public @ResponseBody XinfuResult updateDocumentStatus(String documentStatus,String documentId){
        return documentReleaseService.updateDocumentStatus(documentStatus,documentId);
    }

    /**
     *修改公文
     */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(method = {RequestMethod.GET,
            RequestMethod.POST},value = {"/updatedocument"})
    public @ResponseBody XinfuResult updateDocumentRelease(@RequestBody Map map ){
        DocumentRelease documentRelease = JsonUtils.jsonToPojo((String)map.get("documentRelease"),DocumentRelease.class);
        documentReleaseService.addNewDocument(documentRelease);
        return documentReleaseService.updateDocumentRelease(documentRelease);
    }

}
