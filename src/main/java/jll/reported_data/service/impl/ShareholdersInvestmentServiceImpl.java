package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.ShareholderContributionInfo;
import jll.reported_data.dao.ShareholdersInvestmentDao;
import jll.reported_data.service.ShareholdersInvestmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service()
@Transactional
public class ShareholdersInvestmentServiceImpl implements ShareholdersInvestmentService {

    //调用dao层
    @Autowired
    private ShareholdersInvestmentDao shareholdersInvestment;  //股东出资信息dao

    /**
     * 添加信息
     * @param shList
     */
    @Override
    public void addShareholdersInvestment(List<ShareholderContributionInfo> shList) {
        for(ShareholderContributionInfo sh:shList){
            shareholdersInvestment.addShareholdersInvestment(sh);
        }
    }

    /**
     * 查询信息
     * @param entId
     * @return
     */
    @Override
    public List queryShareholdersInvestment(String entId) {
        List result=shareholdersInvestment.queryShareholdersInvestment(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
