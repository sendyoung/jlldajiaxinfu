package jll.data_list.service.Impl;

import jll.data_list.dao.ResearchInputDao;
import jll.data_list.service.ResearchInputService;
import jll.data_list.utils.ObjectIsNullUtils;
import jll.model.data_list.ResearchInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service("researchInputService")
@Transactional
public class ResearchInputServiceImpl implements ResearchInputService {

    @Autowired
    private ResearchInputDao researchInputDao;//研发投入

    @Override
    public void editResearchInput(String entId, List<String[]> list) {
        if(list.size()>=2) {
            String[]str=list.get(0);//获取年度
            String[]str1=list.get(1);//研发投入
            List<ResearchInput> riList=new ArrayList<ResearchInput>();
            ResearchInput ri1=new ResearchInput();
            ri1.setEnt_id(entId);
            if(!str1[1].equals("")) {
                ri1.setResearch_input(Float.valueOf(str1[1]));
            }
            if(!str[1].equals("")) {
                ri1.setPeriod(new BigDecimal(str[1]).intValue());
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(ri1)) {
                riList.add(ri1);
            }
            ResearchInput ri2=new ResearchInput();
            ri2.setEnt_id(entId);
            if(!str1[2].equals("")) {
                ri2.setResearch_input(Float.valueOf(str1[2]));
            }
            if(!str[2].equals("")) {
                ri2.setPeriod(new BigDecimal(str[2]).intValue());
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(ri2)) {
                riList.add(ri2);
            }
            ResearchInput ri3=new ResearchInput();
            ri3.setEnt_id(entId);
            if(!str1[3].equals("")) {
                ri3.setResearch_input(Float.valueOf(str1[3]));
            }
            if(!str[3].equals("")) {
                ri3.setPeriod(new BigDecimal(str[3]).intValue());
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(ri3)) {
                riList.add(ri3);
            }
            //添加研发投入
            for(ResearchInput ari:riList) {
                ResearchInput ri=researchInputDao.queryResearchInputForPeriod(entId,ari.getPeriod());
                if(ri!=null){
                    ari.setResearch_input_id(ri.getResearch_input_id());
                    researchInputDao.saveResearchInput(ari);
                }
            }
        }
    }
}
