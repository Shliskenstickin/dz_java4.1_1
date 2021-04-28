package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String company;

    public Smartphone(int id, String name, int price, String company) {
        super(id, name, price);
        this.company = company;
    }

    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        return company.equalsIgnoreCase(search);
    }
}
