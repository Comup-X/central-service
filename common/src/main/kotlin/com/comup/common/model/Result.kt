package com.comup.common.model

data class Result(
        var code: Int,
        var message: String,
        var data: Any) {

    constructor() : this(-1, "Default Error", Any())

    companion object {
        fun ok(data: Any): Result {
            return Result(0, "SUCCESS", data)
        }

        fun error(message: String): Result {
            return Result(500, message, Any())
        }
    }

}