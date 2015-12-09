package es.uc3m.tiw.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.Usuario;
import es.uc3m.tiw.model.daos.IPedido;
import es.uc3m.tiw.model.daos.PedidoDAO;

/**
 * La url de acceso sera: Para getText() --
 * http://localhost:8080/banco/pasarela/prueba Para getDatos() --
 * http://localhost:8080/resources/pasarela/prueba/23/david
 * 
 * @author David Palomar
 *
 */
@Path("pasarela")
public class PasarelaService {

	@Context
	private UriInfo context;
	@PersistenceContext(unitName = "banco-model")
	private EntityManager em;
	private UserTransaction ut;
	private PedidoDAO daoPedido;

	/**
	 * Default constructor.
	 */
	public PasarelaService() {

	}

	/**
	 * Se invoca por GET la URL:
	 * http://localhost:8080/banco-web/resources/pasarela/prueba y devuelve
	 * "Todo OK"
	 * 
	 * @return Todo OK
	 */
	@GET
	@Path("prueba")
	@Produces(MediaType.TEXT_PLAIN)
	public String getText() {
		return "Todo OK";
	}

	/**
	 * Se pasan los datos por GET y los parametros se muestran en un XML La URL
	 * sera:
	 * http://localhost:8080/banco-web/resources/pasarela/pago/importe/tarjeta/codigoPedido 
	 * @param importe
	 * @param numeroTarjeta
	 * @param codigoPedido
	 * @return XML
	 */

	/* Obtenemos los datos mediante get */
	@GET
	@Path("pago/{importe}/{tarjeta}/{codigoPedido}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getDatos(@PathParam("importe") double importe,
			@PathParam("tarjeta") String numeroTarjeta,
			@PathParam("codigoPedido") String codigoPedido) {

		daoPedido = new PedidoDAO(em, ut);

		numeroTarjeta = numeroTarjeta.toUpperCase();
		Date fecha = new Date();
		String codigoOperacion = "BANCO"
				+ new SimpleDateFormat("yyyyMMddhhssSSSSXXZZ").format(fecha);
		
		if (importe > 0 && codigoPedido.length() != 0
				&& numeroTarjeta.matches("[A|B]+\\{19}")) {

			Pedido pedido = new Pedido(codigoPedido, numeroTarjeta, importe);

			/*
			 * try{ daoPedido.guardarPedido(pedido); return codigoOperacion;
			 * 
			 * } catch (SecurityException | IllegalStateException |
			 * RollbackException | HeuristicMixedException |
			 * HeuristicRollbackException | SystemException |
			 * NotSupportedException e) {} }
			 */

			return "Los datos introducidos son: numero=" + importe
					+ " palabra= " + numeroTarjeta + " codigoPedido= "
					+ codigoPedido;
		}
		return codigoOperacion;

	}

	@GET
	@Path("pago/{importe}/{tarjeta}/{codigoPedido}/{codigoVale}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String validarCompra(@PathParam("importe") double importe,
			@PathParam("tarjeta") String numeroTarjeta,
			@PathParam("codigoPedido") String codigoPedido,
			@PathParam("codigoVale") String codigoVale) {
		
		daoPedido = new PedidoDAO(em, ut);
		numeroTarjeta = numeroTarjeta.toUpperCase();
		Date date = new Date();
		
		String codOperacion = "BANCO"
				+ new SimpleDateFormat("yyyyMMddhhssSSSSXXZZ").format(date);
		
		if (importe > 0 && codigoPedido.length() != 0
				&& codigoVale.length() != 0
				&& numeroTarjeta.matches("[A|B]+\\w{19}")) {
			
			Pedido pedido = new Pedido(importe, numeroTarjeta, codigoPedido,
					codOperacion, codigoVale);
			/*
			 * try { daoPedido = new PedidoDAO(em);
			 * daoPedido.guardarPedido(pedido); return codigoOperacion; } catch
			 * (SecurityException | IllegalStateException | RollbackException |
			 * HeuristicMixedException | HeuristicRollbackException |
			 * SystemException | NotSupportedException e) {} }
			 */
			return "";
		}
		return codigoVale;
	}

	/**
	 * Ejemplo en el que se accede por POST y se consume texto plano pero se
	 * devuelve un objeto {@link Usuario} que es convertido a XML La URL es:
	 * http://localhost:8080/banco-web/resources/pasarela/usuario/10/david/xml
	 * 
	 * @param edad
	 * @param nombre
	 * @return documento XML del usuario
	 */
	@POST
	@Path("usuario/{edad}/{nombre}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_XML)
	public Usuario devuelveXML(@PathParam("edad") Integer edad,
			@PathParam("nombre") String nombre) {
		return new Usuario(edad, nombre);
	}

}