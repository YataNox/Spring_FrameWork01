package com.ezen.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dao.WordDao;
import com.ezen.word.dto.WordSet;

public class WordRegisterService {
	
	@Autowired
	private WordDao worddao;
	
	/*public WordRegisterService(WordDao wdao) {
		this.wdao = wdao;
	}*/
	
	public void register(WordSet wordset) {
		worddao.insert(wordset);
	}
}
