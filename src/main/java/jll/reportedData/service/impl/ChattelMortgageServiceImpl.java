package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.ChattelMortgage;
import jll.reportedData.dao.ChattelMortgageDao;
import jll.reportedData.service.ChattelMortgageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class ChattelMortgageServiceImpl implements ChattelMortgageService {
    //调用dao层
    @Autowired
    private ChattelMortgageDao chattelMortgageDao;//动产抵押
    @Override
    public void addChattelMortgage(List<ChattelMortgage> chattelMortgage) {
        for(ChattelMortgage sh:chattelMortgage){
            chattelMortgageDao.addChattelMortgage(sh);
        }
    }

    @Override
    public List queryChattelMortgage(String entId) {
        List result=chattelMortgageDao.queryChattelMortgage(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
