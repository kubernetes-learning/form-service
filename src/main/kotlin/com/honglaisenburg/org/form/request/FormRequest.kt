package com.honglaisenburg.org.form.request

import com.honglaisenburg.org.form.entity.Field
import com.honglaisenburg.org.form.entity.Form
import com.honglaisenburg.org.form.model.FieldType

data class FormRequest(
        val name: String,
        val description: String? = null,
        val ownerUserId: Int,
        val fields: List<FieldRequest>? = null
)

data class FieldRequest(
        val name: String,
        val description: String,
        val type: FieldType
)

fun FormRequest.toForm() = Form(
        name = name,
        ownerUserId = ownerUserId,
        description = description,
        fields = fields?.map { it.toField() }
)

fun FieldRequest.toField() = Field(
        name = name,
        description = description,
        type = type
)