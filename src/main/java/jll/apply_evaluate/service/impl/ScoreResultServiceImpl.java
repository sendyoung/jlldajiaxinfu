package jll.apply_evaluate.service.impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.apply_evaluate.dao.RateRuleDao;
import jll.apply_evaluate.dao.ScoreResultDao;
import jll.apply_evaluate.service.ScoreResultService;
import jll.model.apply_evaluate.RateRule;
import jll.model.apply_evaluate.ScoreResult;
import jll.utils.MapTrunPojo;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("scoreResultService")
@Transactional
public class ScoreResultServiceImpl implements ScoreResultService {

    @Autowired
    private ScoreResultDao scoreResultDao;//评分结果

    @Autowired
    private RateRuleDao rateRuleDao;//评级规则

    @Override
    public void editScoreResult(String authOrgId,String applyEvaluateId, Float score) {
        //查询评分结果是否存在
        ScoreResult sr=scoreResultDao.queryScoreResultByApplyEvaluateId(applyEvaluateId);
        sr.setScore(score);
        sr.setApply_evaluate_id(applyEvaluateId);
        //计算评分等级
        String level=null;
        List list=rateRuleDao.queryRateRuleByAuthOrgId(authOrgId);
        for(int i=0;i<list.size();i++){
            RateRule rateRule=(RateRule)MapTrunPojo.map2Object((Map)list.get(i),RateRule.class);
            if(rateRule.getRank_code().equals("AAA")){
                if(score<=rateRule.getScore_top()&&score>=rateRule.getScore_bottom()){
                    level=rateRule.getRank_code();
                    break;
                }
            }else{
                if(score<rateRule.getScore_top()&&score>=rateRule.getScore_bottom()){
                    level=rateRule.getRank_code();
                    break;
                }
            }

        }
        sr.setLevel(level);
        //保存评分结果
        scoreResultDao.saveScoreResult(sr);
    }

    @Override
    public Object findScoreResultForCount(String authOrgId, String level) {
        return scoreResultDao.queryScoreResultForCount(authOrgId,level);
    }

    @Override
    public Object findScoreResultByLevel(String authOrgId, String level,Integer page,Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=scoreResultDao.queryScoreResultByLevel(authOrgId,level);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }
}
