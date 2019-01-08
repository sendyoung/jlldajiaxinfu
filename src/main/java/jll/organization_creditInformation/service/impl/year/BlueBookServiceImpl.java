package jll.organization_creditInformation.service.impl.year;

import jll.model.org_organization.BlueBook;
import jll.organization_creditInformation.dao.year.BlueBookDao;
import jll.organization_creditInformation.service.year.BlueBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 蓝皮书
 */
@Service
@Transactional
public class BlueBookServiceImpl implements BlueBookService {

    @Autowired
    private BlueBookDao blueBookDao; // 蓝皮书

    /**
     * 添加 蓝皮书
     */
    @Override
    public void addBlueBook(List<BlueBook> blueBook) {
        for (BlueBook bb : blueBook){
            blueBookDao.addBlueBook(bb);
        }
    }

    /**
     * 回显蓝皮书
     * @param auth_org_id
     */
    @Override
    public List queryBlueBook(String auth_org_id) {

        List result= blueBookDao.queryBlueBook(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
