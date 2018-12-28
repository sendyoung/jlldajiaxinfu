package jll.reportedData.service;

import jll.model.BasicPnformationSubmit.ContactPersonnel;

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
