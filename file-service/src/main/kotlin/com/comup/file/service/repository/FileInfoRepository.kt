package com.comup.file.service.repository

import com.comup.file.service.entity.FileInfo
import com.comup.file.service.entity.pk.FileInfoPK
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface FileInfoRepository : PagingAndSortingRepository<FileInfo, FileInfoPK> {

}