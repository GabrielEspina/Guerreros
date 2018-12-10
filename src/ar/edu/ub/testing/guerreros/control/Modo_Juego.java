package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerreros.modelo.GuerreroEnemigo;

public enum Modo_Juego {
	UN_JUGADOR {
		@Override
		public EntidadesJuego generarEntidades(EntidadesJuego entidades) {
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[4]);
			FactoryGuerreros.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			entidades.setJugador(FactoryGuerreros.nuevoJugador(entidades));
			return entidades;
		}

		@Override
		public Integer key() {
			
			return 1;
		}

	},
	MULTI_COOP{
		@Override
		public EntidadesJuego generarEntidades(EntidadesJuego entidades) {
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[8]);
			FactoryGuerreros.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			entidades.setJugador(FactoryGuerreros.nuevoJugador(entidades));
			entidades.setJugador2(FactoryGuerreros.nuevoJugador(entidades));
			return entidades;
		}

		@Override
		public Integer key() {
			return 2;
		}

	};
	
	public abstract Integer key();
	public abstract EntidadesJuego generarEntidades(EntidadesJuego entidades);
}