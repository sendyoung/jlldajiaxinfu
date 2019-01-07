package jll.apply_evaluate.service.impl;

import jll.apply_evaluate.dao.ScoreDetailsDao;
import jll.apply_evaluate.service.ScoreDetailsService;
import jll.model.apply_evaluate.ScoreDetails;
import jll.model.apply_evaluate.ScoreRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service("scoreDetailsService")
@Transactional
public class ScoreDetailsServiceImpl implements ScoreDetailsService {

    @Autowired
    private ScoreDetailsDao scoreDetailsDao;//评分记录


    @Override
    public Double findScoreRule(List<ScoreRule> sdList, String applyEvaluateId) {
        Double score=0d;
        for(ScoreRule sr:sdList){
            //判断评分记录是否存在
            ScoreDetails sd=scoreDetailsDao.queryScoreDetailsForOne(applyEvaluateId,sr.getScore_rule_id());
            if(sd==null){
                sd=new ScoreDetails();
                sd.setCreate_time(new Date());
            }else{
                sd.setUpdate_time(new Date());
            }
            sd.setApply_evaluate_id(applyEvaluateId);
            sd.setScore_rule_id(sr.getScore_rule_id());
            if(sr.getScore()==null||sr.getScore().equals("")){
                sr.setScore(0d);
            }
            sd.setScore(Double.valueOf(sr.getScore()));
            scoreDetailsDao.saveScoreDetails(sd);
            score+=sd.getScore();
        }
        return score;
    }
}
