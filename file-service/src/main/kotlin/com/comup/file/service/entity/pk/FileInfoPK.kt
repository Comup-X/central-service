package com.comup.file.service.entity.pk

import com.fasterxml.jackson.annotation.JsonInclude
import java.io.Serializable
import javax.persistence.Embeddable

@Embeddable
@com.fasterxml.jackson.annotation.JsonInclude(JsonInclude.Include.NON_EMPTY)
data class FileInfoPK(
        var scheme: String? = "",
        var host: String? = "",
        var port: Int? = 0,
        var path: String? = "",
        var fileName: String? = ""
) : Serializable {
}