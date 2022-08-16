package kr.ac.kopo.ctc.kopo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo.domain.RealEstate;

@Service
public interface RealEstateService {

	List<RealEstate> findEx(String gu,String dong, String danji, double area,Integer year);

	RealEstate findMax(String gu, String dong, String danji, double area,Integer year);
	
	RealEstate findMin(String gu, String dong,  String danji, double area,Integer year);
	
	List<RealEstate> findExLessGreater(HttpServletRequest httpServletRequest);
	
	List <String> guList();
	
	List <String> dongList(String guName);
	
	List <String> danjiList(String dongName);
	
	List <RealEstate> contractPriceMaxMin(HttpServletRequest httpServletRequest,Integer year);
	
//	double findAvg(String gu, String dong, double area, Integer year);

}
