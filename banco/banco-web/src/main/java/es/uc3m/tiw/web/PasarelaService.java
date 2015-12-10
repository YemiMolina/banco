package es.uc3m.tiw.web;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import es.uc3m.tiw.model.ConciliacionEmpresa;
import es.uc3m.tiw.model.ConciliacionProfesor;
import es.uc3m.tiw.model.Pedido;
import es.uc3m.tiw.model.daos.ConciliacionEmpresaDAO;
import es.uc3m.tiw.model.daos.ConciliacionProfesorDAO;
import es.uc3m.tiw.model.daos.PedidoDAO;

@Path("pasarela")
@Stateless
public class PasarelaService {

	@Context
	private UriInfo context;
	@PersistenceContext(unitName = "banco-model")
	private EntityManager em;
	private UserTransaction ut;
	private PedidoDAO daoPedido;
	private ConciliacionProfesorDAO daoCP;
	private ConciliacionEmpresaDAO daoCE;

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
	 * http://localhost:8080/banco-web/resources/pasarela/pago/importe/tarjeta
	 * /codigoPedido
	 * 
	 * @param importe
	 * @param numeroTarjeta
	 * @param codigoPedido
	 * @return XML
	 */

	/* Obtenemos los datos mediante get */
	@GET
	@Path("pagoNormal/{importe}/{tarjeta}/{codigoPedido}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String getDatos(@PathParam("importe") double importe,
			@PathParam("tarjeta") String numeroTarjeta,
			@PathParam("codigoPedido") String codigoPedido) {

		daoPedido = new PedidoDAO(em, ut);

		numeroTarjeta = numeroTarjeta.toUpperCase();
		Date fecha = new Date();
		String codigoOperacion = "BANCO"
				+ new SimpleDateFormat("yyyyMMddhhssSSSSXX").format(fecha);

		if (importe > 0 && codigoPedido.length() != 0
				&& numeroTarjeta.matches("[A|B]+\\{19}")) {

			Pedido pedido = new Pedido(codigoPedido, numeroTarjeta, importe,
					codigoOperacion);

			try {
				daoPedido.guardarPedido(pedido);
			} catch (SecurityException | IllegalStateException
					| RollbackException | HeuristicMixedException
					| HeuristicRollbackException | SystemException
					| NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return codigoOperacion;
		}
		return "";

	}

	@GET
	@Path("pagoVale/{importe}/{tarjeta}/{codigoPedido}/{codigoVale}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String validarCompra(@PathParam("importe") double importe,
			@PathParam("tarjeta") String numeroTarjeta,
			@PathParam("codigoPedido") String codigoPedido,
			@PathParam("codigoVale") String codigoVale) {

		daoPedido = new PedidoDAO(em, ut);
		numeroTarjeta = numeroTarjeta.toUpperCase();
		Date date = new Date();

		String codigoOperacion = "BANCO"
				+ new SimpleDateFormat("yyyyMMddhhssSSSSXX").format(date);

		if (importe > 0 && codigoPedido.length() != 0
				&& codigoVale.length() != 0
				&& numeroTarjeta.matches("[A|B]+\\w{19}")) {

			Pedido pedido = new Pedido(codigoPedido, numeroTarjeta, importe,
					codigoOperacion, codigoVale);

			try {
				daoPedido.guardarPedido(pedido);
			} catch (SecurityException | IllegalStateException
					| RollbackException | HeuristicMixedException
					| HeuristicRollbackException | SystemException
					| NotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return codigoOperacion;

		}
		return "";
	}

	/* CONCILIACION */
	@GET
	@Path("conciliacionProfesor/{anyo}/{mes}/{importe}/{idProfesor}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String conciliacionProfesor(@PathParam("anyo") int anyo,
			@PathParam("mes") int mes, @PathParam("importe") double importe,
			@PathParam("idProfesor") Long idProfesor)
			throws HeuristicMixedException, HeuristicRollbackException,
			SystemException, NotSupportedException, RollbackException {

		ConciliacionProfesor conciliacionProfesor = new ConciliacionProfesor(
				mes, anyo, importe, idProfesor);

		try {
			daoCP.guardarConciliacionProfesor(conciliacionProfesor);
			return "ok";
		} catch (SecurityException | IllegalStateException e) {
		}
		return "";
	}

	@GET
	@Path("conciliacionEmpresa/{anyo}/{mes}/{importe}/{id}/xml")
	@Consumes(MediaType.TEXT_PLAIN)
	@Produces(MediaType.TEXT_PLAIN)
	public String conciliacionEmpresa(@PathParam("anyo") int anyo,
			@PathParam("mes") int mes, @PathParam("importe") double importe,
			@PathParam("id") long id) throws HeuristicMixedException,
			HeuristicRollbackException, SystemException, NotSupportedException,
			RollbackException {
		ConciliacionEmpresa conciliacionEmpresa = new ConciliacionEmpresa(id,
				mes, anyo, (importe * 0.99));

		try {
			daoCE.guardarConciliacionEmpresa(conciliacionEmpresa);
			return "ok";
		} catch (SecurityException | IllegalStateException e) {
		}
		return "";
	}

}
