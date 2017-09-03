package com.comup.file.service.entity.pk

import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
data class FileInfoPK(
        var scheme: String = "",
        var host: String = "",
        var port: Int = 0,
        var path: String = "",
        var fileName: String = ""
) : Serializable {
}