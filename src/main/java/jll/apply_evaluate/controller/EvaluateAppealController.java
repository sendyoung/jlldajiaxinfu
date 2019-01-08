package jll.apply_evaluate.controller;

import com.alibaba.fastjson.JSONObject;
import jll.apply_evaluate.service.EvaluateAppealService;
import jll.model.apply_evaluate.EvaluateAppeal;
import jll.utils.DateUtils;
import jll.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

@Controller
@Scope("prototype")
@RequestMapping("/EvaluateAppeal")
public class EvaluateAppealController {

    @Autowired
    private EvaluateAppealService evaluateAppealService;//评价榜单

    /**
     * 添加评价申诉
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditEvaluateAppeal",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editEvaluateAppeal(@RequestParam String applyEvaluateId,@RequestParam String content){
        //添加评价申诉
        EvaluateAppeal ea=JSONObject.parseObject(content,EvaluateAppeal.class);
        ea.setCreate_time(new Date());
        ea.setApply_evaluate_id(applyEvaluateId);
        evaluateAppealService.editEvaluateAppeal(ea);
       return "success";
    }
    /**
     * 上传申诉材料
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/UploadEvaluateAppealFile",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object uploadEvaluateAppealFile(HttpServletRequest request, @RequestParam(name="multfile") MultipartFile multfile){
        //上传文件路径
        //String path = request.getSession().getServletContext().getRealPath("/appeal/");
        String path=request.getSession().getServletContext().getRealPath("/images/");
        String result=null;
        // 保存文件
        String filename = DateUtils.DateToStringForNumber(new Date())+multfile.getOriginalFilename();
        result=FileUploadUtil.imageUpload(multfile, path,filename);
        if(result.equals("success")){
            return "/images/"+filename;
        }
        return "error";
    }
    /**
     * 查询历史申诉
     * authEnterpriseId企业Id
     * appealStype申诉类型  1 资料有误 2 补全信息 3 恶意诋毁 4 其他
     * appealCreateTime申诉日期
     * appealStatus申诉状态 1、已申诉 2、已受理 3、已驳回 4、已完成
     * page   rows
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindEvaluateAppealHistory",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findEvaluateAppealHistory(@RequestParam String authEnterpriseId,@RequestParam(required = false) String appealStype,@RequestParam(required = false) String appealCreateTime,@RequestParam(required = false) String appealStatus,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows){
       return evaluateAppealService.findEvaluateAppealHistory(authEnterpriseId,appealStype,appealCreateTime,appealStatus,page,rows);
    }
    /**
     * 历史申诉详情
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindEvaluateAppealByApplyEvaluateId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findEvaluateAppealByApplyEvaluateId(@RequestParam String applyEvaluateId){
        return evaluateAppealService.findEvaluateAppealByApplyEvaluateId(applyEvaluateId);
    }
    /**
     * 组织异议管理
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindEvaluateAppealByAuthOrgId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findEvaluateAppealByAuthOrgId(@RequestParam String authOrgId,@RequestParam(required = false)String stype,@RequestParam(required = false)String appealTime,@RequestParam(required = false)String appealStatus,@RequestParam(required = false)String name,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows){
        return evaluateAppealService.findEvaluateAppealByAuthOrgId(authOrgId,stype,appealTime,appealStatus,name,page,rows);
    }
    /**
     * 查看异议管理详情
     * evaluateAppealId 申诉ID
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindEvaluateAppealDetailsForApplyEvaluateId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findEvaluateAppealDetailsForApplyEvaluateId(@RequestParam String evaluateAppealId){
        return evaluateAppealService.findEvaluateAppealDetailsForApplyEvaluateId(evaluateAppealId);
    }
    /**
     * 组织修改异议管理详情
     * authOrgId组织ID
     * handler处理人
     * evaluateAppealId申请ID
     * handleMaterial处理材料
     * objectionTitle异议标题
     * handleContent异议批语
     * appealStatus申诉状态
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditEvaluateAppealForAuthOrgId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editEvaluateAppealForAuthOrgId(@RequestParam String authOrgId,@RequestParam String evaluateAppealId,@RequestParam(required = false) String handler,@RequestParam(required = false) String handleMaterial,@RequestParam(required = false) String objectionTitle,@RequestParam(required = false) String handleContent,@RequestParam(required = false) String appealStatus){
        //查询申诉信息
        EvaluateAppeal ea=evaluateAppealService.findEvaluateAppeal(evaluateAppealId);
        ea.setHandler(handler);
        ea.setHandle_material(handleMaterial);
        ea.setHandle_content(handleContent);
        ea.setObjection_title(objectionTitle);
        ea.setUpdate_time(new Date());
        //修改申诉信息
        evaluateAppealService.editEvaluateAppealForAuthOrgId(authOrgId,ea,appealStatus);
        return "success";
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/seekExperts",method = { RequestMethod.GET, RequestMethod.POST })
    @ResponseBody
    public String createFolw(HttpServletRequest request,
                             HttpServletResponse response,@RequestParam(required = false) String path) {
        //根据图片ID取路径
        if(path==null||path.equals("")){
            path="F:/idea_work/jlldajiaxingfu/target/jll-dajiaxinfu-1.0-SNAPSHOT/WEB-INF/classes/appeal/timg.jpg";
        }
                FileInputStream fis = null;
                OutputStream os = null;
                try {
                        fis = new FileInputStream(path);
                        os = response.getOutputStream();
                       int count = 0;
                        byte[] buffer = new byte[1024 * 8];
                        while ((count = fis.read(buffer)) != -1) {
                                os.write(buffer, 0, count);
                                os.flush();
                            }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                try {
                        fis.close();
                     os.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                return "ok";
            }



}
