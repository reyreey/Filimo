package com.reyreey.filimo.Repository.Content;

import com.reyreey.filimo.Model.Content.ContentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IContentDetailRepository extends JpaRepository<ContentDetail,Long> {
    boolean existsByTitle(String title);
    ContentDetail findByTitle(String title);
}
