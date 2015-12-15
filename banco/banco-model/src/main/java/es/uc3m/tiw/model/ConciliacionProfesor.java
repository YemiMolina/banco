package es.uc3m.tiw.model;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class ConciliacionProfesor {


	@Id
	@GeneratedValue(strategy = AUTO)
	private long idProfesor;
	private int anyo;
	private int mes;
	private double importe;

	
	public ConciliacionProfesor(){
		super();
	}

	public ConciliacionProfesor(int anyo, int mes,
			double importe,long idProfesor) {
		super();
	
		this.anyo = anyo;
		this.mes = mes;
		this.importe = importe;
		this.idProfesor = idProfesor;
	}

	

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	public long getCodigoProfesor() {
		return idProfesor;
	}

	public void setCodigoProfesor(long idProfesor) {
		this.idProfesor = idProfesor;

	}

	

}
