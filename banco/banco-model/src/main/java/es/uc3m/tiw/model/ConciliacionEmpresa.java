package es.uc3m.tiw.model;

import javax.persistence.Id;

public class ConciliacionEmpresa{

	@Id
	private long id;
	private int mes;
	private int anyo;
	private double importe;
	
	
	public ConciliacionEmpresa() {
		super();
	}


	public ConciliacionEmpresa(long id,int mes, int anyo,
			double importe) {
		super();
		this.id = id;
		this.mes = mes;
		this.anyo = anyo;
		this.importe = importe;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
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
	
	

}
