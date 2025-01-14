package com.reyreey.filimo.Service.Content;

import com.reyreey.filimo.Model.Content.ContentDetail;

public interface IContentDetailService extends ICrudService<ContentDetail> {
    Boolean isExists(String title);
}
