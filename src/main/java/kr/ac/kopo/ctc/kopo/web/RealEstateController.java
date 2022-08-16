package kr.ac.kopo.ctc.kopo.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import kr.ac.kopo.ctc.kopo.domain.RealEstate;
import kr.ac.kopo.ctc.kopo.service.GuDongDanjiService;
import kr.ac.kopo.ctc.kopo.service.RealEstateService;

@Controller
public class RealEstateController {

	@Autowired
	private RealEstateService realEstateService;

	@Autowired
	private GuDongDanjiService guDongDanjiService;

	@RequestMapping(value = "/index")
	public String showAll(Model model) {

		ArrayList<String> guArr = (ArrayList<String>) guDongDanjiService.guList();
//	   model.addAttribute("guList",realEstateService.guList("서울특별시"));
		model.addAttribute("gus", guArr);

		ArrayList<String> dongArr = (ArrayList<String>) guDongDanjiService.allDongList();

		model.addAttribute("guSize", guArr.size());

		for (int i = 0; i < guArr.size(); i++) {
			model.addAttribute("gu" + i, guDongDanjiService.dongList(guArr.get(i).toString()));
		}

		for (int i = 0; i < dongArr.size(); i++) {
			model.addAttribute("dong" + i, guDongDanjiService.danjiList(dongArr.get(i).toString()));
		}

		System.out.println(1);

		return "index";
	}

	@RequestMapping(value = "/index3")
	public String showEX(Model model, HttpServletRequest httpServletRequest) {

		model.addAttribute("all", realEstateService.findExLessGreater(httpServletRequest));

		Integer startYear = Integer.parseInt(httpServletRequest.getParameter("startYear"));
		Integer endYear = Integer.parseInt(httpServletRequest.getParameter("endYear"));

		
		 ArrayList <List> contractPriceMaxMinByYearList = new ArrayList<>();
		 
		 for (int i = startYear; i <= endYear; i++) {
			 contractPriceMaxMinByYearList.add(realEstateService.contractPriceMaxMin(httpServletRequest, i)); 
		 }
		 
		  model.addAttribute("contractPriceMaxMin",contractPriceMaxMinByYearList);
//		  
		 
//	  model.addAttribute("max",realEstateService.findMax(gu,dong,danji,area,year)); 
//	  model.addAttribute("min",realEstateService.findMin(gu,dong,danji,area,year)); 
		model.addAttribute("gus", realEstateService.guList());

		return "index3";
	}

//   @GetMapping("/export")
//   public void exportToCSV(HttpServletResponse response) throws IOException {
//       response.setContentType("text/csv");
//       DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//       String currentDateTime = dateFormatter.format(new Date());
//        
//       String headerKey = "Content-Disposition";
//       String headerValue = "attachment; filename=realData_" + currentDateTime + ".csv";
//       response.setHeader(headerKey, headerValue);
//        
//       List<RealEstate> listRealEstates = realEstateService.;
//
//       ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
//       String[] csvHeader = {"id", "city", "gu", "dong", "danji", "area", "contractYear", "contractMonth", "contractDay", "contractPrice", "floor", "constYear"};
//       String[] nameMapping = {"id", "city", "gu", "dong", "danji", "area", "contractYear", "contractMonth", "contractDay", "contractPrice", "floor", "constYear"};
//        
//       csvWriter.writeHeader(csvHeader);
//        
//       for (RealEstate realEstate : listRealEstates) {
//           csvWriter.write(realEstate, nameMapping);
//       }
//        
//       csvWriter.close();
//        
//   }

}