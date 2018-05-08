package com.hub.web;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hub.entity.Nirmodel;
import com.hub.model.ImportModel;
import com.hub.service.NirDataService;
import com.hub.service.NirModelService;
import com.hub.service.impl.NirDataServiceImpl;
import com.hub.service.impl.NirModelServiceImpl;

import net.sf.json.JSONObject;

@Controller
public class NirDataController {

	@Autowired
	@Qualifier("NirDataServiceImpl")
	public NirDataService nirDataService;
	
	@Autowired
	@Qualifier("NirModelServiceImpl")
	public NirModelService nirModelService;
	
	
	@RequestMapping("linked")
	private void auditPage(Map<String, Object> map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		String parm = request.getParameter("parm");
		System.out.println("返回结果："+parm);
		JSONObject jo = new JSONObject();
		jo.put("parm", parm);
		response.getWriter().write(jo.toString());
	}
	
	@RequestMapping("testModel")
	private void testModel(Map<String, Object> map,HttpServletRequest request,HttpServletResponse response) throws Exception{
		try {
			Nirmodel useModel = ImportModel.useModel();
			nirModelService.insertNirModel(useModel);
			System.out.println("存储模型完成");
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().write("OK");
	}
	
}
