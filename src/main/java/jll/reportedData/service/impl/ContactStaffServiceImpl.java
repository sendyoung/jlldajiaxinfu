package jll.reportedData.service.impl;

import jll.model.BasicPnformationSubmit.ContactPersonnel;
import jll.reportedData.dao.ContactStaffDao;
import jll.reportedData.service.ContactStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service()
@Transactional
public class ContactStaffServiceImpl implements ContactStaffService {
    @Autowired
    private ContactStaffDao contactStaffDao;
    @Override
    public void addContactStaff(List<ContactPersonnel> contactPersonnel) {
        for(ContactPersonnel sh:contactPersonnel){
            contactStaffDao.addContactStaff(sh);
        }
    }

    @Override
    public List queryContactStaff(String entId) {
        List result=contactStaffDao.queryContactStaff(entId);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
