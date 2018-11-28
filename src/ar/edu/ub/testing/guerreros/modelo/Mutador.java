package ar.edu.ub.testing.guerreros.modelo;

public enum Mutador {
	
	MUTAR_ATAQUE{

		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setAtaque(guerrero.getAtributos().getAtaque() + 1);
		}
		
	},
	MUTAR_DEFENSA {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setDefensa(guerrero.getAtributos().getDefensa() + 1);
		}
	},
	MUTAR_PRESICION {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setPresicion(guerrero.getAtributos().getPresicion() + 1);
			
		}
	},
	MUTAR_VIDA {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setVida(guerrero.getAtributos().getVida() + 1);
			
		}
	},
	MUTAR_ENERGIA {
		@Override
		public void asignarPunto(Guerrero guerrero) {
			guerrero.getAtributos().setEnergia(guerrero.getAtributos().getEnergia() + 1);
			
		}
	};
	
	public abstract void asignarPunto(Guerrero guerrero);
}
