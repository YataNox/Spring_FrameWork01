package com.ezen.word.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.ezen.word.dao.WordDao;
import com.ezen.word.dto.WordSet;

public class WordSearchService {
	
	@Autowired
	private WordDao wdao;
	
	/*	public WordSearchService(WordDao wdao) { this.wdao = wdao; }	 */
	
	public WordSet searchWord(String kw) {
		WordSet ws = wdao.search(kw);
		return ws;
	}	
}
