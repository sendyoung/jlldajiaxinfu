package jll.reported_data.service;

import jll.model.basic_pnformation_submit.ContactPersonnel;

import java.util.List;

public interface ContactStaffService {


    /**
     * 添加联系人员
     */
    public void addContactStaff(List<ContactPersonnel> contactPersonnel);

    /**
     * 查询联系人员
     */
    public List queryContactStaff(String entId);
}
