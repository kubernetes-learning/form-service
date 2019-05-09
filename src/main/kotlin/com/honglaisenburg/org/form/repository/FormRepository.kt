package com.honglaisenburg.org.form.repository

import com.honglaisenburg.org.form.entity.Form
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FormRepository : JpaRepository<Form, Int>{
    override fun findById(id: Int): Optional<Form>
}
