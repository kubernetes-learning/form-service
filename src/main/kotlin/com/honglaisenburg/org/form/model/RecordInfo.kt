package com.honglaisenburg.org.form.model

import java.util.*

data class RecordInfo (
        val recordId: Int?,
        val formId: Int,
        val submitDate: Date,
        val submitUserId: Int,
        val values: Map<Int, String>? = null
)
