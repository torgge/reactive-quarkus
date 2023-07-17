package org.acme

import io.quarkus.hibernate.reactive.panache.PanacheEntity
import jakarta.persistence.Cacheable
import jakarta.persistence.Column
import jakarta.persistence.Entity

@Entity
@Cacheable
class Fruit() : PanacheEntity() {
    @Column(length = 40, unique = true)
    var name: String? = null

    constructor(name: String) : this() {
        this.name = name
    }
}
