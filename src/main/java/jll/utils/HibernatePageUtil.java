package jll.utils;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import com.cn.zyzs.utils.utils.PageView;

public class HibernatePageUtil {
    public static PageView sqlPageUtil(Page pages, int currentPage, int rows){
        try {
            PageContext.setOffSet(currentPage);
            PageContext.setPageSize(rows);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
