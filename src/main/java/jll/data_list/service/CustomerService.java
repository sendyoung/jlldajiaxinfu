package jll.data_list.service;

import java.util.List;

public interface CustomerService {
    /**
     * 添加客户信息
     * */
    public void editCustomer(String entId, List<String[]> list);
    /**
     *  查询客户信息
     * */
    public Object findCustomerByEntId(String entId,Integer page,Integer rows);
}
