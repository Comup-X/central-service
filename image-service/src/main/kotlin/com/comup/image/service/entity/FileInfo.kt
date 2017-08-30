package com.comup.image.service.entity

import com.comup.image.service.entity.pk.FileInfoPK
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
data class FileInfo(
        @EmbeddedId
        var fileInfoPK: FileInfoPK?,
        var uploadDate: LocalDateTime?
) : Serializable