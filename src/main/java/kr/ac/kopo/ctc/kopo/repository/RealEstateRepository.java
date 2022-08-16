package kr.ac.kopo.ctc.kopo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo.domain.RealEstate;

@Repository
public interface RealEstateRepository extends JpaRepository <RealEstate,Long> {
	
	List <RealEstate>findByGu(String gu);

	List <RealEstate> findByGuAndDongAndDanjiAndAreaAndContractYear(String gu, String dong,String danji, double area,Integer Year);

	Long findFirstByGuAndDongAndDanjiOrderByContractPrice(String gu, String dong, double area);

	RealEstate findFirstByGuAndDongAndDanjiAndAreaAndContractYearOrderByContractPriceDesc(String gu, String dong, String danji , double area,Integer year);
	
	RealEstate findFirstByGuAndDongAndDanjiAndAreaAndContractYearOrderByContractPrice(String gu, String dong, String danji , double area,Integer year);
	
	List <RealEstate> findByGuAndDongAndDanjiAndAreaBetweenAndContractYearBetween(String gu, String dong, String danji, double startArea, double endArea, Integer startYear, Integer endYear);
		
	@Query("select distinct gu from RealEstate")
	List <String> findDistinctByGu();
	
	@Query("select distinct dong from RealEstate where gu = ?1")
	List <String> findDistinctByDong(String guName);

	@Query("select distinct danji from RealEstate where dong = ?1")
	List <String> findDistinctByDanji(String dongName);

	@Query("select Max(contractPrice) as max  , Min(contractPrice) as min , contractYear from RealEstate as a where gu= ?1 and dong = ?2 and danji = ?3 and contractYear = ?4")
	List <RealEstate> findMaxMinYearByDongDanjiYear(String guName, String dongName, String danjiName, Integer year);
	
	//이거 년도 사이에서 돌아가게 세팅부탁할게요 나갈준비해야함 ㅠㅜㅠㅜㅠㅜㅠㅜ 나머진 형 구굴 아이디 빌려서 원격으로 해야할듯???  
	@Query("select r from RealEstate r where gu= ?1 and dong = ?2 and danji = ?3 and contractYear >= ?4 and contractYear <= ?5")
	List <RealEstate> findSearchData(String guName, String dongName, String danjiName, Integer startYear, Integer endYear);
	

	
//	Integer findContractPriceFirstByGuAndDongAndAreaAndContractYearOrderByContractPriceDesc(String gu, String dong, double area,Integer year);
//
//	List<RealEstate> findByGuAndDongAndAreaAndContractYear(String gu, String dong, double area, Integer year);

//	List<Integer> findContractPriceByGuAndDongAndAreaAndContractYear(String gu, String dong, double area, Integer year);
}
