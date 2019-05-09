package com.honglaisenburg.org.form.service

import com.honglaisenburg.org.form.entity.Form
import com.honglaisenburg.org.form.entity.Record
import com.honglaisenburg.org.form.entity.toFormInfo
import com.honglaisenburg.org.form.entity.toRecordInfo
import com.honglaisenburg.org.form.model.FormInfo
import com.honglaisenburg.org.form.model.RecordInfo
import com.honglaisenburg.org.form.repository.FormRepository
import com.honglaisenburg.org.form.repository.RecordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FormService(
        @Autowired val formRepository: FormRepository,
        @Autowired val recordRepository: RecordRepository
) {

    fun getFormById(id: Int): FormInfo? {
        return formRepository.findById(id).orElse(null)?.toFormInfo()
    }

    fun createForm(form: Form): FormInfo? {
        return formRepository.save(form).toFormInfo()
    }

    fun createRecord(record: Record): RecordInfo {
        return recordRepository.save(record).toRecordInfo()
    }

    fun getRecordsById(recordId: Int): Optional<RecordInfo> {
        return recordRepository.findById(recordId).map { it.toRecordInfo() }
    }

    fun getRecordsByFormId(formId: Int): List<RecordInfo> {
        return recordRepository.findByFormId(formId).map { it.toRecordInfo() }
    }
}
