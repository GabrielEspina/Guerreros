package ar.edu.ub.testing.guerreros.modelo;

public enum Cruzador {
	CRUZA_1 {    // TOMA ATRIBUTOS OFENSIVOS DEL PADRE Y DEFENSIVOS DE LA MADRE
		@Override
		public GuerreroEnemigo cruzar(GuerreroEnemigo padre, GuerreroEnemigo madre, String nombre) {
			GuerreroEnemigo hijo = new GuerreroEnemigo();
			hijo.getAtributos().setNombre(nombre);
			hijo.getAtributos().setAtaque(padre.getAtributos().getAtaque());
			hijo.getAtributos().setPresicion(padre.getAtributos().getPresicion());
			hijo.getAtributos().setVida(madre.getAtributos().getVida());
			hijo.getAtributos().setEnergia(madre.getAtributos().getEnergia());
			hijo.getAtributos().setDefensa(madre.getAtributos().getDefensa());
			return hijo;
		}
	},
	CRUZA_2{     // TOMA ATRIBUTOS OFENSIVOS DE LA MADRE Y DEFENSIVOS DEL PADRE
		
		@Override
		public GuerreroEnemigo cruzar(GuerreroEnemigo padre, GuerreroEnemigo madre, String nombre) {
			GuerreroEnemigo hijo = new GuerreroEnemigo();
			hijo.getAtributos().setNombre(nombre);
			hijo.getAtributos().setAtaque(madre.getAtributos().getAtaque());
			hijo.getAtributos().setPresicion(madre.getAtributos().getPresicion());
			hijo.getAtributos().setVida(padre.getAtributos().getVida());
			hijo.getAtributos().setEnergia(padre.getAtributos().getEnergia());
			hijo.getAtributos().setDefensa(padre.getAtributos().getDefensa());
			return hijo;
		}
		
		
	},
	CRUZA_3{    //HACE UN PAN Y QUESO DE ATRIBUTOS DEL PADRE Y MADRE

		@Override
		public GuerreroEnemigo cruzar(GuerreroEnemigo padre, GuerreroEnemigo madre, String nombre) {
			GuerreroEnemigo hijo = new GuerreroEnemigo();
			hijo.getAtributos().setNombre(nombre);
			hijo.getAtributos().setAtaque(padre.getAtributos().getAtaque());
			hijo.getAtributos().setPresicion(madre.getAtributos().getPresicion());
			hijo.getAtributos().setVida(padre.getAtributos().getVida());
			hijo.getAtributos().setEnergia(madre.getAtributos().getEnergia());
			hijo.getAtributos().setDefensa(padre.getAtributos().getDefensa());
			return hijo;
		}
		
	},
	CRUZA_4{  //ALTERNATIVA DEL CRUZE 3

		@Override
		public GuerreroEnemigo cruzar(GuerreroEnemigo padre, GuerreroEnemigo madre, String nombre) {
			GuerreroEnemigo hijo = new GuerreroEnemigo();
			hijo.getAtributos().setNombre(nombre);
			hijo.getAtributos().setAtaque(madre.getAtributos().getAtaque());
			hijo.getAtributos().setPresicion(padre.getAtributos().getPresicion());
			hijo.getAtributos().setVida(madre.getAtributos().getVida());
			hijo.getAtributos().setEnergia(padre.getAtributos().getEnergia());
			hijo.getAtributos().setDefensa(madre.getAtributos().getDefensa());
			return hijo;
		}
		
	};
	
	public abstract GuerreroEnemigo cruzar(GuerreroEnemigo padre,GuerreroEnemigo madre,String nombre);

}
