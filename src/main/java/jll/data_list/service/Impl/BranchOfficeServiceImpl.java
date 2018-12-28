package jll.data_list.service.Impl;

import jll.data_list.dao.BranchOfficeDao;
import jll.data_list.service.BranchOfficeService;
import jll.utils.DateUtils;
import jll.model.data_list.BranchOffice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service("branchOfficeService")
@Transactional
public class BranchOfficeServiceImpl implements BranchOfficeService {

    @Autowired
    private BranchOfficeDao branchOfficeDao;//分公司

    @Override
    public void editBranchOffice(String entId, List<String[]> list) {
        for(String[] str:list ) {
            BranchOffice bo=new BranchOffice();
            bo.setEnt_id(entId);
            if(!str[1].equals("")) {
                bo.setBranch_name(str[1]);
            }else {
                continue;
            }
            if(!str[3].equals("")) {
                String industry=str[3];
                //行业代码
                String industryCode=null;//entBaseIndustryMapper.findEntBaseIndustryByDescriptionForCode(industry);
                if(industryCode!=null) {
                    bo.setIndustry_code(industryCode);
                }
            }
            if(!str[5].equals("")) {
                //所属地区
                String region=null;//entBaseRegionMapper.findEntBaseRegionByFullName(str[5]);
                if(region!=null) {
                    bo.setRegin_code(region);
                }
            }
            if(!str[6].equals("")) {
                bo.setRegister_date(DateUtils.StringToDate(new BigDecimal(str[6]).toPlainString()));
            }
            if(!str[7].equals("")) {
                bo.setRepresentative(str[7]);
            }
            if(!str[8].equals("")) {
                //分公司营业收入
                bo.setTaking(Float.valueOf(str[8]));
            }
            if(!str[9].equals("")) {
                bo.setTaking_ratio(str[9]);
            }
            if(!str[10].equals("")) {
                bo.setNet_margin(Float.valueOf(str[10]));
            }
            if(!str[11].equals("")) {
                bo.setNet_margin_ratio(str[11]);
            }
            if(!str[12].equals("")) {
                bo.setClaff_sum(new BigDecimal(str[12]).intValue());
            }
            //判断分公司是否存在
            BranchOffice branchOffice=branchOfficeDao.queryBranchOfficeForName(entId,bo.getBranch_name());
            if(branchOffice!=null){
                bo.setBranch_office_id(branchOffice.getBranch_office_id());
            }
            branchOfficeDao.saveBranchOffice(bo);

        }
    }
}
