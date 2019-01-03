package jll.data_list.service;

import java.util.List;

public interface SupplierService {
    /**
     * 添加供应商信息
     * */
    public void editSupplier(String entId, List<String[]> list);
    /**
     * 查询供应商信息
     * */
    public Object findSupplierByEntId(String entId,Integer page,Integer rows);
}
