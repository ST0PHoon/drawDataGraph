package kr.ac.kopo.ctc.kopo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo.domain.GuDongDanji;

@Repository
public interface GuDongDanjiRepository extends JpaRepository <GuDongDanji,String> {

	@Query("select distinct gu from GuDongDanji")
	List <String> findDistinctByGu();
	
	@Query("select distinct dong from GuDongDanji where gu = ?1")
	List <String> findDistinctByDong(String guName);
	
	@Query("select distinct dong from GuDongDanji")
	List <String> findAllDong();
	
	@Query("select distinct danji from GuDongDanji where dong = ?1")
	List <String> findDistinctByDanji(String dongName);
}
