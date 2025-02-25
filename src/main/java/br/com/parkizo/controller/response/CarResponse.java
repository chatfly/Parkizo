package br.com.parkizo.controller.response;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CarResponse(Long id,
                          String licensePlate,
                          LocalDateTime arrivalTime) {
}
