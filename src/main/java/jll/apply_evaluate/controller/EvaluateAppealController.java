package jll.apply_evaluate.controller;

import com.alibaba.fastjson.JSONObject;
import jll.apply_evaluate.service.EvaluateAppealService;
import jll.data_list.utils.DateUtils;
import jll.data_list.utils.FileUploadUtil;
import jll.model.apply_evaluate.EvaluateAppeal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
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
        String path = request.getSession().getServletContext().getRealPath("/appeal/");
        String result=null;
        // 保存文件
        String filename = DateUtils.DateToStringForNumber(new Date())+multfile.getOriginalFilename();
        result=FileUploadUtil.imageUpload(multfile, path,filename);
        if(result.equals("success")){
            return path+filename;
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

}
