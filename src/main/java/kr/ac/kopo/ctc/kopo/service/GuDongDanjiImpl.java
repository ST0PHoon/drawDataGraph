package kr.ac.kopo.ctc.kopo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo.repository.GuDongDanjiRepository;

@Service
public class GuDongDanjiImpl implements GuDongDanjiService {
	
	@Autowired
	private GuDongDanjiRepository guDongDanjiRepository;
	
	@Override
	public List<String> guList() {
		
		List <String> guList = guDongDanjiRepository.findDistinctByGu();
		
		return guList;
	}

	@Override
	public List<String> dongList(String guName) {
		List <String> dongList = guDongDanjiRepository.findDistinctByDong(guName);
		return dongList;
	}

	@Override
	public List<String> allDongList() {
		List <String> allDongList = guDongDanjiRepository.findAllDong();
		return allDongList;
	}

	@Override
	public List<String> danjiList(String dongName) {
		List <String> danjiList = guDongDanjiRepository.findDistinctByDanji(dongName);		
		return danjiList;
	}
	
	
	
	
}
