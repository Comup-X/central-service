package com.comup.image.service.repository

import com.comup.image.service.entity.FileInfo
import com.comup.image.service.entity.pk.FileInfoPK
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface FileRepository : PagingAndSortingRepository<FileInfo, FileInfoPK> {

}