package com.felipe.api_dragon_city_h2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Table(name = "dragoes")
@Getter
@Setter
public class DragonModel {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
    /*
     utilizei o tipo UUID e o gerador UuidGenerator.Style.RANDOM pois das outras formas é gerado ID sequencial
     (falha de segurança) e os valores são gerados antes do objeto existir, causando gargalo na API.
    */
    private UUID id;
    @NotBlank(message = "O campo NOME não pode ficar vazio.")
    private String nome;
    @NotBlank(message = "O campo TIPO não pode ficar vazio.")
    private String tipo;

    @Override
    public String toString() {
        return "ID: " + id + "\nNome: " + nome + "\nTipo: " + tipo + "\n";
    }
}
