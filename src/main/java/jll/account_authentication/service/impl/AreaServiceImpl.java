package jll.account_authentication.service.impl;

import jll.account_authentication.dao.AreaDao;
import jll.account_authentication.service.AreaService;
import jll.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("areaService")
@Transactional
public class AreaServiceImpl implements AreaService {

    @Autowired
    private AreaDao areaDao;//地区

    @Override
    public List<Area> findArea() {
        List<Area>ebiOneList=areaDao.queryAreaForProvince();
        List<Area>ebiThreeList=areaDao.queryAreaForCity();
        List<Area> listAll=new ArrayList<Area>();
        for(Area ebiOne:ebiOneList) {
            List<Area> list=new ArrayList<Area>();
            for(Area ebiThree:ebiThreeList) {
                if(ebiOne.getCode().substring(0,2).equals(ebiThree.getCode().substring(0, 2))) {
                    Area i=new Area();
                    i.setCode(ebiThree.getCode());
                    i.setFull_name(ebiThree.getFull_name());
                    list.add(i);
                }
            }
            ebiOne.setArea(list);
            listAll.add(ebiOne);
        }
        return listAll;
    }
}
