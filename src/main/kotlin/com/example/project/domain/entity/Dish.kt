package com.example.project.domain.entity

import jakarta.persistence.*
import lombok.Data
import java.sql.Timestamp
import java.util.*

@Entity
@Data
@Table(name = "dish")
data class Dish(
  @Id
  @Column(name = "dish_id", updatable = false, nullable = false)
  val dishId: String = UUID.randomUUID().toString(),
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "user_id") val user: User,
  val dishName: String,
  val dishCreateRequiredTime: Int,
  val createTimestamp: Timestamp? = Timestamp(Date().time),
  val updateTimestamp: Timestamp? = Timestamp(Date().time),
  @ManyToMany
  @JoinTable(
    name = "dish_category",
    joinColumns = [JoinColumn(name = "dish_id")],
    inverseJoinColumns = [JoinColumn(name = "category_id")]
  )
  var categories: MutableSet<Category> = mutableSetOf()
)
