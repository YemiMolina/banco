package es.uc3m.tiw.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class ConciliacionProfesor {


	@Id

	private long idProfesor;
	private int mes;
	private int anyo;
	private double importe;

	
	public ConciliacionProfesor(){
		super();
	}

	public ConciliacionProfesor( int mes, int anyo,
			double importe, long idProfesor) {
		super();
	
	
		this.mes = mes;
		this.anyo = anyo;
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
