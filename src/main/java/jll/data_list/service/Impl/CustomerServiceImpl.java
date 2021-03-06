package jll.data_list.service.Impl;

import com.cn.zyzs.hibernate.util.Page;
import com.cn.zyzs.utils.utils.PageContext;
import com.cn.zyzs.utils.utils.PageView;
import jll.data_list.dao.CustomerDao;
import jll.data_list.dao.CustomerTranstractionDao;
import jll.data_list.service.CustomerService;
import jll.utils.DateUtils;
import jll.utils.ObjectIsNullUtils;
import jll.model.data_list.Customer;
import jll.model.data_list.CustomerTranstraction;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;//客户

    @Autowired
    private CustomerTranstractionDao customerTranstractionDao;

    @Override
    public void editCustomer(String entId, List<String[]> list) {
        for(String[] str:list ) {
            Customer s=new Customer();
            s.setEnt_id(entId);
            s.setName(str[1]);
            if(!str[2].equals("")) {
                s.setRedit_no(str[2]);
            }else {
                continue;
            }
            s.setRepresentative(str[3]);
            if(!str[4].equals("")){
                s.setRegister_capital(Float.valueOf(str[4]));
            }
            if(!str[5].equals("")){
                s.setPaid_capital(Float.valueOf(str[5]));
            }
            if(!str[6].equals("")) {
                s.setPublish_date(DateUtils.StringToDate(new BigDecimal(str[6]).toPlainString()));
            }
            s.setStype(str[7]);
            if(!str[9].equals("")) {
                String industry=str[9];
                //行业代码
                String industryCode=null;//entBaseIndustryMapper.findEntBaseIndustryByDescriptionForCode(industry);
                if(industryCode!=null) {
                    s.setIndustry_code(industryCode);
                }
            }
            if(!str[10].equals("")) {
                s.setApprove_date(DateUtils.StringToDate(new BigDecimal(str[10]).toPlainString()));
            }
            s.setAdministration(str[11]);
            if(!str[12].equals("")) {
                s.setClaff_sum(new BigDecimal(str[12]).intValue());
            }
            s.setRegistered_address(str[13]);
            s.setBusiness_scope(str[14]);
            if(!str[15].equals("")) {
                s.setStart_date(DateUtils.StringToDate(new BigDecimal(str[15]).toPlainString()));
            }
            if(!str[16].equals("")) {
                s.setEnd_date(DateUtils.StringToDate(new BigDecimal(str[16]).toPlainString()));
            }
            //采购
            List<CustomerTranstraction> stList=new ArrayList<CustomerTranstraction>();
            CustomerTranstraction st1=new CustomerTranstraction();
            if(!str[17].equals("")) {
                st1.setCommodity(str[17]);
            }
            if(!str[18].equals("")) {
                st1.setQuantity(Float.valueOf(str[18]));
            }
            if(!str[19].equals("")) {
                st1.setUnit(str[19]);
            }
            if(!str[20].equals("")) {
                st1.setAverage_price(Float.valueOf(str[20]));
            }
            if(!str[21].equals("")) {
                st1.setAmount(Float.valueOf(str[21]));
            }
            if(!str[22].equals("")) {
                st1.setPayment_method(str[22]);
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(st1)) {
                st1.setPeriod(DateUtils.getYear(2));
                stList.add(st1);
            }
            CustomerTranstraction st2=new CustomerTranstraction();
            if(!str[23].equals("")) {
                st2.setCommodity(str[23]);
            }
            if(!str[24].equals("")) {
                st2.setQuantity(Float.valueOf(str[24]));
            }
            if(!str[25].equals("")) {
                st2.setUnit(str[25]);
            }
            if(!str[26].equals("")) {
                st2.setAverage_price(Float.valueOf(str[26]));
            }
            if(!str[27].equals("")) {
                st2.setAmount(Float.valueOf(str[27]));
            }
            if(!str[28].equals("")) {
                st2.setPayment_method(str[28]);
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(st2)) {
                st2.setPeriod(DateUtils.getYear(2));
                stList.add(st2);
            }
            CustomerTranstraction st3=new CustomerTranstraction();
            if(!str[29].equals("")) {
                st3.setCommodity(str[29]);
            }
            if(!str[30].equals("")) {
                st3.setQuantity(Float.valueOf(str[30]));
            }
            if(!str[31].equals("")) {
                st3.setUnit(str[31]);
            }
            if(!str[32].equals("")) {
                st3.setAverage_price(Float.valueOf(str[32]));
            }
            if(!str[33].equals("")) {
                st3.setAmount(Float.valueOf(str[33]));
            }
            if(!str[34].equals("")) {
                st3.setPayment_method(str[34]);
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(st3)) {
                st3.setPeriod(DateUtils.getYear(3));
                stList.add(st3);
            }
            Customer Customer=customerDao.queryCustomerForNo(entId, s.getRedit_no());
            if(Customer!=null){
                s.setCustomer_id(Customer.getCustomer_id());
            }
            String customer_id =customerDao.saveCustomer(s);
            customerTranstractionDao.deleteCustomerTranstractionByCustomerId(customer_id);
            if(stList!=null&&stList.size()>0){
                for(CustomerTranstraction st:stList){
                    //添加年度采购信息
                    st.setCustomer_id(customer_id);
                    customerTranstractionDao.saveCustomerTranstraction(st);
                }
            }

        }
    }

    @Override
    public Object findCustomerByEntId(String entId, Integer page, Integer rows) {
        try {
            Map param = new HashedMap();
            PageContext.setOffSet(page);
            PageContext.setPageSize(rows);
            Page pages=customerDao.queryCustomerByEntId(entId);
            PageView pageView = new PageView(PageContext.getPageSize(), PageContext.getOffSet());
            pageView.setTotalpage(pages.getTotal());
            pageView.setRecords(pages.getItems());
            return pageView;
        } catch (Exception e) {
            e.printStackTrace();
            return "500";
        }
    }
}
