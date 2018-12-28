package jll.account_authentication.service.impl;

import jll.account_authentication.dao.IndustryDao;
import jll.account_authentication.service.IndustryService;
import jll.model.Industry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("industryService")
@Transactional
public class IndustryServiceImpl implements IndustryService {

    @Autowired
    private IndustryDao industryDao;//行业

    @Override
    public List<Industry> findIndustry() {
        List<Industry>ebiOneList=industryDao.queryIndustryByLength(1);
        List<Industry>ebiThreeList=industryDao.queryIndustryByLength(3);
        List<Industry> listAll=new ArrayList<Industry>();
        for(Industry ebiOne:ebiOneList) {
            List<Industry> list=new ArrayList<Industry>();
            for(Industry ebiThree:ebiThreeList) {
                if(ebiOne.getCode().equals(ebiThree.getCode().substring(0, 1))) {
                    Industry i=new Industry();
                    i.setCode(ebiThree.getCode());
                    i.setDescription(ebiThree.getDescription());
                    list.add(i);
                }
            }
            ebiOne.setIndustry(list);
            listAll.add(ebiOne);
        }
        return listAll;
    }
}
