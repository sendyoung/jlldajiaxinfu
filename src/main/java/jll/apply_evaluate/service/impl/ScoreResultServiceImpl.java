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

import java.util.Date;
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
    public void editScoreResult(String authOrgId,String applyEvaluateId, Double score) {
        //查询评分结果是否存在
        ScoreResult sr=scoreResultDao.queryScoreResultByApplyEvaluateId(applyEvaluateId);
        if(sr==null){
            sr=new ScoreResult();
            sr.setCreate_time(new Date());
            sr.setIsDelete("0");
        }
        /*if(scoreResult!=null){
            sr.setLevel(scoreResult.getLevel());
            sr.setApply_evaluate_id(scoreResult.getApply_evaluate_id());
            sr.setScore(scoreResult.getScore());
            sr.setScore_result_id(scoreResult.getScore_result_id());
            sr.setComment(scoreResult.getComment());
            sr.setCreate_time(scoreResult.getCreate_time());
            sr.setIsDelete(scoreResult.getIsDelete());
            sr.setUpdate_time(scoreResult.getUpdate_time());
        }*/
        sr.setUpdate_time(new Date());
        sr.setScore(score);
        sr.setApply_evaluate_id(applyEvaluateId);
        //计算评分等级
        String level=null;
        List list=rateRuleDao.queryRateRuleByAuthOrgId(authOrgId);
        if(list==null||list.size()==0){
            list=rateRuleDao.queryRateRuleByAuthOrgId("0");
        }
        for(int i=0;i<list.size();i++){
            RateRule rateRule=(RateRule)MapTrunPojo.map2Object((Map)list.get(i),RateRule.class);
            if(rateRule.getRank_code().equals("AAA")){
                if(score<=rateRule.getScore_top()&&score>=rateRule.getScore_bottom()){
                    level=rateRule.getRank_code();
                    break;
                }
            }/*else if(rateRule.getRank_code().equals("C")){
                if(score==0){
                    level=rateRule.getRank_code();
                    break;
                }
            }*/else{
                System.out.println("===================");
                System.out.println(rateRule.getRank_code());
                System.out.println(rateRule.getScore_top());
                System.out.println(rateRule.getScore_bottom());
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
