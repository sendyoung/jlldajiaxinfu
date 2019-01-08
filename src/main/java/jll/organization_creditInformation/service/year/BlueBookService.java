package jll.organization_creditInformation.service.year;

import jll.model.org_organization.BlueBook;

import java.util.List;

/**
 * 蓝皮书
 */
public interface BlueBookService {
    /**
     * 添加
     */
    public void addBlueBook(List<BlueBook> blueBook);

    /**
     * 回显
     */
    public List queryBlueBook(String auth_org_id);
}
