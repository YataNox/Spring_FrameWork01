package com.ezen.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dao.WordDao;
import com.ezen.word.dto.WordSet;

public class WordRegisterService {
	
	@Autowired
	private WordDao wdao;
	
	/*public WordRegisterService(WordDao wdao) {
		this.wdao = wdao;
	}*/
	
	public void register(WordSet wordset) {
		wdao.insert(wordset);
	}
}
