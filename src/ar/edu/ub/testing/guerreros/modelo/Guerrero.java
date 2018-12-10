package ar.edu.ub.testing.guerreros.modelo;


import java.util.ArrayList;
import java.util.Random;
import ar.edu.ub.testing.guerreros.modelo.items.ItemActivo;
import ar.edu.ub.testing.guerreros.modelo.items.ItemPasivo;
import ar.edu.ub.testing.guerreros.modelo.habilidades.HabilidadActiva;
import ar.edu.ub.testing.guerreros.modelo.habilidades.HabilidadPasiva;
import ar.edu.ub.testing.guerreros.modelo.habilidades.IHabilidad;
import ar.edu.ub.testing.guerreros.modelo.items.Item;



public abstract class Guerrero {
	
	static Random  rand = new Random();
	private Atributos atributos;
	private Cuerpo    cuerpo;
	private Item[]    items;
	private IHabilidad habilidad;
	private boolean    denfendiendo = false;
	private boolean    chanceParalizar = false;
	private boolean    chanceDobleDaño = false;
	private boolean    chanceEvadir = false;
	private boolean turnoPausado;
	private int contTurnosPausados;
	private boolean heridaSangrante;
	private int contHeridaSangrante;
	private boolean     fallaAtaque;
	
	public Guerrero(){
		this.atributos = new Atributos();
		this.cuerpo = new Cuerpo();
		this.setItems(new Item[2]);
	}

	public void dañar(int daño) {
		if (daño > 0) {
			this.getAtributos().setVida(this.getAtributos().getVida() - daño);
		}
	}
	public Atributos getAtributos() {
		return atributos;
	}
	public Cuerpo getCuerpo() {
		return cuerpo;
	}
	
	public void printAtributos() {
		System.out.println("-------------------------------");
		System.out.println(this.getAtributos().getNombre());
		System.out.println("-------------------------------");
		System.out.println("Atauqe = " + this.getAtributos().getAtaque());
		System.out.println("Defensa = " + this.getAtributos().getDefensa());
		System.out.println("Energia = " + this.getAtributos().getEnergia());
		System.out.println("Precision = " + this.getAtributos().getPresicion());
		System.out.println("Vida = "  + this.getAtributos().getVida());
	}
	
