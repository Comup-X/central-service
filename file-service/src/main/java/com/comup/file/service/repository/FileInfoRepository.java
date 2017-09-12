package com.comup.file.service.repository;

import com.comup.file.service.entity.FileInfo;
import com.comup.file.service.entity.pk.FileInfoPK;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends JpaSpecificationExecutor<FileInfo>, CrudRepository<FileInfo, FileInfoPK> {
}
