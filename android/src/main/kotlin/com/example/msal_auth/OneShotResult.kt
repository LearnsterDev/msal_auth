package com.example.msal_auth

import java.util.concurrent.atomic.AtomicBoolean
import io.flutter.plugin.common.MethodChannel

class OneShotResult(private val delegate: MethodChannel.Result) : MethodChannel.Result {
    private val done = AtomicBoolean(false)

    override fun success(result: Any?) {
        if (done.compareAndSet(false, true)) delegate.success(result)
    }

    override fun error(errorCode: String, errorMessage: String?, errorDetails: Any?) {
        if (done.compareAndSet(false, true)) delegate.error(errorCode, errorMessage, errorDetails)
    }

    override fun notImplemented() {
        if (done.compareAndSet(false, true)) delegate.notImplemented()
    }
}
