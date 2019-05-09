package com.honglaisenburg.org.form.service

import com.honglaisenburg.org.form.entity.Form
import com.honglaisenburg.org.form.entity.Record
import com.honglaisenburg.org.form.entity.toFormInfo
import com.honglaisenburg.org.form.model.FormInfo
import com.honglaisenburg.org.form.model.RecordInfo
import com.honglaisenburg.org.form.repository.FormRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FormService(@Autowired val formRepository: FormRepository) {

    fun getFormById(id: Int): FormInfo? {
        return formRepository.findById(id).orElse(null)?.toFormInfo()
    }

    fun createForm(form: Form): FormInfo? {
        return formRepository.save(form).toFormInfo()
    }


    fun createRecord(formId: Int, record: Record): RecordInfo? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getRecordsById(formId: Int): Optional<RecordInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun getRecordsByFormId(formId: Int): List<RecordInfo> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
