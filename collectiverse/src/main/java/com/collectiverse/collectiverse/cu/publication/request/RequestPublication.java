package com.collectiverse.collectiverse.cu.publication.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.Valid;
import java.util.List;

/** Datos que envía el cliente en este caso de uso. */
public record RequestPublication(
        @NotNull(message = "El producto es obligatorio")
        Integer idProduct,
        @NotBlank(message = "El título es obligatorio")
        @Size(max = 100, message = "El título no puede pasar de 100 caracteres")
        String title,
        @Size(max = 255, message = "La descripción no puede pasar de 255 caracteres")
        String description,
        @NotBlank(message = "El tipo es obligatorio")
        @Size(max = 20, message = "El tipo no puede pasar de 20 caracteres")
        String type,
        @NotBlank(message = "El estado es obligatorio")
        @Size(max = 20, message = "El estado no puede pasar de 20 caracteres")
        String state,
        @Valid List<RequestPublicationExchange> exchanges) { // intercambios que se piden (opcional)

    /** Producto que el publicador pide a cambio. */
    public record RequestPublicationExchange(
            @NotBlank(message = "El nombre solicitado es obligatorio")
            @Size(max = 100, message = "El nombre solicitado no puede pasar de 100 caracteres")
            String requestedName,
            @Size(max = 255, message = "La descripción del intercambio no puede pasar de 255 caracteres")
            String description,
            @Min(value = 1, message = "La cantidad debe ser al menos 1")
            Integer quantity) {
    }
}
