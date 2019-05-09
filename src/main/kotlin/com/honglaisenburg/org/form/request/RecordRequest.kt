package com.honglaisenburg.org.form.request

import com.honglaisenburg.org.form.entity.Record

data class RecordRequest(val formId: Int)

fun RecordRequest.toRecord() = Record()
