package com.honglaisenburg.org.form.entity

import com.honglaisenburg.org.form.model.FieldInfo
import com.honglaisenburg.org.form.model.FieldType
import com.honglaisenburg.org.form.model.FormInfo
import org.hibernate.annotations.Fetch
import org.hibernate.annotations.FetchMode
import javax.persistence.*

@Entity
@Table(name = "form")
data class Form (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int? = null,

        @Column(name = "name")
        val name: String,

        @Column(name = "description")
        val description: String? = null,

        @Column(name = "owner_user_id")
        val ownerUserId: Int,

        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        @Fetch(FetchMode.SUBSELECT)
        @JoinColumn(name = "form_id", foreignKey = ForeignKey(ConstraintMode.NO_CONSTRAINT))
        val fields: List<Field>? = null
)

fun Form.toFormInfo() = FormInfo(
        id = id,
        name = name,
        description = description,
        ownerUserId = ownerUserId,
        fields = fields?.map { field -> field.toFieldInfo() }
)

@Entity
@Table(name = "form_field")
data class Field (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        val id: Int? = null,

        @Column(name = "form_id")
        val formId: Int? = null,

        @Column(name = "name")
        val name: String,

        @Column(name = "description")
        val description: String? = null,

        @Column(name = "type")
        @Enumerated(EnumType.STRING)
        val type: FieldType
)

fun Field.toFieldInfo() = FieldInfo(
        id = id,
        type = type,
        name = name,
        description = description
)

