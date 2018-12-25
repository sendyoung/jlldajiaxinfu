package jll.reportedData.service;


import jll.model.BasicPnformationSubmit.ProductInformation;

import java.util.List;

public interface ProductService {
    /**
     * 添加产品信息
     */
    public void addProduct(List<ProductInformation> productInformation);

    /**
     * 查询产品信息
     */
    public List queryProduct(String entId);


}
