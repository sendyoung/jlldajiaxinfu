package jll.pdf.controller;

import com.lowagie.text.pdf.PdfWriter;
import jll.apply_evaluate.service.CreditFileService;
import jll.model.DetailsInformation;
import jll.model.apply_evaluate.CreditFile;
import jll.pdf.service.BuildPDF;
import jll.utils.DateUtils;
import jll.utils.NumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
@Scope("prototype")
@RequestMapping("/CreditReport")
public class CreditReportController {

    @Autowired
    private BuildPDF buildPDF;

    @Autowired
    private CreditFileService creditFileService;//信用档案

    /**
     * 生成PDF档案
     * authEnterpriseId认证企业ID
     * name生成文件名
     * memo备注名
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditCreditFile",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editCreditFile(HttpServletRequest request, @RequestParam String authEnterpriseId,@RequestParam(required = false) String name,@RequestParam(required = false) String memo) {
        //报告详细信息
        DetailsInformation dic=new DetailsInformation();
        //生成路径
        String path=request.getSession().getServletContext().getRealPath("/pdf/");
        //String path="F:/pdf/";
        //生成文件名
        String filename = DateUtils.DateToStringForNumber(new Date())+name;
        // 生成的pdf文件路径
        String pdfFilePath = path + filename + ".pdf";
        String num = NumUtil.Num();
        buildPDF.generatePDF(num,pdfFilePath, null, PdfWriter.AllowPrinting,dic);
        CreditFile cf=new CreditFile();
        cf.setCreate_time(new Date());
        cf.setDoc_url(pdfFilePath);
        cf.setDoc_name(name);
        cf.setDoc_remark(memo);
        cf.setAuth_enterprise_id(authEnterpriseId);
        creditFileService.editCreditFile(cf);
        return "success";
    }
    /**
     * 回显企业档案
     * authEnterpriseId认证企业ID
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindCreditFileByAuthEnterpriseId",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findCreditFileByAuthEnterpriseId(@RequestParam String authEnterpriseId){
        return creditFileService.findCreditFileByAuthEnterpriseId(authEnterpriseId);
    }
    /**
     * authEnterpriseId企业认证ID
     * name档案名称
     * date档案生成时间
     * 企业档案生成历史
     * page,rows
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindHistoryCreditFile",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findHistoryCreditFile(@RequestParam String authEnterpriseId,@RequestParam(required = false) String name,@RequestParam(required = false) String date,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "10")Integer rows){
        return creditFileService.findHistoryCreditFile(authEnterpriseId,name,date,page,rows);
    }
}
