package com.example.project.domain.entity

import jakarta.persistence.*
import lombok.Data

@Entity
@Data
@Table(name = "dish_image")
data class DishImage(
  @Id
  @Column(name = "dish_image_id", updatable = false, nullable = false)
  val dishImageId: String,
  @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "dish_id") val dish: Dish,
  val dishImageKey: String
)
