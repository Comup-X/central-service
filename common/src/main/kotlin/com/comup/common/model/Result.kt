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

    constructor() : this(500,"Default Error",Any())

    companion object {
        fun ok(data: String): Result {
            return Result(0, "SUCCESS", data)
        }

        fun error(message: String): Result {
            return Result(500, message, Any())
        }
    }

}