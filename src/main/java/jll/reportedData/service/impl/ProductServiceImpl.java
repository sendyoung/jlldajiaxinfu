package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.ProductInformation;
import jll.reportedData.dao.ProductDao;
import jll.reportedData.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class ProductServiceImpl implements ProductService {
    //调用dao层
    @Autowired
    private ProductDao productDao;
    @Override
    public void addProduct(List<ProductInformation> productInformation) {
        for(ProductInformation sh:productInformation){
            productDao.addProduct(sh);
        }
    }

    @Override
    public List queryProduct(String entId) {
        List result=productDao.queryProduct(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
