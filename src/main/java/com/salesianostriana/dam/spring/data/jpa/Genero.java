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
public class Genero {

    @Id @GeneratedValue
    private Long id;
    private Long nombre;


    @Column(columnDefinition = "VARCHAR(512)")
    private Long id;

    private Long nombre;

    @ManyToMany(mappedBy = "Pelicula")
    private collection <Pelicula> Genero;
    public Collection<Pelicula> getGenero() {
        return Genero;
    }

    public void setGenero(Collection<Pelicula> Genero) {
        Genero = Genero;
    }
}

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Genero genero = (Genero) o;
        return getId() != null && Objects.equals(getId(), genero.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
