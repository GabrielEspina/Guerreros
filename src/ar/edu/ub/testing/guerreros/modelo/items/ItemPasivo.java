package ar.edu.ub.testing.guerreros.modelo.items;

public abstract class ItemPasivo extends Item{
	
	public abstract void ejecutarAccionPasiva();
	public abstract void desactivarAccion();
	
	public int calcularAumento(float actual,float aumento) {
		float resultado = (actual * aumento)/100;
		return (int) Math.round(resultado);
	}

}
