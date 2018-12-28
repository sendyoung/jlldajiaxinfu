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
        List<Area>areaOneList=areaDao.queryAreaForProvince();
        List<Area>areaThreeList=areaDao.queryAreaForCity();
        List<Area>areaList=areaDao.queryAreaForCounty();
        List<Area> listAll=new ArrayList<Area>();
        for(Area areaOne:areaOneList) {
            List<Area> list=new ArrayList<Area>();
            for(Area areaThree:areaThreeList) {
                List<Area> aList=new ArrayList<Area>();
                for(Area area:areaList){
                    if(area.getCode().substring(0,4).equals(areaThree.getCode().substring(0, 4))) {
                        Area i=new Area();
                        i.setCode(area.getCode());
                        i.setFull_name(area.getFull_name());
                        aList.add(i);
                    }
                }
                areaThree.setArea(aList);
                if(areaOne.getCode().substring(0,2).equals(areaThree.getCode().substring(0, 2))) {
                    Area i=new Area();
                    i.setCode(areaThree.getCode());
                    i.setFull_name(areaThree.getFull_name());
                    i.setArea(areaThree.getArea());
                    list.add(i);
                }
            }
            areaOne.setArea(list);
            listAll.add(areaOne);
        }
        return listAll;
    }
}
