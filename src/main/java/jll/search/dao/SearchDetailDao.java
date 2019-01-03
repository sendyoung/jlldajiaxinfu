package jll.search.dao;

import com.cn.zyzs.hibernate.SimpleHibernateTemplate;
import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.hibernate.util.PageContext;
import jll.model.enterprise.EntBasics;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import java.util.List;

//详情
@Repository
public class SearchDetailDao extends SimpleHibernateTemplate<Object> {

    /**
     * 一.基础信用信息
     */
   //查询工商信息
    public List findEntBasicsByEntId(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ent_basics WHERE isDelete = '0' AND ent_id '" + entId + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.aliasToBean(EntBasics.class));
        return query.list();
    }

    //股东出资信息
    public Page findEntShareholderList(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ent_shareholder_contribution WHERE isDelete = '0' AND ent_id = '" + entId + "'");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    //查询疑似实际控制人
    public List findEntActual(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ent_actual_controller WHERE isDelete = '0' AND ent_id '" + entId + "'");
        Query query = this.getSession().createSQLQuery(sql.toString());
        query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        return query.list();
    }

    //变更记录
    public Page findEntChangeRecordList(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ent_change_record WHERE isDelete = '0' AND ent_id = '" + entId + "'");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    //员工信息
    public Page findEntEmployeeList(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ent_employee WHERE isDelete = '0' AND ent_id = '" + entId + "'");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    //分支机构-分公司
    public Page findEntBranchOffice(String entId){
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT * FROM ent_branch_office WHERE isDelete = '0' AND ent_id = '" + entId + "'");
        return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
    }

    //专利信息
     public Page findEntPatentInformation(String entId) {
         StringBuffer sql = new StringBuffer();
         sql.append("SELECT * FROM ent_patent_information WHERE isDelete = '0' AND ent_id = '" + entId + "'");
         return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
     }

    /**
     * 软件著作权      ent_software_copyright   多条数据
     * 作品著作权      ent_copyright_works      多条数据
     * 网站备案        ent_website_records      多条数据
     * 商标信息        ent_trademark			 多条数据
     * 主体信用评价    ent_subjectCredit_evaluation  多条数据
     */
/**
 * 二.社会信用信息
 * 行政许可        ent_administrative_licensing   多条数据
 * (不良)经营异常   ent_unusual_business_list     多条数据
 * (不良)行政处罚   ent_administrative_publishment多条数据
 * 抽查检查信息    ent_check                      多条数据
 * 纳税评级        ent_tax_rating                 多条数据
 * (不良)欠税公告   ent_contravention             多条数据
 * (不良)被执行人信息 ent_executor   多条数据
 * (不良)失信被执行人 ent_discredit_executor      多条数据
 * (不良)裁判文书     ent_adjudicative_document   多条数据
 * (不良)开庭公告   ent_court_session_notice
 * 公示催告        ent_service_by_publication     多条数据
 * (不良)司法协助  ent_judicial_assistance        多条数据
 * (不良)司法拍卖  ent_judicial_auction           多条数据
 * 环保体系认证    ent_system_certification
 * 环保处罚        ent_environment_punishment     多条数据
 * 社保方面        ent_social_security   涉及数据拼接
 * 海关注册信息    ent_customs_registration
 * 海关信用信息    ent_customs_credit
 * (不良)海关行政处罚  ent_administrative_sanction
 */
//行政许可
public Page findEntAdministrativeLicensing(String entId) {
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT * FROM ent_administrative_licensing WHERE isDelete = '0' AND ent_id = '" + entId + "'");
    return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
}


/**
 * 三经营信息
 * 资质认证        ent_aptitudes_authentication   多条数据
 * (良好)其他证书  ent_other_certificate          多条数据
 * 产品信息        ent_product             多条数据
 * 招投标信息      ent_Bidding             多条数据
 * 股权出质登记信息ent_share_pledge_registration多条数据
 * 动产抵押        ent_chattel_mortgage         多条数据
 * 知识产权出质信息ent_intellectual_property    多条数据
 * 对外担保信息    ent_external_guarantee
 */
//资质认证
public Page findEntAptitudesAuthentication(String entId) {
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT * FROM ent_aptitudes_authentication WHERE isDelete = '0' AND ent_id = '" + entId + "'");
    return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
}


/**
 * 四金融信用信息
 * 股权投资        ent_equity_investment       多条数据
 * 债权投资        ent_creditor_rights_investment 多条数据
 * 股权融资        ent_equity_financing
 * 债权融资        ent_bond_financing
 */
//股权投资
public Page findEntEquityInvestment(String entId) {
    StringBuffer sql = new StringBuffer();
    sql.append("SELECT * FROM ent_equity_investment WHERE isDelete = '0' AND ent_id = '" + entId + "'");
    return sqlqueryForpage1(sql.toString(), null, PageContext.getPageSize(), PageContext.getOffSet(), null);
}

/**
 * 五财务信息
 */

}
