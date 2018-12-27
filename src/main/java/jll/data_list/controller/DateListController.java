package jll.data_list.controller;

import com.cn.zyzs.utils.base.BaseClass;
import jll.data_list.service.*;
import jll.utils.DateUtils;
import jll.utils.FileUploadUtil;
import jll.utils.POIUtil;
import jll.model.data_list.ReportFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/DateList")
public class DateListController extends BaseClass {

    @Autowired
    private EmployeeService employeeService;//员工信息

    @Autowired
    private BranchOfficeService branchOfficeService;//分公司

    @Autowired
    private SubsidiaryCompanyService subsidiaryCompanyService;//子公司

    @Autowired
    private SupplierService supplierService;//供应商

    @Autowired
    private CustomerService customerService;//客户

    @Autowired
    private MainTechnicalEquipmentService mainTechnicalEquipmentService;//主要技术设备

    @Autowired
    private FinancialExpensesService financialExpensesService;//财务费用

    @Autowired
    private ResearchInputService researchInputService;//研发投入

    @Autowired
    private ReportFileService reportFileService;//信息填报上传的资料

    /**
     * entId企业ID
     * 上传填报材料
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditDateList",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editDateList(HttpServletRequest request,@RequestParam String type,@RequestParam String entId,@RequestParam(name="multfile") MultipartFile multfile) throws IOException {
        if("employee".equals(type)){
            //员工信息
            List<String[]> list=POIUtil.readExcelByRows(multfile, 3);
            employeeService.editEmployee(entId,list);
        }else if("branchOffice".equals(type)){
            //分公司
            List<String[]> list=POIUtil.readExcelByRows(multfile, 3);
            branchOfficeService.editBranchOffice(entId,list);
        }else if("subsidiaryCompany".equals(type)){
            //子公司
            List<String[]> list=POIUtil.readExcelByRows(multfile, 3);
            subsidiaryCompanyService.editSubsidiaryCompany(entId,list);
        }else if("supplier".equals(type)){
            //供应商
            List<String[]> list=POIUtil.readExcelByRows(multfile, 4);
            supplierService.editSupplier(entId,list);
        }else if("customer".equals(type)){
            //客户
            List<String[]> list=POIUtil.readExcelByRows(multfile, 4);
            customerService.editCustomer(entId,list);
        }else if("mainTechnicalEquipment".equals(type)){
            //主要技术设备
            List<String[]> list=POIUtil.readExcelByRows(multfile, 2);
            mainTechnicalEquipmentService.editMainTechnicalEquipment(entId,list);
        }else if("financialExpenses".equals(type)){
            //财务费用
            List<String[]> list=POIUtil.readExcelByRows(multfile, 1);
            financialExpensesService.editFinancialExpenses(entId,list);
        }else if("researchInput".equals(type)){
            //研发投入
            List<String[]> list=POIUtil.readExcelByRows(multfile, 1);
            researchInputService.editResearchInput(entId,list);
        }
        return "success";
    }
    /**
     * entId企业ID
     * 上传填报材料
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/UploadDateListFile",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object uploadDateListFile(HttpServletRequest request,@RequestParam String type,@RequestParam String entId,@RequestParam(name="multfile") MultipartFile multfile) throws IOException {
        ReportFile rf=new ReportFile();
        rf.setCreate_time(new Date());
        rf.setEnt_id(entId);
        rf.setFile_name(multfile.getOriginalFilename());
        rf.setFile_type(type);
        //上传文件路径
        String path = request.getSession().getServletContext().getRealPath("/datalist/");

        //String path="/webapp/datalist/";
        String result=null;
        // 保存文件
        String filename = DateUtils.DateToStringForNumber(new Date())+multfile.getOriginalFilename();
        rf.setFile_url(path+filename);
        result=FileUploadUtil.imageUpload(multfile, path,filename);

        if(result.equals("success")){
            reportFileService.editReportFile(rf);
            return rf;
        }
        return "error";
    }
    /**
     * 查询企业上传的材料
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindDateListFile",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findDataListFile(@RequestParam String entId){
        Map map=new HashMap();
        //员工信息
        map.put("employee",reportFileService.findReportFileByType("employee",entId));
        //分公司
        map.put("branchOffice",reportFileService.findReportFileByType("branchOffice",entId));
        //子公司
        map.put("subsidiaryCompany",reportFileService.findReportFileByType("subsidiaryCompany",entId));
        //供应商
        map.put("supplier",reportFileService.findReportFileByType("supplier",entId));
        //客户
        map.put("customer",reportFileService.findReportFileByType("customer",entId));
        //主要技术设备
        map.put("mainTechnicalEquipment",reportFileService.findReportFileByType("mainTechnicalEquipment",entId));
        //财务费用
        map.put("financialExpenses",reportFileService.findReportFileByType("financialExpenses",entId));
        //研发投入
        map.put("researchInput",reportFileService.findReportFileByType("researchInput",entId));
        //资产负债
        map.put("offBalanceSheet",reportFileService.findReportFileByType("offBalanceSheet",entId));
        //现金流量
        map.put("cashFlowStatement",reportFileService.findReportFileByType("cashFlowStatement",entId));
        //利润
        map.put("incomeStatement",reportFileService.findReportFileByType("incomeStatement",entId));
        return map;
    }
    /**
     * 下载填报材料
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/DownloadDateListFile",method = { RequestMethod.GET, RequestMethod.POST })
    public void downloadDataListFile(HttpServletResponse response,@RequestParam  String fileUrl,@RequestParam String fileName){
        /*response.setContentType("multipart/form-data");
        response.setHeader("Content-Disposition","fileName="+fileName);
        File file=new File(fileUrl);
        InputStream in= null;
        try {
            in = new FileInputStream(file);
            OutputStream out=response.getOutputStream();
            int b;
            while((b=in.read())!=-1){
                out.write(b);
            }
            in.close();
            out.close();
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        File file = new File(fileUrl);
        response.reset();
        response.setContentType("application/octet-stream");
        response.setContentLength((int) file.length());
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = 0;
            while ((i = bis.read(buff)) != -1) {
                os.write(buff, 0, i);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

}
