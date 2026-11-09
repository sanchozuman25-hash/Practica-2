package com.salesianostriana.dam.spring.data.jpa;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Pelicula {

    @Id
    @GeneratedValue
    private Long id;
    private Long titulo;
    private Long anioEstreno;

    @OneToMany(mappedBy = "critica")
    @Builder.Default
    @ToString.Exclude
    private List<Critica> criticas = new ArrayList<>();

    public Pelicula addProducto(Critica p) {
        criticas.add(p);
        p.setPelicula(this);
        return this;
    }

    public Pelicula removeProducto(Critica p) {
        criticas.remove(p);
        p.setPelicula(null);
        return this;
    }


    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Pelicula pelicula = (Pelicula) o;
        return getId() != null && Objects.equals(getId(), pelicula.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }

    @ManyToMany(mappedBy = "Genero")
    private Collection<Genero> Pelicula;

    public Collection<Genero> getPelicula() {
        return Pelicula;
    }

    public void setPelicula(Collection<Genero> pelicula) {
        Pelicula = pelicula;
    }
}
