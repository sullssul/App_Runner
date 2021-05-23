package ru.runner.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
public class Language {

    @Getter
    @Setter
    @Id
    private long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @Type(type = "text")
    private String version;

    @Getter
    @Setter
    @Type(type = "text")
    private String logo;

    @Override
    public String toString() {
        return name + " " + version;
    }
}
