package com.example.Sprint3;

import com.example.Sprint3.entities.*;
import com.example.Sprint3.enums.EstadoPedido;
import com.example.Sprint3.enums.FormaPago;
import com.example.Sprint3.enums.TipoEnvio;
import com.example.Sprint3.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;


@SpringBootApplication
public class Sprint3Application {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private FacturaRepository facturaRepository;
	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	private RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;


	public static void main(String[] args) {
		SpringApplication.run(Sprint3Application.class, args);
		System.out.println("Funca todo piola wachin");
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			System.out.println("-------------------Funcionando------------------");

			SimpleDateFormat formatoFecha= new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatoHora= new SimpleDateFormat("hh:mm:ss");
			String fechaString = "2023-09-13";
			String fechaString2 = "2023-05-19";
			String fechaString3 = "2023-03-21";
			String fechaString4 = "2023-07-11";
			String horaString = "21:05:03";

			Date fecha1 = formatoFecha.parse(fechaString);
			Date fecha2 = formatoFecha.parse(fechaString2);
			Date fecha3 = formatoFecha.parse(fechaString3);
			Date fecha4 = formatoFecha.parse(fechaString4);
			Date hora = formatoHora.parse(horaString);


			Usuario usuario = Usuario.builder()
					.auth0Id("Usuario01")
					.username("Emigrandpa")
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.build();

			Cliente cliente = Cliente.builder()
					.nombre("Pablo")
					.apellido("Cisterna")
					.telefono("2615213253")
					.email("algunmail@gmail.com")
					.usuario(usuario)
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.build();

			Domicilio domicilio = Domicilio.builder()
					.calle("Lamadrid")
					.codigoPostal(5519)
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.localidad("Guaymallen")
					.numero(734)
					.numeroDpto(2)
					.pisoDpto(4)
					.build();

			cliente.AgregarDomicilios(domicilio);

			DetallePedido detallePedido = DetallePedido.builder()
					.cantidad(4)
					.subtotal(7000)
					.subtotalCosto(5000)
					.build();

			RubroArticulo rubroArticulo = RubroArticulo.builder()
					.denominacion("Carne")
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.build();

			ArticuloInsumo articuloInsumo = ArticuloInsumo.builder()
					.denominacion("Carne molida")
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.precioCompra(50000)
					.stockActual(200)
					.stockMinimo(100)
					.urlImagen("http://algunaimagen.com")
					.rubroArticulo(rubroArticulo)
					.build();

			UnidadMedida unidadMedida = UnidadMedida.builder()
					.abreviatura("Kg")
					.denominacion("Kilogramo")
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.build();

			unidadMedida.AgregarArticulosInsumo(articuloInsumo);

			DetalleArticuloManufacturado detalleArticuloManufacturado = DetalleArticuloManufacturado.builder()
					.cantidad(7)
					.build();

			ArticuloManufacturado articuloManufacturado = ArticuloManufacturado.builder()
					.costo(3922)
					.denominacion("Hamburguesa")
					.descripcion("Hamburguesa con cheddar")
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.precioVenta(140000)
					.tiempoEstimadoCocina(25)
					.urlImagen("http://algunaimagendehamburguesa.com")
					.build();

			articuloManufacturado.AgregarDetalleArtManufac(detalleArticuloManufacturado);

			Pedido pedido = Pedido.builder()
					.estado(EstadoPedido.EN_CAMINO)
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.fechaPedido(fecha4)
					.formaPago(FormaPago.EFECTIVO)
					.horaEstimadaFinalizacion(hora)
					.tipoEnvio(TipoEnvio.TAKE_AWAY)
					.total(5000)
					.totalCosto(3000)
					.domicilioEntrega(domicilio)
					.build();

			Factura factura = Factura.builder()
					.fechaAlta(fecha1)
					.fechaBaja(fecha2)
					.fechaModificacion(fecha3)
					.formaPago(FormaPago.EFECTIVO)
					.mpMerchantOrderId(2341037793L)
					.mpPaymentId(3413245869L)
					.mpPaymentType("noIdea")
					.totalVenta(451923)
					.pedido(pedido)
					.build();

			DetalleFactura detalleFactura = DetalleFactura.builder()
					.cantidad(7)
					.subtotal(5000)
					.articuloManufacturado(articuloManufacturado)
					.facturas(factura)
					.build();

			articuloInsumo.AgregarDetallesFactura(detalleFactura);

			pedido.AgregarDetallePedido(detallePedido);
			cliente.AgregarPedidos(pedido);

			clienteRepository.save(cliente);

			pedidoRepository.save(pedido);

			articuloManufacturadoRepository.save(articuloManufacturado);

			unidadMedidaRepository.save(unidadMedida);

			rubroArticuloRepository.save(rubroArticulo);

			facturaRepository.save(factura);


		};
	}
}