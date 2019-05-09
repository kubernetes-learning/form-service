package com.honglaisenburg.org.form.repository

import com.honglaisenburg.org.form.entity.Record
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface RecordRepository : JpaRepository<Record, Int> {
    fun findByFormId(formId: Int): Iterable<Record>
}