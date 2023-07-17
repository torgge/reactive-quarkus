package org.acme

import io.quarkus.hibernate.reactive.panache.common.WithSession
import io.quarkus.panache.common.Sort
import io.smallrye.mutiny.Uni
import jakarta.enterprise.context.ApplicationScoped
import jakarta.ws.rs.GET
import jakarta.ws.rs.Path
import jakarta.ws.rs.Produces
import jakarta.ws.rs.core.MediaType

@Path("/fruits")
@ApplicationScoped
@WithSession
class FruitResource(
    private var fruitRepository: FruitRepository,
) {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun getFruits(): Uni<MutableList<Fruit>>? = fruitRepository.listAll(Sort.by("id"))

    @GET
    @Path("/{id}")
    fun getFruit(id: Long): Uni<Fruit>? = fruitRepository.findById(id)
}
