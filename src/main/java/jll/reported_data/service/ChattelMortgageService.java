package jll.reported_data.service;


import jll.model.BasicPnformationSubmit.ChattelMortgage;

import java.util.List;

public interface ChattelMortgageService {
    /**
     * 添加动产抵押信息
     */
    public void addChattelMortgage(List<ChattelMortgage> chattelMortgage);

    /**
     * 查询动产抵押信息
     */
    public List queryChattelMortgage(String entId);
}
