package com.honglaisenburg.org.form.entity

import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "record")
data class Record (
        val id: Int? = null
)