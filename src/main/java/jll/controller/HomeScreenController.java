
/* 
 * 文 件 : zyzs_bi:com.cn.zyzs.bi.homescreen.controller C.java 
 * 版    权:  北京中烟追溯(北京)科技有限公司 版权所有 
 * 描    述:  <描述> 
 * 修 改 人:  @KeNan
 * 修改时间:  2018年4月19日 
 * 修改内容:  <修改内容> 
 * 版 本 号:  <1.0 升级为 1.1> 
 */

package jll.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * <一句话功能简述> 首页大屏展示层</br>
 * <功能详细描述> 进行数据接口提供</br>
 * 
 * @author @KeNan
 * @email 630758702@qq.com
 * @version [版本号, 2018年4月19日]
 * @see [相关类/方法]
 * @since [产品/模块版本]
 */
@Controller
@Scope("prototype")
@RequestMapping("/home")
public class HomeScreenController {


	@RequestMapping(value = "/getBarData")
	@ResponseBody
	public String getBarData(HttpServletRequest request, HttpServletResponse response) {

	    return "idea 搭建maven spring+spring+hibernate项目-json";
    }

    @RequestMapping(value = "/login")
    public ModelAndView main(final ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        ModelAndView models = new ModelAndView();
        models.setViewName("login");
        return models;
    }

}
