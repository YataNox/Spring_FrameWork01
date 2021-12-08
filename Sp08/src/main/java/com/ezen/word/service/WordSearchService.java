package com.ezen.word.service;

import com.ezen.word.dao.WordDao;
import com.ezen.word.dto.WordSet;

public class WordSearchService {
	private WordDao wdao;
	
	public WordSearchService(WordDao wdao) {
		this.wdao = wdao;
	}
	
	public WordSet register(String kw) {
		WordSet ws = wdao.search(kw);
		return ws;
	}	
}
