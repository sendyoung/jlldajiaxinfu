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
            return auditDetailsService.findBasicInformation(entId);
        }else if("goodInformation".equals(type)){
            return auditDetailsService.findGoodInformationForCount(entId);
        }else if("badInformation".equals(type)){
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
