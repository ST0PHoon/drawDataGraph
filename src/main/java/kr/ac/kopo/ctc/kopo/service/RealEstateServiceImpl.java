package kr.ac.kopo.ctc.kopo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo.domain.RealEstate;
import kr.ac.kopo.ctc.kopo.repository.RealEstateRepository;

@Service
public class RealEstateServiceImpl implements RealEstateService {
	
	@Autowired
	private RealEstateRepository realEstateRepository;
	
	@Override
	public List<RealEstate> findEx(String gu,String dong, String danji, double area, Integer year) {
		List <RealEstate> realEstates = realEstateRepository.findByGuAndDongAndDanjiAndAreaAndContractYear(gu,dong,danji,area,year);
		return realEstates;
	}

	@Override
	public RealEstate findMax(String gu, String dong,  String danji, double area, Integer year) {
		RealEstate Max = realEstateRepository.findFirstByGuAndDongAndDanjiAndAreaAndContractYearOrderByContractPriceDesc(gu,dong,danji,area,year);
		return Max;
	}

	@Override
	public RealEstate findMin(String gu, String dong, String danji, double area, Integer year) {
		RealEstate Min = realEstateRepository.findFirstByGuAndDongAndDanjiAndAreaAndContractYearOrderByContractPrice(gu,dong,danji,area,year);
		return Min;
	}

	@Override
	public List<RealEstate> findExLessGreater(HttpServletRequest httpServletRequest) {
		
		String gu = httpServletRequest.getParameter("gu");
		String dong = httpServletRequest.getParameter("dong");
		String danji = httpServletRequest.getParameter("danji");
		double startArea= Double.parseDouble(httpServletRequest.getParameter("startArea"));
		double endArea= Double.parseDouble(httpServletRequest.getParameter("endArea"));
		Integer startYear= Integer.parseInt(httpServletRequest.getParameter("startYear"));
		Integer endYear= Integer.parseInt(httpServletRequest.getParameter("endYear"));

		
		List <RealEstate> realEstates = realEstateRepository.findSearchData(gu, dong, danji, startYear, endYear);
		return realEstates;
	}

	@Override
	public List<String> guList() {
		List <String> guList = realEstateRepository.findDistinctByGu();
		return guList;
	}
	
	@Override
	public List<String> dongList(String guName) {
		List <String> dongList = realEstateRepository.findDistinctByDong(guName);
		return dongList;
	}

	@Override
	public List<String> danjiList(String dongName) {
		List <String> danjiList = realEstateRepository.findDistinctByDanji(dongName);
		return danjiList;
	}

	@Override
	public List<RealEstate> contractPriceMaxMin(HttpServletRequest httpServletRequest, Integer year) {
		
		String gu = httpServletRequest.getParameter("gu");
		String dong = httpServletRequest.getParameter("dong");
		String danji = httpServletRequest.getParameter("danji");
		

		
		List <RealEstate> contractPriceMaxMin = realEstateRepository.findMaxMinYearByDongDanjiYear(gu,dong, danji, year);
		return contractPriceMaxMin;
	}
	
	

//	@Override
//	public double findAvg(String gu, String dong, double area, Integer year) {
//		List <Integer> realEstates = realEstateRepository.findContractPriceByGuAndDongAndAreaAndContractYear(gu,dong,area,year);
//		double avg=0;
//		int sum=0;
//		for(int i=0;i<realEstates.size();i++) {
//			sum += realEstates.get(i);
//		}
//		avg=sum/realEstates.size();
//		
//		return avg;
//	}

}
