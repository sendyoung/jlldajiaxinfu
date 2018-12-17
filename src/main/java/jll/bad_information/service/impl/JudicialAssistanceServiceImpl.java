package jll.bad_information.service.impl;

import jll.bad_information.dao.JudicialAssistanceDao;
import jll.bad_information.service.JudicialAssistanceService;
import jll.model.bad_information.JudicialAssistance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("judicialAssistanceService")
@Transactional
public class JudicialAssistanceServiceImpl implements JudicialAssistanceService {

    @Autowired
    private JudicialAssistanceDao judicialAssistanceDao;//欠税公告

    @Override
    public List getJudicialAssistance(String entId) {
        List result=judicialAssistanceDao.queryJudicialAssistance(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }

    @Override
    public void editJudicialAssistance(List<JudicialAssistance> jaList) {
        for(JudicialAssistance ja:jaList){
            judicialAssistanceDao.saveJudicialAssistance(ja);
        }
    }
}
