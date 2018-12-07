package ar.edu.ub.testing.guerreros.modelo;

public enum Mutador {
	
	MUTAR_ATAQUE{

		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setAtaque(guerrero.getAtributos().getAtaque() + 1);
		}

		@Override
		public void asignarPuntos(Guerrero guerrero, int puntos) {
			guerrero.getAtributos().setAtaque(guerrero.getAtributos().getAtaque() + puntos);
			
		}
		
	},
	MUTAR_DEFENSA {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setDefensa(guerrero.getAtributos().getDefensa() + 1);
		}

		@Override
		public void asignarPuntos(Guerrero guerrero, int puntos) {
			guerrero.getAtributos().setDefensa(guerrero.getAtributos().getDefensa() + puntos);
			
		}
	},
	MUTAR_PRESICION {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setPresicion(guerrero.getAtributos().getPresicion() + 1);
			
		}

		@Override
		public void asignarPuntos(Guerrero guerrero, int puntos) {
			guerrero.getAtributos().setPresicion(guerrero.getAtributos().getPresicion() + puntos);
			
		}
	},
	MUTAR_VIDA {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setVida(guerrero.getAtributos().getVida() + 1);
			
		}

		@Override
		public void asignarPuntos(Guerrero guerrero, int puntos) {
			guerrero.getAtributos().setVida(guerrero.getAtributos().getVida() + puntos);
			
		}
	},
	MUTAR_ENERGIA {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setEnergia(guerrero.getAtributos().getEnergia() + 1);
			
		}

		@Override
		public void asignarPuntos(Guerrero guerrero, int puntos) {
			guerrero.getAtributos().setEnergia(guerrero.getAtributos().getEnergia() + puntos);
		}
	};
	
	public abstract void asignarPunto(Guerrero guerrero);
	public abstract void asignarPuntos(Guerrero guerrero, int puntos);
}
