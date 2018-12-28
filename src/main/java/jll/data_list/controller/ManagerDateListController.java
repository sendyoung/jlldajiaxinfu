package jll.data_list.controller;

import com.cn.zyzs.utils.base.BaseClass;
import jll.data_list.service.*;
import jll.utils.POIUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/ManagerDateList")
public class ManagerDateListController extends BaseClass {

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
     * type材料类型
     * multfile文件名
     * 填报材料审核上传
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/EditDateList",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object editDateList(@RequestParam String type,@RequestParam String entId,@RequestParam(name="multfile") MultipartFile multfile) throws IOException {
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
        }else if("offBalanceSheet".equals(type)){
            //资产负债

        }else if("cashFlowStatement".equals(type)){
            //现金流量

        }else if("incomeStatement".equals(type)){
            //利润

        }
        return "success";
    }
    /**
     * 根据类型查询所有企业上传的未审核的资料
     * type材料类型
     * page,rows
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/FindDateListFile",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody Object findDataListFile(@RequestParam(required = false) String type,@RequestParam(defaultValue = "1") Integer page,@RequestParam(defaultValue = "10") Integer rows){
        Map map=new HashMap();
        if(type==null||type.equals("")){
            map.put("dataList",reportFileService.findReportFileForAuditStatus(null,page,rows));
        }
        if("employee".equals(type)){
            //员工信息
            map.put("dataList",reportFileService.findReportFileForAuditStatus("employee",page,rows));
        }else if("branchOffice".equals(type)){
            //分公司
            map.put("dataList",reportFileService.findReportFileForAuditStatus("branchOffice",page,rows));
        }else if("subsidiaryCompany".equals(type)){
            //子公司
            map.put("dataList",reportFileService.findReportFileForAuditStatus("subsidiaryCompany",page,rows));
        }else if("supplier".equals(type)){
            //供应商
            map.put("supplier",reportFileService.findReportFileForAuditStatus("supplier",page,rows));
        }else if("customer".equals(type)){
            //客户
            map.put("dataList",reportFileService.findReportFileForAuditStatus("customer",page,rows));
        }else if("mainTechnicalEquipment".equals(type)){
            //主要技术设备
            map.put("dataList",reportFileService.findReportFileForAuditStatus("mainTechnicalEquipment",page,rows));
        }else if("financialExpenses".equals(type)){
            //财务费用
            map.put("dataList",reportFileService.findReportFileForAuditStatus("financialExpenses",page,rows));
        }else if("researchInput".equals(type)){
            //研发投入
            map.put("dataList",reportFileService.findReportFileForAuditStatus("researchInput",page,rows));
        }else if("offBalanceSheet".equals(type)){
            //资产负债
            map.put("dataList",reportFileService.findReportFileForAuditStatus("offBalanceSheet",page,rows));
        }else if("cashFlowStatement".equals(type)){
            //现金流量
            map.put("dataList",reportFileService.findReportFileForAuditStatus("cashFlowStatement",page,rows));
        }else if("incomeStatement".equals(type)){
            //利润
            map.put("dataList",reportFileService.findReportFileForAuditStatus("incomeStatement",page,rows));
        }
        return map;
    }
    /**
     * 下载填报材料
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/DownloadDateListFile",method = { RequestMethod.GET, RequestMethod.POST })
    public void downloadDataListFile(HttpServletResponse response,@RequestParam  String fileUrl,@RequestParam String fileName){
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
