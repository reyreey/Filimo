package com.reyreey.filimo.Repository.Content;

import com.reyreey.filimo.Model.Content.ContentDetail;

public interface IContentDetailRepository extends IGenericRepository<ContentDetail> {
    boolean existsByTitle(String title);
    ContentDetail findByTitle(String title);
}
