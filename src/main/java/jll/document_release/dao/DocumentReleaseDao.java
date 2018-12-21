package jll.document_release.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import jll.model.document_release.DocumentRelease;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DocumentReleaseDao extends SimpleHibernateTemplate<DocumentRelease> {

    /**
     *新的公文(状态:0草稿 1已发布 2撤回)
     */
    public void addNewDocument(DocumentRelease documentRelease){
        this.getSession().save(documentRelease);
    }

    /**
     * 查询历史公文列表
     */
    public Page findDocumentList(String authOrgId){
        StringBuffer sql = new StringBuffer();
        sql.append(" SELECT documentRelease.document_id,documentRelease.create_time,documentRelease.document_title,documentRelease.document_status FROM org_document_release documentRelease WHERE 1=1 AND documentRelease.isDelete = '0' ");
        sql.append(" AND documentRelease.auth_org_id = '" +authOrgId + "' ");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    /**
     *查看公文详情
     */
    public List findDocument(String documentId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT documentRelease.* FROM org_document_release documentRelease WHERE 1=1 AND isDelete = '0' ");
        sql.append(" AND document_id = '" + documentId + "' ");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    /**
     * 快捷发布
     * 撤回公文
     */
    public int updateDocumentStatus(String documentStatus,String documentId){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_document_release SET document_status = ? WHERE document_id = ?");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setParameter(0,documentStatus);
        query.setParameter(1,documentId);
        return query.executeUpdate();
    }

    /**
     *修改公文
     */
    public int updateDocumentRelease(DocumentRelease documentRelease){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_documetn_release SET    ");
        if (!"".equals(documentRelease.getDocument_title()) && null != documentRelease.getDocument_title()) {
            sql.append("document_title = '"+ documentRelease.getDocument_title() + "',");
        }
        if (!"".equals(documentRelease.getDocument_content()) && null != documentRelease.getDocument_content()) {
            sql.append("document_content = '"+ documentRelease.getDocument_content() + "',");
        }
        if (!"".equals(documentRelease.getDocument_status()) && null != documentRelease.getDocument_status()) {
            sql.append("document_status = '"+ documentRelease.getDocument_status() + "',");
        }
        if (!"".equals(documentRelease.getCreate_time()) && null != documentRelease.getCreate_time()) {
            sql.append("create_time = '"+ documentRelease.getCreate_time() + "',");
        }
        sql.replace(sql.length() - 1, sql.length(), "");
        sql.append(" WHERE document_id = '" + documentRelease.getDocument_id() +"' ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        return query.executeUpdate();

    }




  /*  public List findUserByUserName(String username){
        StringBuffer sql = new StringBuffer();
        sql.append(" select where 1=1 and isDelete='0'  ");

        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }*/

    //更新数据库用户密码
    /*public int updateUser(User user){
        StringBuffer sql = new StringBuffer();
        sql.append("UPDATE org_user_account SET password = ? WHERE username = ?");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setParameter(1,user.getUsername());
        query.setParameter(0,user.getPassword());
        return query.executeUpdate();
    }*/
}
