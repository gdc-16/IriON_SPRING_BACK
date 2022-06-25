package com.gdg.IriON.entity.animal;

import lombok.Getter;

@Getter
public enum AnimalType {
    DOG("DOG"), CAT("CAT");


    private final String type;

    AnimalType(String type) {
        this.type = type;
    }
}
