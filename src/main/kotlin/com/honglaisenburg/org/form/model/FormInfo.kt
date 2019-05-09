package com.honglaisenburg.org.form.model

data class FormInfo(
        val id: Int? = null,
        val name: String,
        val description: String? = null,
        val ownerUserId: Int,
        val fields: List<FieldInfo>? = null
)

data class FieldInfo(
        val id: Int? = null,
        val type: FieldType,
        val name: String,
        val description: String? = null
)