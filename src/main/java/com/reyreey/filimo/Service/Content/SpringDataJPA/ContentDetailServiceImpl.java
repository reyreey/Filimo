package com.reyreey.filimo.Service.Content.SpringDataJPA;

import com.reyreey.filimo.Model.Content.ContentDetail;
import com.reyreey.filimo.Repository.Content.IContentDetailRepository;
import com.reyreey.filimo.Service.Content.Exceptions.DataNotFoundException;
import com.reyreey.filimo.Service.Content.IContentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContentDetailServiceImpl implements IContentDetailService {
    @Autowired
    private IContentDetailRepository contentDetailRepository;

    @Override
    public List<ContentDetail> findAll() {
        return contentDetailRepository.findAll();
    }

    @Override
    public ContentDetail find(Long id) {
        var contentDetail = contentDetailRepository.findById(id);
        if(contentDetail.isEmpty()){
            throw new DataNotFoundException("ContentDetail not found");
        }
        return contentDetail.get();
    }

    @Override
    public Boolean isExists(String title) {
        return contentDetailRepository.existsByTitle(title);
    }

    @Override
    public ContentDetail insert(ContentDetail contentDetail) {
        return contentDetailRepository.save(contentDetail);
    }

    @Override
    public void change(ContentDetail contentDetail) {
        if(!contentDetailRepository.existsById(contentDetail.getId())){
            throw new DataNotFoundException("ContentDetail not found");
        }
        contentDetailRepository.save(contentDetail);
    }

    @Override
    public void remove(Long id) {
        if(!contentDetailRepository.existsById(id)){
            throw new DataNotFoundException("ContentDetail not found");
        }
        contentDetailRepository.deleteById(id);
    }

    @Override
    public List<ContentDetail> insertAll(List<ContentDetail> contentDetails) {
        return contentDetailRepository.saveAll(contentDetails);
    }
}
