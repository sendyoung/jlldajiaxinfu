package jll.reported_data.service;

import jll.model.basic_pnformation_submit.IntellectualProperty;

import java.util.List;

public interface InPropertyRightsService {
    /**
     * 添加知识产权出质
     */
    public void addInPropertyRights(List<IntellectualProperty> intellectualProperty);
    /**
     * 查询知识产权出质
     */
    public List queryInPropertyRights(String entId);
}
