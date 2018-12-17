package jll.data_list.service.Impl;

import jll.data_list.dao.FinancialExpensesDao;
import jll.data_list.dao.ResearchInputDao;
import jll.data_list.service.FinancialExpensesService;
import jll.data_list.service.ResearchInputService;
import jll.data_list.utils.ObjectIsNullUtils;
import jll.model.data_list.FinancialExpenses;
import jll.model.data_list.ResearchInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("financialExpensesService")
@Transactional
public class FinancialExpensesServiceImpl implements FinancialExpensesService {

    @Autowired
    private FinancialExpensesDao financialExpensesDao;//财务费用

    @Override
    public void editFinancialExpenses(String entId, List<String[]> list) {
        if(list.size()>=4) {
            String[] str = list.get(0);//过去年度
            String[] str1 = list.get(1);//利息支出
            String[] str2 = list.get(2);//手续费
            String[] str3 = list.get(3);//其他
            List<FinancialExpenses> feList = new ArrayList<FinancialExpenses>();
            FinancialExpenses fe1 = new FinancialExpenses();
            fe1.setEnt_id(entId);
            if (!str1[1].equals("")) {
                fe1.setInterest_expense(Float.valueOf(str1[1]));
            }
            if (!str2[1].equals("")) {
                fe1.setService_charge(Float.valueOf(str2[1]));
            }
            if (!str3[1].equals("")) {
                fe1.setOther_charge(Float.valueOf(str3[1]));
            }
            if (!str[1].equals("")) {
                fe1.setPeriod(new BigDecimal(str[1]).intValue());
            }
            if (ObjectIsNullUtils.checkObjFieldIsNull(fe1)) {
                feList.add(fe1);
            }
            FinancialExpenses fe2 = new FinancialExpenses();
            fe2.setEnt_id(entId);
            if (!str1[2].equals("")) {
                fe2.setInterest_expense(Float.valueOf(str1[2]));
            }
            if (!str2[2].equals("")) {
                fe2.setService_charge(Float.valueOf(str2[2]));
            }
            if (!str3[2].equals("")) {
                fe2.setOther_charge(Float.valueOf(str3[2]));
            }
            if (!str[2].equals("")) {
                fe2.setPeriod(new BigDecimal(str[2]).intValue());
            }
            if (ObjectIsNullUtils.checkObjFieldIsNull(fe2)) {
                feList.add(fe2);
            }
            FinancialExpenses fe3 = new FinancialExpenses();
            fe3.setEnt_id(entId);
            if (!str1[3].equals("")) {
                fe3.setInterest_expense(Float.valueOf(str1[3]));
            }
            if (!str2[3].equals("")) {
                fe3.setService_charge(Float.valueOf(str2[3]));
            }
            if (!str3[3].equals("")) {
                fe3.setOther_charge(Float.valueOf(str3[3]));
            }
            if (!str[3].equals("")) {
                fe3.setPeriod(new BigDecimal(str[3]).intValue());
            }
            if (ObjectIsNullUtils.checkObjFieldIsNull(fe3)) {
                feList.add(fe3);
            }
            if (feList != null) {
                for (FinancialExpenses afe : feList) {
                    FinancialExpenses fe = financialExpensesDao.queryFinancialExpensesForPeriod(entId, afe.getPeriod());
                    if(fe!=null){
                        afe.setFinancial_expenses_id(fe.getFinancial_expenses_id());
                        financialExpensesDao.saveFinancialExpenses(afe);
                    }
                }
            }
        }
    }
}
