package jll.data_list.service;

import java.util.List;

public interface ResearchInputService {
    /**
     * 添加研发投入信息
     * */
    public void editResearchInput(String entId, List<String[]> list);
}
