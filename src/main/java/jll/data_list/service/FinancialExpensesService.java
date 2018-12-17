package jll.data_list.service;

import java.util.List;

public interface FinancialExpensesService {
    /**
     * 添加研发投入信息
     * */
    public void editFinancialExpenses(String entId, List<String[]> list);
}
