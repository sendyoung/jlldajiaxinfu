package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.TaxRating;
import jll.reportedData.dao.TaxRatingDao;
import jll.reportedData.service.TaxRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class TaxRatingServiceImpl implements TaxRatingService {
    //调用dao层
    @Autowired
    private TaxRatingDao taxRatingDao;
    @Override
    public void addTaxRating(List<TaxRating> taxRating) {
        for(TaxRating sh:taxRating){
            taxRatingDao.addTaxRating(sh);
        }
    }

    @Override
    public List queryTaxRating(String entId) {
        List result=taxRatingDao.queryTaxRating(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
