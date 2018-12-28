package jll.data_list.service.Impl;

import jll.data_list.dao.MainTechnicalEquipmentDao;
import jll.data_list.service.MainTechnicalEquipmentService;
import jll.utils.DateUtils;
import jll.model.data_list.MainTechnicalEquipment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service("mainTechnicalEquipmentService")
@Transactional
public class MainTechnicalEquipmentServiceImpl implements MainTechnicalEquipmentService {

    @Autowired
    private MainTechnicalEquipmentDao mainTechnicalEquipmentDao;//主要技术设备


    @Override
    public void editMainTechnicalEquipment(String entId, List<String[]> list) {
        for(String[] str:list ) {
            MainTechnicalEquipment amte = new MainTechnicalEquipment();
            amte.setEnt_id(entId);
            amte.setPeriod(DateUtils.getYear(1));
            if (!str[0].equals("")) {
                //主要技术设备
                amte.setName(str[0]);
            }
            if (!str[1].equals("")) {
                //数量（台）
                amte.setAmount(new BigDecimal(str[1]).intValue());
            }
            if (!str[2].equals("")) {
                //固定资产原价(元）
                amte.setOriginal_price(Float.valueOf(str[2]));
            }
            if (!str[3].equals("")) {
                //累计折旧（元）
                amte.setDepreciation(Float.valueOf(str[3]));
            }
            if (!str[4].equals("")) {
                //固定资产净值（元）
                amte.setValue(Float.valueOf(str[4]));
            }
            MainTechnicalEquipment mte=mainTechnicalEquipmentDao.queryMainTechnicalEquipmentForPeriod(entId,amte.getPeriod());
            if(mte!=null){
                amte.setMain_technical_equipment_id(mte.getMain_technical_equipment_id());
            }
            mainTechnicalEquipmentDao.saveMainTechnicalEquipment(amte);
        }
    }
}
