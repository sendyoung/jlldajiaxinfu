package jll.bad_information.service;

import jll.model.bad_information.AdjudicativeDocument;

import java.util.List;

public interface AdjudicativeDocumentService {

    /**
     *获取裁判文书信息
     * */
    public List getAdjudicativeDocument(String entId);
    /**
     * 添加裁判文书信息
     * */
    public void editAdjudicativeDocument(List<AdjudicativeDocument> adList);

}
