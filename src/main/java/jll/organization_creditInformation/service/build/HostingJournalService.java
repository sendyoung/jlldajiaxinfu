package jll.organization_creditInformation.service.build;

import jll.model.org_organization.HostingJournal;

import java.util.List;

/**
 * 主办期刊
 */
public interface HostingJournalService {
    /**
     * 添加
     */
    public void addHostingJournal(List<HostingJournal> hostingJournal);


    /**
     * 查询
     */
    public List queryHostingJournal(String auth_org_id);
}
