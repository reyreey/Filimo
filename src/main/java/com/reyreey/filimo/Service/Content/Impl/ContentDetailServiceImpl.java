package com.reyreey.filimo.Service.Content.Impl;

import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Repository.Content.ContentDetailRepository;
import com.reyreey.filimo.Service.Content.ContentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentDetailServiceImpl implements ContentDetailService {
    @Autowired
    private ContentDetailRepository contentDetailRepository;

    @Override
    public List<ContentDetail> findAll() {
        return contentDetailRepository.findAll();
    }

    @Override
    public ContentDetail find(Long id) {
        var contentDetail = contentDetailRepository.findById(id);
        if(contentDetail.isEmpty()){
            //TODO data not found exception
            throw new RuntimeException("ContentDetail not found");
        }
        return contentDetail.get();
    }

    @Override
    public Boolean isExists(String title) {
        return contentDetailRepository.existsByTitle(title);
    }

    @Override
    public void insert(ContentDetail contentDetail) {
        contentDetailRepository.save(contentDetail);
    }

    @Override
    public void change(ContentDetail contentDetail) {
        if(!contentDetailRepository.existsById(contentDetail.getId())){
            //TODO data not found exception
            throw new RuntimeException("ContentDetail not found");
        }
        contentDetailRepository.save(contentDetail);
    }

    @Override
    public void remove(Long id) {
        if(!contentDetailRepository.existsById(id)){
            //TODO data not found exception
            throw new RuntimeException("ContentDetail not found");
        }
        contentDetailRepository.deleteById(id);
    }
}
