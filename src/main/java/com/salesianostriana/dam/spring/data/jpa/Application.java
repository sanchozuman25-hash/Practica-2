package com.salesianostriana.dam.spring.data.jpa;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	CommandLineRunner init(PeliculaRepository peliculaRepository,
						   CriticaRepository criticaRepository, GeneroRepository generoRepository) {
		return args -> {

			Pelicula p = Pelicula.builder()
					.titulo(Long.valueOf("Ted 2"))
					.anioEstreno(Long.valueOf("2026"))
					.build();

			peliculaRepository.save(p);

			Critica c1 = Critica.builder()
					.texto(Long.valueOf("La pelicula me ha gustado pero ...."))
					.autor(Long.valueOf("Manuel Sancho"))
					.puntuacion(Long.valueOf("7.5/10"))
					.build();


			p.addProducto(c1);

			criticaRepository.save(c1);

			Genero g = Genero.builder()
					.nombre(Long.valueOf("Terror"))
					.build();
			g.addGenero(g1);

			Pelicula deBaseDeDatos = peliculaRepository.findById(1L)
					.orElse(null);

			Critica criticaDeBD = criticaRepository.findById(1L)
					.orElse(null);

			Genero generoDeBD = generoRepository.findById(1L)
					.orElse(null);

			System.out.println(criticaDeBD.getPelicula().getTitulo());

		};
	}



}
