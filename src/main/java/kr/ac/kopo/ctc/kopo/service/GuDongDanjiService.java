package kr.ac.kopo.ctc.kopo.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface GuDongDanjiService {
	
	
	List <String> guList();
	
	List <String> dongList(String guName);
	
	List <String> allDongList();
	
	List <String> danjiList(String dongName);
}
