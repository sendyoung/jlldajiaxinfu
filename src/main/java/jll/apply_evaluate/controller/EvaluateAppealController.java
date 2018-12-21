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

}
