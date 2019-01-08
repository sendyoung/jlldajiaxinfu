package jll.reported_data.service.impl;

import jll.model.basic_pnformation_submit.ContactPersonnel;
import jll.reported_data.dao.ContactStaffDao;
import jll.reported_data.service.ContactStaffService;
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
