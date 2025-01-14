package com.reyreey.filimo.Repository.Content;


import com.reyreey.filimo.Model.Content.MediaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMediaItemRepository extends JpaRepository<MediaItem,Long> {
}
