package jll.data_list.service.Impl;

import jll.data_list.dao.EmployeeDao;
import jll.data_list.dao.FamilyInfoDao;
import jll.data_list.dao.TrackRecordDao;
import jll.data_list.service.EmployeeService;
import jll.utils.DateUtils;
import jll.utils.ObjectIsNullUtils;
import jll.model.data_list.Employee;
import jll.model.data_list.FamilyInfo;
import jll.model.data_list.TrackRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;//员工信息

    @Autowired
    private FamilyInfoDao familyInfoDao;//家庭成员

    @Autowired
    private TrackRecordDao trackRecordDao;//履历

    @Override
    public void editEmployee(String entId, List<String[]> list) {
        for(String[] str:list){
            Employee emp=new Employee();
            if(str[11]!=null&&!str.equals("")){
                emp.setIdentity_card_no(str[11]);
            }else{
                continue;
            }
            emp.setEnt_id(entId);
            if(!str.equals("")){
                emp.setName(str[1]);
            }
            if(!str[2].equals("")) {
                emp.setGender(str[2].equals("男")?"2":"3");
            }
            emp.setNation(str[3]);
            if(!str[4].equals("")) {
                emp.setHeight(Float.valueOf(str[4]));
            }
            if(!str[5].equals("")) {
                emp.setWeight(Float.valueOf(str[5]));
            }
            emp.setBlood_type(str[6]);
            if(!str[7].equals("")) {
                emp.setBirth_date(DateUtils.StringToDate(new BigDecimal(str[7]).toPlainString()));
            }
            emp.setMarital_status(str[8]);
            emp.setSocial_group(str[9]);
            emp.setMarital_status(str[10]);
            emp.setRegistered_residence(str[12]);
            emp.setContact_tel(str[13]);
            emp.setEmail(str[14]);
            emp.setFamily_address(str[15]);
            emp.setContact_address(str[16]);
            if(!str[17].equals("")) {
                emp.setContact_name(str[17]);
            }
            if(!str[18].equals("")) {
                emp.setContact_phone(new BigDecimal(str[18]).toPlainString());
            }
            if(!str[19].equals("")) {
                emp.setEdu_background(str[19]);
            }
            if(!str[20].equals("")) {
                emp.setEdu_degree(str[20]);
            }
            if(!str[21].equals("")) {
                emp.setEdu_graduate_school(str[21]);
            }
            emp.setEdu_graduate_date(DateUtils.StringToDate(new BigDecimal(str[22]).toPlainString()));
            emp.setEdu_graduate_major(str[23]);
            emp.setLanguage_ability(str[24]);
            emp.setOther_language_ability(str[25]);
            emp.setComputer_ability(str[26]);
            emp.setOthers_certificate(str[27]);
            //部门
            emp.setDept_name(str[28]);
            emp.setDuty(str[29]);
            emp.setProfessional_title(str[30]);
            String stype=null;
            switch (str[31]) {
                case "普通员工":
                    stype="5";
                    break;
                case "中层管理者":
                    stype="6";
                    break;
                case "其他高层管理者":
                    stype="9";
                    break;
                case "技术负责人":
                    stype="7";
                    break;
                case "企业负责人":
                    stype="8";
                    break;
                default:
                    break;
            }
            if(stype!=null) {
                emp.setStype(stype);
            }
            emp.setSuperior(str[32]);
            //家庭成员
            List<FamilyInfo>familyList=new ArrayList<FamilyInfo>();
            FamilyInfo family1=new FamilyInfo();
            if(!str[33].equals("")) {
                family1.setRelation(str[33]);
            }
            if(!str[34].equals("")) {
                family1.setDuty(str[34]);
            }
            if(!str[35].equals("")) {
                family1.setPhone(new BigDecimal(str[35]).toPlainString());
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(family1)) {
                familyList.add(family1);
            }
            FamilyInfo family2=new FamilyInfo();
            if(!str[36].equals("")) {
                family2.setRelation(str[36]);
            }
            if(!str[37].equals("")) {
                family2.setDuty(str[37]);
            }
            if(!str[38].equals("")) {
                family2.setPhone(new BigDecimal(str[38]).toPlainString());
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(family2)) {
                familyList.add(family2);
            }
            FamilyInfo family3=new FamilyInfo();
            if(!str[39].equals("")) {
                family3.setRelation(str[39]);
            }
            if(!str[40].equals("")) {
                family3.setDuty(str[40]);
            }
            if(!str[41].equals("")) {
                family3.setPhone(new BigDecimal(str[41]).toPlainString());
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(family3)) {
                familyList.add(family3);
            }
            FamilyInfo family4=new FamilyInfo();
            if(!str[42].equals("")) {
                family4.setRelation(str[42]);
            }
            if(!str[43].equals("")) {
                family4.setDuty(str[43]);
            }
            if(!str[44].equals("")) {
                family4.setPhone(new BigDecimal(str[44]).toPlainString());
            }
            if(ObjectIsNullUtils.checkObjFieldIsNull(family4)) {
                familyList.add(family4);
            }
            //履历
            String record=str[45];
            List<TrackRecord> trList=new ArrayList<TrackRecord>();
            if(!str[45].equals("")) {
                trList=getRecord(record);
            }
            if(!str[46].equals("")) {
                emp.setWork_date(DateUtils.StringToDate(new BigDecimal(str[46]).toPlainString()));
            }
            if(!str[47].equals("")) {
                emp.setJoin_date(DateUtils.StringToDate(new BigDecimal(str[47]).toPlainString()));
            }
            if(!str[48].equals("")) {
                emp.setWork_industry_year(new BigDecimal(str[48]).intValue());
            }
            if(!str[49].equals("")) {
                emp.setPay_annual_salary(Float.valueOf(str[49]));
            }
            if(!str[50].equals("")) {
                emp.setPay_social_insurance(Float.valueOf(str[50]));
            }
            if(!str[51].equals("")) {
                emp.setPay_housing_fund(Float.valueOf(str[51]));
            }
            if(!str[52].equals("")) {
                emp.setPay_commerce_insurance(Float.valueOf(str[52]));
            }
            if(!str[53].equals("")) {
                emp.setPay_annuity(Float.valueOf(str[53]));
            }
            //判断该员工是否存在
            Employee el=employeeDao.queryEmployeeForNo(entId,emp.getIdentity_card_no());
            if(el!=null){
                emp.setEmployee_id(el.getEmployee_id());
            }
            String employee_id=employeeDao.saveEmployee(emp);
            familyInfoDao.deleteFamilyInfoByEmployeeId(employee_id);
            if(familyList!=null&&familyList.size()>0) {
                //添加家庭成员
                for(FamilyInfo fi:familyList){
                    fi.setEmployee_id(employee_id);
                    familyInfoDao.saveFamilyInfo(fi);
                }
            }
            trackRecordDao.deleteTrackRecordByEmployeeId(employee_id);
            if(trList!=null&&trList.size()>0){
                //添加履历
                for(TrackRecord tr:trList){
                    tr.setEmployee_id(employee_id);
                    trackRecordDao.saveTrackRecord(tr);
                }
            }

        }
    }
    //获取履历
    public List<TrackRecord> getRecord(String record){
        List<TrackRecord> emptrList=new ArrayList<TrackRecord>();
        if(record!=null&&!record.equals("")) {
            if(record.indexOf("/")>0) {
                String[] items=record.split("/");
                for(String item:items) {
                    //获取履历
                    TrackRecord emptr=analysisRecord(item);
                    emptrList.add(emptr);
                }
            }else {
                //获取履历
                TrackRecord emptr=analysisRecord(record);
                emptrList.add(emptr);
            }
        }
        return emptrList;
    }
    //解析履历
    public TrackRecord analysisRecord(String item) {
        TrackRecord emptr=new TrackRecord();
        String[] nodes=null;
        if(item.indexOf(",")>0) {
            nodes=item.split(",");
        }else {
            nodes=item.split("，");
        }
        if(nodes.length==4) {
            emptr.setTrack_record_id(null);
            String time=nodes[0];
            String[] dates=time.split("至");
            emptr.setStart_date(DateUtils.StringToDate(dates[0]));
            emptr.setEnd_date(DateUtils.StringToDate(dates[1]));
            emptr.setCompany(nodes[1]);
            emptr.setDuty(nodes[3]);
            emptr.setDept(nodes[2]);
        }
        return emptr;
    }
}
