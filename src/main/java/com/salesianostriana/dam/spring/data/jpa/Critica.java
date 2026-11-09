package com.salesianostriana.dam.spring.data.jpa;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Critica {

    @Id @GeneratedValue
    private Long id;
    private Long autor;
    private Long texto;
    private Long puntuacion;


    @Column(columnDefinition = "VARCHAR(512)")
    private Long id;

    private Long autor;

    private Long texto;

    private Long puntuacion;

    @ManyToOne
    @JoinColumn(name = "id_critica")
    private Pelicula pelicula;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Critica critica = (Critica) o;
        return getId() != null && Objects.equals(getId(), critica.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
