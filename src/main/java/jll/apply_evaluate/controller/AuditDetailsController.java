package jll.apply_evaluate.controller;

import jll.apply_evaluate.service.AuditDetailsService;
import jll.data_list.service.CustomerService;
import jll.data_list.service.EmployeeService;
import jll.data_list.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 审核详情
 * */
@Controller
@Scope("prototype")
@RequestMapping("/AuditDetails")
public class AuditDetailsController {

    @Autowired
    private AuditDetailsService auditDetailsService;//基础信息
    @Autowired
    private EmployeeService employeeService;//员工信息
    @Autowired
    private CustomerService customerService;//销售客户
    @Autowired
    private SupplierService supplierService;//供应商

    /**
     * entId工商ID
     * type模块类型
     * page当前页数
     * rows每页条数
     * info详细内容
     * 查询审核模块信息
     * */
    @CrossOrigin(origins = "*", maxAge = 3600)
    @RequestMapping(value = "/findAuditDetails",method = { RequestMethod.GET, RequestMethod.POST })
    public @ResponseBody
    Object findAuditDetails(@RequestParam String entId,@RequestParam String type,@RequestParam(required = false) String info,@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer rows){
        if("basicInformation".equals(type)){
            Map map=new HashMap();
            if(info!=null&&!info.equals("")){
                return auditDetailsService.findBasicInformation(entId,info,page,rows);
            }
            map.put("entBasics",auditDetailsService.findBasicInformation(entId));
            map.put("administrativeLicense",auditDetailsService.findBasicInformation(entId,"administrativeLicense",page,rows));
            map.put("autoConstruction",auditDetailsService.findBasicInformation(entId,"autoConstruction",page,rows));
            map.put("bidding",auditDetailsService.findBasicInformation(entId,"bidding",page,rows));
            map.put("certification",auditDetailsService.findBasicInformation(entId,"certification",page,rows));
            map.put("changeInformation",auditDetailsService.findBasicInformation(entId,"changeInformation",page,rows));
            map.put("chattelMortgage",auditDetailsService.findBasicInformation(entId,"chattelMortgage",page,rows));
            map.put("contactStaff",auditDetailsService.findBasicInformation(entId,"contactStaff",page,rows));
            map.put("creativity",auditDetailsService.findBasicInformation(entId,"creativity",page,rows));
            map.put("creditEvaluation",auditDetailsService.findBasicInformation(entId,"creditEvaluation",page,rows));
            map.put("creditHistory",auditDetailsService.findBasicInformation(entId,"creditHistory",page,rows));
            map.put("customsCredit",auditDetailsService.findBasicInformation(entId,"customsCredit",page,rows));
            map.put("customsRegistration",auditDetailsService.findBasicInformation(entId,"customsRegistration",page,rows));
            map.put("debtfinancing",auditDetailsService.findBasicInformation(entId,"debtfinancing",page,rows));
            map.put("debtInvestment",auditDetailsService.findBasicInformation(entId,"debtInvestment",page,rows));
            map.put("environmentalCertification",auditDetailsService.findBasicInformation(entId,"environmentalCertification",page,rows));
            map.put("equityFinancing",auditDetailsService.findBasicInformation(entId,"equityFinancing",page,rows));
            map.put("equityInvestment",auditDetailsService.findBasicInformation(entId,"equityInvestment",page,rows));
            map.put("equityRegistration",auditDetailsService.findBasicInformation(entId,"equityRegistration",page,rows));
            map.put("externalGuarantee",auditDetailsService.findBasicInformation(entId,"externalGuarantee",page,rows));
            map.put("inPropertyRights",auditDetailsService.findBasicInformation(entId,"inPropertyRights",page,rows));
            map.put("patent",auditDetailsService.findBasicInformation(entId,"patent",page,rows));
            map.put("product",auditDetailsService.findBasicInformation(entId,"product",page,rows));
            map.put("publicNotice",auditDetailsService.findBasicInformation(entId,"publicNotice",page,rows));
            map.put("shareholdersInvestment",auditDetailsService.findBasicInformation(entId,"shareholdersInvestment",page,rows));
            map.put("socialSecurity",auditDetailsService.findBasicInformation(entId,"socialSecurity",page,rows));
            map.put("softwareCopyright",auditDetailsService.findBasicInformation(entId,"softwareCopyright",page,rows));
            map.put("spotCheck",auditDetailsService.findBasicInformation(entId,"spotCheck",page,rows));
            map.put("taxRating",auditDetailsService.findBasicInformation(entId,"taxRating",page,rows));
            map.put("theActualController",auditDetailsService.findBasicInformation(entId,"theActualController",page,rows));
            map.put("theProductionStatus",auditDetailsService.findBasicInformation(entId,"theProductionStatus",page,rows));
            map.put("trademark",auditDetailsService.findBasicInformation(entId,"trademark",page,rows));
            map.put("websiteFiling",auditDetailsService.findBasicInformation(entId,"websiteFiling",page,rows));
            map.put("workCopyright",auditDetailsService.findBasicInformation(entId,"workCopyright",page,rows));
            return map;
        }else if("goodInformation".equals(type)){
            if(info!=null&&!info.equals("")){
                return auditDetailsService.findGoodInformationForPage(entId,info,page,rows);
            }
            return auditDetailsService.findGoodInformationForCount(entId);
        }else if("badInformation".equals(type)){
            if(info!=null&&!info.equals("")){
                return auditDetailsService.findBadInformationForPage(entId,info,page,rows);
            }
            return auditDetailsService.findBadInformationForCount(entId);
        }else if("employeeInformation".equals(type)){
            Map map=new HashMap();
            if("otherTopManager".equals(info)){
                //其他高层管理者
                map.put("otherTopManager",employeeService.findEmployeeByOtherTopManager(entId,page,rows));
                return map;
            }else if("staffPerson".equals(info)){
                //普通员工
                map.put("staffPerson",employeeService.findEmployeeByStaffPerson(entId,page,rows));
                return map;
            }else if("enterprisePrincipal".equals(info)){
                //企业负责人
                map.put("enterprisePrincipal",employeeService.findEmployeeByEnterprisePrincipal(entId,page,rows));
                return map;
            }else if("technologyPrincipal".equals(info)){
                //技术负责人
                map.put("technologyPrincipal",employeeService.findEmployeeByTechnologyPrincipal(entId,page,rows));
                return map;
            }else if("middleManager".equals(info)){
                //中层管理者
                map.put("middleManager",employeeService.findEmployeeByMiddleManager(entId,page,rows));
                return map;
            }
            //其他高层管理者
            map.put("otherTopManager",employeeService.findEmployeeByOtherTopManager(entId,page,rows));
            //普通员工
            map.put("staffPerson",employeeService.findEmployeeByStaffPerson(entId,page,rows));
            //企业负责人
            map.put("enterprisePrincipal",employeeService.findEmployeeByEnterprisePrincipal(entId,page,rows));
            //技术负责人
            map.put("technologyPrincipal",employeeService.findEmployeeByTechnologyPrincipal(entId,page,rows));
            //中层管理者
            map.put("middleManager",employeeService.findEmployeeByMiddleManager(entId,page,rows));
            return map;

        }else if("financeInformation".equals(type)){
            return auditDetailsService.findFinanceInformation(entId);
        }else if("manageObjectInformation".equals(type)){
            return auditDetailsService.findManageObjectInformation(entId);
        }else if("counterpartyInformation".equals(type)){
            Map map=new HashMap();
            if("customer".equals(info)){
                map.put("customer",customerService.findCustomerByEntId(entId,page,rows));
                return map;
            }else if("supplier".equals(info)){
                map.put("supplier",supplierService.findSupplierByEntId(entId,page,rows));
                return map;
            }
            map.put("customer",customerService.findCustomerByEntId(entId,page,rows));
            map.put("supplier",supplierService.findSupplierByEntId(entId,page,rows));
            return map;
        }
        return "查无信息";
    }

}
