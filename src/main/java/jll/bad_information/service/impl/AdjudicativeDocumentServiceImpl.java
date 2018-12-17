package jll.bad_information.service.impl;

import jll.bad_information.dao.AdjudicativeDocumentDao;
import jll.bad_information.service.AdjudicativeDocumentService;
import jll.model.bad_information.AdjudicativeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("adjudicativeDocumentService")
@Transactional
public class AdjudicativeDocumentServiceImpl implements AdjudicativeDocumentService {

    @Autowired
    private AdjudicativeDocumentDao adjudicativeDocumentDao;//裁判文书

    @Override
    public List getAdjudicativeDocument(String entId) {
        List result=adjudicativeDocumentDao.queryAdjudicativeDocument(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editAdjudicativeDocument(List<AdjudicativeDocument> adList) {
        for(AdjudicativeDocument ad:adList){
            adjudicativeDocumentDao.saveAdjudicativeDocument(ad);
        }
    }
}
