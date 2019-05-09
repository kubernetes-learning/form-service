package com.honglaisenburg.org.form.controller

import com.honglaisenburg.org.form.model.FormInfo
import com.honglaisenburg.org.form.model.RecordInfo
import com.honglaisenburg.org.form.request.RecordRequest
import com.honglaisenburg.org.form.request.toRecord
import com.honglaisenburg.org.form.request.FormRequest
import com.honglaisenburg.org.form.request.toForm
import com.honglaisenburg.org.form.service.FormService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
class FormController(@Autowired private val formService: FormService) {

    @GetMapping("/{formId}")
    fun getForm(@PathVariable("formId") formId: Int): FormInfo? {
        return formService.getFormById(formId)
    }

    @PostMapping("/")
    fun createForm(@RequestBody request: FormRequest): FormInfo? {
        return formService.createForm(request.toForm())
    }

    @PostMapping("/{formId}/records")
    fun fillForm(@PathVariable("formId") formId: Int, @RequestBody request: RecordRequest): RecordInfo? {
        return formService.createRecord(formId, request.toRecord())
    }

    @GetMapping("/{formId}/records")
    fun getFormRecords(@PathVariable("formId") formId: Int): List<RecordInfo> {
        return formService.getRecordsByFormId(formId)
    }

    @GetMapping("/records/{recordId}")
    fun getOneRecord(@PathVariable("recordId") recordId: Int): Optional<RecordInfo> {
        return formService.getRecordsById(recordId)
    }

}