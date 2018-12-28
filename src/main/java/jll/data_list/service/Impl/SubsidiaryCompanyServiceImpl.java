package jll.data_list.service.Impl;

import jll.data_list.dao.SubsidiaryCompanyDao;
import jll.data_list.service.SubsidiaryCompanyService;
import jll.utils.DateUtils;
import jll.model.data_list.SubsidiaryCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service("subsidiaryCompanyService")
@Transactional
public class SubsidiaryCompanyServiceImpl implements SubsidiaryCompanyService {

    @Autowired
    private SubsidiaryCompanyDao subsidiaryCompanyDao;//分公司


    @Override
    public void editSubsidiaryCompany(String entId, List<String[]> list) {
        for(String[] str:list ) {
            SubsidiaryCompany sc=new SubsidiaryCompany();
            sc.setEnt_id(entId);
            if(!str[1].equals("")) {
                sc.setBranch_name(str[1]);
            }else {
                continue;
            }
            if(!str[3].equals("")) {
                String industry=str[3];
                //行业代码
                String industryCode=null;//entBaseIndustryMapper.findEntBaseIndustryByDescriptionForCode(industry);
                if(industryCode!=null) {
                    sc.setIndustry_code(industryCode);
                }
            }
            if(!str[5].equals("")) {
                //所属地区
                String region=null;//entBaseRegionMapper.findEntBaseRegionByFullName(str[5]);
                if(region!=null) {
                    sc.setRegin_code(region);
                }
            }
            if(!str[6].equals("")) {
                sc.setRegister_date(DateUtils.StringToDate(new BigDecimal(str[6]).toPlainString()));
            }
            if(!str[7].equals("")) {
                sc.setRepresentative(str[7]);
            }
            if(!str[8].equals("")) {
                sc.setShares(str[8]);
            }
            if(!str[9].equals("")) {
                //分公司营业收入
                sc.setTaking(Float.valueOf(str[9]));
            }
            if(!str[10].equals("")) {
                sc.setTaking_ratio(str[10]);
            }
            if(!str[11].equals("")) {
                sc.setNet_margin(Float.valueOf(str[11]));
            }
            if(!str[12].equals("")) {
                sc.setNet_margin_ratio(str[11]);
            }
            if(!str[13].equals("")) {
                sc.setClaff_sum(new BigDecimal(str[13]).intValue());
            }
            //判断分公司是否存在
            SubsidiaryCompany subsidiaryCompany=subsidiaryCompanyDao.querySubsidiaryCompanyForName(entId,sc.getBranch_name());
            if(subsidiaryCompany!=null){
                sc.setSubsidiary_company_id(subsidiaryCompany.getSubsidiary_company_id());
            }
            subsidiaryCompanyDao.saveSubsidiaryCompany(sc);

        }
    }
}
