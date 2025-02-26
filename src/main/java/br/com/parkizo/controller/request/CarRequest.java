package br.com.parkizo.controller.request;

import jakarta.validation.constraints.NotEmpty;

public record CarRequest(@NotEmpty(message = "License plate is required.") String licensePlate) {
}
