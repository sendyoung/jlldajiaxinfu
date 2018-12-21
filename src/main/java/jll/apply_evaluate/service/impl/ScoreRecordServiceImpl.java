package jll.apply_evaluate.service.impl;

import jll.apply_evaluate.dao.ScoreRecordDao;
import jll.apply_evaluate.service.ScoreRecordService;
import jll.model.apply_evaluate.ScoreRecord;
import jll.utils.MapTrunPojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service("scoreRecordService")
@Transactional
public class ScoreRecordServiceImpl implements ScoreRecordService {

    @Autowired
    private ScoreRecordDao scoreRecordDao;//评分记录

    @Override
    public Float findScoreRecord(String applyEvaluateId) {
        Float score=0f;
        List list=scoreRecordDao.queryScoreRecordByApplyEvaluateId(applyEvaluateId);
        for(int i=0;i<list.size();i++){
            ScoreRecord sr=(ScoreRecord)MapTrunPojo.map2Object((Map)list.get(i),ScoreRecord.class);
            score+=sr.getScore();
        }
        return score;
    }
}
