package com.comup.file.service.entity

import com.comup.file.service.entity.pk.FileInfoPK
import java.io.Serializable
import java.time.LocalDateTime
import java.util.*
import javax.persistence.EmbeddedId
import javax.persistence.Entity

@Entity
data class FileInfo(
        @EmbeddedId
        var fileInfoPK: FileInfoPK? = null,
        var uploadDate: Date? = null,
        var parentIdentifier: String? = null,
        var originalFilename: String? = null,
        var fileType: String? = null
) : Serializable