package com.comup.image.service.entity.pk

import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Embeddable

@Embeddable
data class FileInfoPK(
        var scheme:String?,
        var host:String?,
        var port:Int?,
        var path:String?,
        var fileName:String?
) :Serializable