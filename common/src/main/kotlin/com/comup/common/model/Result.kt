package com.comup.common.model

class Result(code: Int, message: String, data: Any) {
    private var code: Int = code
        get
        set
    private var message: String = message
        get
        set

    private var data: Any = data
        get
        set

    companion object {
        fun Ok(data: String): Result {
            return Result(0, "SUCCESS", data)
        }
    }
}