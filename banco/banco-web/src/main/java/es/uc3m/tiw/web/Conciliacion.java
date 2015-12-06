package es.uc3m.tiw.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;




@Path("Conciliacion")
@Stateless
public class Conciliacion {
	
	private EntityManager em;
	/**
     * Default constructor. 
     */
    public Conciliacion() {
    }

    @PostConstruct
    public void postConstructor(){
    	
    }

    /**
     * Retrieves representation of an instance of Conciliacion
     */
	@GET
	@Path("proveedor/{anio}/{mes}/{importe}/{idProveedor}")
	@Produces("text/plain")
	public void conciliacionAdmin(@PathParam("anio")String anio,@PathParam("mes")String mes,@PathParam("importe")double importe, @PathParam("idProveedor")Long idProveedor) {
		Date date=new Date();
		String dia = new SimpleDateFormat("dd").format(date);
		
	}

    /**
     * Retrieves representation of an instance of Conciliacion
     */
	@GET
	@Path("empresa/{anio}/{mes}/{importe}")
	@Produces("text/plain")
	public void conciliacionPortal(@PathParam("anio")String anio,@PathParam("mes")String mes,@PathParam("importe")double importe) {
		Date date=new Date();
		String dia = new SimpleDateFormat("dd").format(date);
		
	}
}