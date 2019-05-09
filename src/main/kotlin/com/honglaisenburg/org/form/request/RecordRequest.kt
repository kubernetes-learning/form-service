package com.honglaisenburg.org.form.request

import com.honglaisenburg.org.form.entity.Record
import com.honglaisenburg.org.form.entity.RecordValue
import java.util.*

data class RecordRequest(
        val submitDate: Date,
        val values: Map<Int, String>,
        val submitUserId: Int

)

fun RecordRequest.toRecord(formId: Int) = Record(
        formId = formId,
        submitDate = submitDate,
        submitUserId = submitUserId,
        values = values.map { entry -> convertToRecordValue(entry) }
)

private fun convertToRecordValue(entry: Map.Entry<Int, String>): RecordValue {
    return RecordValue(
            fieldId = entry.key,
            value = entry.value
    )
}
