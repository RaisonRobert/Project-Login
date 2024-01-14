package com.example.projectlogin.util

import android.app.ProgressDialog
import android.content.Context

object Utils {
    private var progressDialog: ProgressDialog? = null
    fun showProgressDialog(context: Context, msg: String) {
        progressDialog = ProgressDialog(context)
        progressDialog?.setMessage(msg)
        progressDialog?.setCancelable(false)
        progressDialog?.show()
    }

    fun dismissProgressDialog() {
        progressDialog?.dismiss()
    }
}