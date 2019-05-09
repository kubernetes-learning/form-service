package com.honglaisenburg.org.form.entity

import com.honglaisenburg.org.form.model.RecordInfo
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "record")
data class Record(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int? = null,

        @Column(name = "form_id")
        val formId: Int,

        @Column(name = "submit_date")
        val submitDate: Date,

        @Column(name = "submit_user_id")
        val submitUserId: Int,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        @Fetch(FetchMode.SUBSELECT)
        @JoinColumn(name = "record_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        val values: List<RecordValue>
)

@Entity
@Table(name = "record_value")
data class RecordValue(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int? = null,

        @Column(name = "record_id")
        val recordId: Int? = null,

        @Column(name = "field_id")
        val fieldId: Int,

        @Column(name = "value")
        val value: String
)

fun Record.toRecordInfo() = RecordInfo(
        recordId = id,
        formId = formId,
        submitDate = submitDate,
        submitUserId = submitUserId,
        values = values.associateBy({ it.fieldId }, { it.value })
)
