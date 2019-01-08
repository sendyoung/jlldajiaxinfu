package jll.organization_creditInformation.service.impl.build;

import jll.model.org_organization.HostingJournal;
import jll.organization_creditInformation.dao.build.HostingJournalDao;
import jll.organization_creditInformation.service.build.HostingJournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 主办期刊
 */
@Service
@Transactional
public class HostingJournalServiceImpl implements HostingJournalService {

    @Autowired
    private HostingJournalDao hostingJournalDao;   // 主办期刊dao

    /**
     * 添加
     * @param hostingJournal
     */
    @Override
    public void addHostingJournal(List<HostingJournal> hostingJournal) {
        for (HostingJournal hj:hostingJournal){
            hostingJournalDao.addHostingJournal(hj);
        }

    }

    /**
     * 回显
     * @param auth_org_id
     */
    @Override
    public List queryHostingJournal(String auth_org_id) {

        List result = hostingJournalDao.queryHostingJournal(auth_org_id);
        if(null!=result && result.size()>0){
            return result;
        }
        return null;
    }
}
