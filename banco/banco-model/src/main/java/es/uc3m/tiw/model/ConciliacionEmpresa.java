package es.uc3m.tiw.model;



public class ConciliacionEmpresa{

	
	private int mes;
	private int anyo;
	private double importe;
	
	
	public ConciliacionEmpresa() {
		super();
	}


	public ConciliacionEmpresa(int mes, int anyo,
			double importe) {
		super();

		this.mes = mes;
		this.anyo = anyo;
		this.importe = importe;
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