	//PARA RAPIDA CONSTRUCCION EN CASOS DE PRUEBA
	public void setAtributosSimple(int ataque,int defensa,int energia,int presicion, int vida) {
		
		this.getAtributos().setAtaque(ataque);
		this.getAtributos().setDefensa(defensa);
		this.getAtributos().setEnergia(energia);
		this.getAtributos().setPresicion(presicion);
		this.getAtributos().setVida(vida);
	}
	
	
	public boolean murio() {
		if (this.getAtributos().getVida() <= 0) {
			this.getCuerpo().setCuerpoMuerto();
			this.getAtributos().setVida(0);
			return true;
		}else{
			this.cuerpo = new Cuerpo();
			return false;
		}
	}
	public String atacar(Guerrero enemigo) {
		if(!enemigo.murio()) {
			if(!this.isFallaAtaque()) {
				if(enemigo.isChanceEvadir()) {
					int chanceDeEvadir = 1 + rand.nextInt((100 - 1) + 1);
					System.out.println(chanceDeEvadir);
					if(!(chanceDeEvadir <= 20)) {
						int daño = this.getAtributos().getAtaque();
						if(isDenfendiendo()) {
							daño = daño - (daño/3);
						}
						String msg = "";
						int chanceCritico = 1 + rand.nextInt((100 - 1) + 1);
						int chance = this.getAtributos().getPresicion();
						if(chanceDobleDaño) {
							chance += 25;
						}
						if (1 <= chanceCritico && chanceCritico <= chance ) {
							daño = daño * 2;
							msg = " Critico! ";
						}
						if(enemigo.isDenfendiendo()) {
							if ((daño - enemigo.getAtributos().getDefensa()/2) > 0) {
								enemigo.getAtributos().setVida(enemigo.getAtributos().getVida() - (daño - enemigo.getAtributos().getDefensa()/2));
								msg += " " + this.getAtributos().getNombre() + " golpea la defensa de " + enemigo.getAtributos().getNombre() + " por " + daño + "D";
							}else {
								msg = "";
								msg += " El ataque de " + this.getAtributos().getNombre() + " is desviado por la defensa de " + enemigo.getAtributos().getNombre();
							}
						}else {
							enemigo.getAtributos().setVida(enemigo.getAtributos().getVida() - daño);
							msg += " " + this.getAtributos().getNombre() + " golpea a " + enemigo.getAtributos().getNombre() + " por " + daño + "D";
							if(chanceParalizar) {
								int chanceParalizar = 1 + rand.nextInt((100 - 1) + 1);
								if(chanceParalizar <= 15) {
									enemigo.nockear(2);
									msg += " y lo paraliza (2 turnos)";
								}
							}
						}
						
						return msg;
					}else {
						return " " +  enemigo.getAtributos().getNombre() + " esquiva el ataque de " + this.getAtributos().getNombre(); 
					}
				}else {
					int daño = this.getAtributos().getAtaque();
					if(isDenfendiendo()) {
						daño = daño - (daño/3);
					}
					String msg = "";
					int chanceCritico = 1 + rand.nextInt((100 - 1) + 1);
					int chance = this.getAtributos().getPresicion();
					if(chanceDobleDaño) {
						chance += 25;
					}
					if (1 <= chanceCritico && chanceCritico <= chance ) {
						daño = daño * 2;
						msg = " Critico! ";
					}
					if(enemigo.isDenfendiendo()) {
						if ((daño - enemigo.getAtributos().getDefensa()/2) > 0) {
							enemigo.getAtributos().setVida(enemigo.getAtributos().getVida() - (daño - enemigo.getAtributos().getDefensa()/2));
							msg += " " + this.getAtributos().getNombre() + " golpea la defensa de " + enemigo.getAtributos().getNombre() + " por " + daño + "D";
						}else {
							msg = "";
							msg += " El ataque de " + this.getAtributos().getNombre() + " es desviado por la defensa de " + enemigo.getAtributos().getNombre();
						}
					}else {
						enemigo.getAtributos().setVida(enemigo.getAtributos().getVida() - daño);
						msg += " " + this.getAtributos().getNombre() + " golpea a " + enemigo.getAtributos().getNombre() + " por " + daño + "D";
						if(chanceParalizar) {
							int chanceParalizar = 1 + rand.nextInt((100 - 1) + 1);
							if(chanceParalizar <= 15) {
								enemigo.nockear(2);
								msg += " y lo paraliza (2 turnos)";
							}
						}
					}
					
					return msg;
				}
			}else {
				this.setFallaAtaque(false);
				return " " + this.getAtributos().getNombre() + " falla su ataque!";
			}
		}else {
			return " " + this.getAtributos().getNombre() + " ataca el cadaver de " + enemigo.getAtributos().getNombre();
		}
	}
	
	
	public ArrayList<ItemPasivo> getItemsPasivos(){
		
		ArrayList<ItemPasivo> itemsPasivos = new ArrayList<>();
		if (this.getItems()[0] != null && ItemActivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[0]);
		}
		if (this.getItems()[1] != null && ItemActivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[1]);
		}
		return itemsPasivos;
	}
	
	public void desactivarItemsPasivos(){
		if (this.getItems()[0] != null && ItemPasivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			getItems()[0].desactivarAccion();
		}
		if (this.getItems()[1] != null && ItemPasivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			getItems()[1].desactivarAccion();
		}
	}
	public void activarItemsPasivos(){
		ArrayList<ItemPasivo> itemsPasivos = new ArrayList<>();
		if (this.getItems()[0] != null && ItemPasivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[0]);
		}
		if (this.getItems()[1] != null  && ItemPasivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			itemsPasivos.add((ItemPasivo)getItems()[1]);
		}
		
		for (ItemPasivo i : itemsPasivos) {
			i.ejecutarAccionPasiva();
		}
	}
	
	public void activarHabilidadPasiva() {
		if (this.getHabilidadPasiva()!= null) {
			this.getHabilidadPasiva().ejecutar(this);
		}
	}
	
	public void desactivarHabilidadPasiva() {
		if (this.getHabilidadPasiva()!= null) {
			this.getHabilidadPasiva().desactivarPasivo((GuerreroJugador) this);
		}
	}
	
	
	public ArrayList<ItemActivo> getItemsActivos(){
		
		ArrayList<ItemActivo> itemsActivos = new ArrayList<>();
		if (!(this.getItems()[0] == null) && ItemActivo.class.isAssignableFrom(this.getItems()[0].getClass())) {
			itemsActivos.add((ItemActivo)getItems()[0]);
		}
		if (!(this.getItems()[1] == null) && ItemActivo.class.isAssignableFrom(this.getItems()[1].getClass())) {
			itemsActivos.add((ItemActivo)getItems()[1]);
		}
		return itemsActivos;
	}
	
	public HabilidadActiva getHabilidadActiva() {
		HabilidadActiva habilidad = null;
		if (!(this.getHabilidad() == null) && HabilidadActiva.class.isAssignableFrom(this.getHabilidad().getClass())) {
			habilidad = (HabilidadActiva) this.getHabilidad();
		}
		return habilidad;
	}
	
	public HabilidadPasiva getHabilidadPasiva() {
		HabilidadPasiva habilidad = null;
		if (!(this.getHabilidad() == null) && HabilidadPasiva.class.isAssignableFrom(this.getHabilidad().getClass())) {
			habilidad = (HabilidadPasiva) this.getHabilidad();
		}
		return habilidad;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public IHabilidad getHabilidad() {
		return habilidad;
	}

	public void setHabilidad(IHabilidad habilidad) {
		this.habilidad = habilidad;
	}

	public boolean isDenfendiendo() {
		return denfendiendo;
	}

	public void setDenfendiendo(boolean denfendiendo) {
		this.denfendiendo = denfendiendo;
	}

	public boolean isChanceParalizar() {
		return chanceParalizar;
	}

	public void setChanceParalizar(boolean chanceParalizar) {
		this.chanceParalizar = chanceParalizar;
	}

	public boolean isChanceDobleDaño() {
		return chanceDobleDaño;
	}

	public void setChanceDobleDaño(boolean chanceDobleDaño) {
		this.chanceDobleDaño = chanceDobleDaño;
	}

	public boolean isChanceEvadir() {
		return chanceEvadir;
	}

	public void setChanceEvadir(boolean chanceEvadir) {
		this.chanceEvadir = chanceEvadir;
	}
	public void nockear(int pausarTurnos) {
		setTurnoPausado(true);
		setContTurnosPausados(pausarTurnos);
	}

	public boolean checkNocked() {
		if (this.getContTurnosPausados() == 0) {
			this.setTurnoPausado(false);
		}
		this.setContTurnosPausados(this.getContTurnosPausados()-1);
		return this.isTurnoPausado();
	}
	
	public boolean isTurnoPausado() {
		return turnoPausado;
	}

	public void setTurnoPausado(boolean turnoPausado) {
		this.turnoPausado = turnoPausado;
	}

	public int getContTurnosPausados() {
		return contTurnosPausados;
	}

	public void setContTurnosPausados(int contTurnosPausados) {
		this.contTurnosPausados = contTurnosPausados;
	}
	
	public void HeridaSangrante(int turnos) {
		this.setHeridaSangrante(true);
		this.setContHeridaSangrante(turnos);
	}
	
	public boolean checkheridaSangrante() {
		if(this.contHeridaSangrante == 0) {
			this.heridaSangrante = false;
		}
		this.setContHeridaSangrante(getContHeridaSangrante() - 1);
		return this.isHeridaSangrante();
	}

	public boolean isHeridaSangrante() {
		return heridaSangrante;
	}

	public void setHeridaSangrante(boolean heridaSangrante) {
		this.heridaSangrante = heridaSangrante;
	}

	public int getContHeridaSangrante() {
		return contHeridaSangrante;
	}

	public void setContHeridaSangrante(int contHeridaSangrante) {
		this.contHeridaSangrante = contHeridaSangrante;
	}

	public boolean isFallaAtaque() {
		return fallaAtaque;
	}

	public void setFallaAtaque(boolean fallaAtaque) {
		this.fallaAtaque = fallaAtaque;
	}
	
	
}

