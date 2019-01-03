package jll.data_list.service;

import java.util.List;

public interface EmployeeService {
    /**
     * 添加员工信息
     * */
    public void editEmployee(String entId,List<String[]> list);
    /**
     * 根据员工类型查询员工信息
     * */
    public Object findEmployeeByOtherTopManager(String entId,Integer page,Integer rows);//其他高层管理者
    public Object findEmployeeByStaffPerson(String entId,Integer page,Integer rows);//普通员工
    public Object findEmployeeByEnterprisePrincipal(String entId,Integer page,Integer rows);//企业负责人
    public Object findEmployeeByTechnologyPrincipal(String entId,Integer page,Integer rows);//技术负责人
    public Object findEmployeeByMiddleManager(String entId,Integer page,Integer rows);//中层管理者
}
