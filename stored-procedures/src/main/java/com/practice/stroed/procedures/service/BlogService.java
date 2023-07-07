package com.practice.stroed.procedures.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.stroed.procedures.repo.BlogRespository;

import jakarta.transaction.Transactional;

@Service 
public class BlogService {
	
	@Autowired
    BlogRespository  blogRespository;
	/**
	 * 
	 * @param id
	 * @return List<String>
	 */
    @Transactional
    public List<String> getTitileByIdEntiy(int id){
        return blogRespository.getTitileByIdEntiy(id);
    }
}
