package com.example.Sprint4;

import com.example.Sprint4.entities.*;
import com.example.Sprint4.repositories.*;
import com.example.Sprint4.enums.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@SpringBootApplication
public class ElBuenSaborApplication {

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
	@Autowired
	private DetallePedidoRepository detallePedidoRepository;
	@Autowired
	private DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	private DomicilioRepository domicilioRepository;
	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;


	public static void main(String[] args) {
		SpringApplication.run(ElBuenSaborApplication.class, args);
		System.out.println("Estoy Funcionando");
	}

	@Bean
	CommandLineRunner init() {
		return args -> {
			System.out.println("-------------------Funcionando------------------");

			UnidadMedida kilogramos = UnidadMedida.builder()
					.abreviatura("Kg")
					.denominacion("Kilogramo")
					.fechaAlta(LocalDateTime.now())
					.build();
			unidadMedidaRepository.save(kilogramos);

			RubroArticulo sandwiches = RubroArticulo.builder()
					.denominacion("Sandwiches")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(sandwiches);

			RubroArticulo burgers = RubroArticulo.builder()
					.denominacion("Burgers")
					.fechaAlta(LocalDateTime.now())
					.rubroPadre(sandwiches)
					.build();
			rubroArticuloRepository.save(burgers);

			RubroArticulo lomardos = RubroArticulo.builder()
					.denominacion("Lomos")
					.fechaAlta(LocalDateTime.now())
					.rubroPadre(sandwiches)
					.build();
			rubroArticuloRepository.save(lomardos);

			RubroArticulo pizzas = RubroArticulo.builder()
					.denominacion("Pizzas")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(pizzas);

			RubroArticulo drinks = RubroArticulo.builder()
					.denominacion("Bebidas")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(drinks);

			RubroArticulo panchuni = RubroArticulo.builder()
					.denominacion("Panchos")
					.fechaAlta(LocalDateTime.now())
					.build();
			rubroArticuloRepository.save(panchuni);

			ArticuloManufacturado HamburguesaCompleta = ArticuloManufacturado.builder()
					.costo(new BigDecimal(1400))
					.denominacion("Hamburguesa Completa")
					.descripcion("Un medallon de carne, lechuga, tomate, cebolla, queso, jamon, con papas")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(2000))
					.tiempoEstimadoCocina(50)
					.urlImagen("https://fotodeburguer.png")
					.rubroArticulo(burgers)
					.build();
			articuloManufacturadoRepository.save(HamburguesaCompleta);

			ArticuloManufacturado LomoconPalta = ArticuloManufacturado.builder()
					.costo(new BigDecimal(2000))
					.denominacion("Lomo con palta")
					.descripcion("Lomo completo con palta")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(2500))
					.tiempoEstimadoCocina(40)
					.urlImagen("https://fotolomardinan.png")
					.rubroArticulo(lomardos)
					.build();
			articuloManufacturadoRepository.save(LomoconPalta);

			ArticuloManufacturado PizzaCalabresa = ArticuloManufacturado.builder()
					.costo(new BigDecimal(2100))
					.denominacion("Pizza Calabresa")
					.descripcion("Pizza muzza con salame, 8 porciones")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(2700))
					.tiempoEstimadoCocina(10)
					.urlImagen("https://fotopizza.png")
					.rubroArticulo(pizzas)
					.build();
			articuloManufacturadoRepository.save(PizzaCalabresa);

			ArticuloManufacturado PanchoConCheddar = ArticuloManufacturado.builder()
					.costo(new BigDecimal(2500))
					.denominacion("Pancho con Cheddar")
					.descripcion("Pancho 30cm con cheddar y pedacitos de bacon")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(3000))
					.tiempoEstimadoCocina(10)
					.urlImagen("https://fotopancho.png")
					.rubroArticulo(panchuni)
					.build();
			articuloManufacturadoRepository.save(PanchoConCheddar);

			ArticuloManufacturado CocaCola = ArticuloManufacturado.builder()
					.costo(new BigDecimal(300))
					.denominacion("CocaCola 500ml")
					.fechaAlta(LocalDateTime.now())
					.precioVenta(new BigDecimal(500))
					.tiempoEstimadoCocina(10)
					.urlImagen("https://fotococa.png")
					.rubroArticulo(drinks)
					.build();
			articuloManufacturadoRepository.save(PanchoConCheddar);

			Usuario user1 = Usuario.builder()
					.username("betunsa")
					.auth0Id(1)
					.fechaAlta(LocalDateTime.now())
					.build();
			Cliente cli1 = Cliente.builder()
					.apellido("Cisterna")
					.email("emicisterna3@gmail.com")
					.fechaAlta(LocalDateTime.now())
					.nombre("Emiliano")
					.telefono("2616969690")
					.usuario(user1)
					.build();
			clienteRepository.save(cli1);
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Cochabamba")
					.codigoPostal(5521)
					.fechaAlta(LocalDateTime.now())
					.localidad("Guaymallen")
					.numero(313)
					.cliente(cli1)
					.build();
			domicilioRepository.save(domicilio1);
			LocalTime hora = LocalTime.of(22, 30, 0);

			Pedido ped1 = Pedido.builder()
					.cliente(cli1)
					.domicilioEntrega(domicilio1)
					.estado(EstadoPedido.PREPARACION)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.totalCosto(new BigDecimal(8000))
					.total(new BigDecimal(16000))
					.fechaPedido(LocalDate.of(2023, 10, 20))
					.fechaAlta(LocalDateTime.now())
					.horaEstimadaFinalizacion(hora)
					.build();
			pedidoRepository.save(ped1);

			DetallePedido det1 = DetallePedido.builder()
					.cantidad(4)
					.articuloManufacturado(CocaCola)
					.pedido(ped1)
					.build();
			detallePedidoRepository.save(det1);
			Factura fac1 = Factura.builder()
					.fechaAlta(LocalDateTime.now())
					.fechaFacturacion(LocalDateTime.now())
					.formaPago(FormaPago.EFECTIVO)
					.pedido(ped1)
					.build();
			facturaRepository.save(fac1);
			DetalleFactura detfac1 = DetalleFactura.builder()
					.cantidad(4)
					.articuloManufacturado(CocaCola)
					.facturas(fac1)
					.build();
			detalleFacturaRepository.save(detfac1);

			Usuario user2 = Usuario.builder()
					.username("gu1llote")
					.auth0Id(1)
					.fechaAlta(LocalDateTime.now())
					.build();

			Cliente cli2 = Cliente.builder()
					.apellido("Bellido")
					.email("bellidoguillermo@gmail.com")
					.fechaAlta(LocalDateTime.now())
					.nombre("Guillermo")
					.telefono("2613322123")
					.usuario(user2)
					.build();
			clienteRepository.save(cli2);

			Domicilio dom2 = Domicilio.builder()
					.calle("caniadita alegre")
					.codigoPostal(5521)
					.fechaAlta(LocalDateTime.now())
					.localidad("Guaymallen")
					.numero(444)
					.cliente(cli2)
					.build();
			domicilioRepository.save(dom2);

			LocalTime hora2 = LocalTime.of(22, 30, 0);

			Pedido ped2 = Pedido.builder()
					.cliente(cli2)
					.domicilioEntrega(domicilio1)
					.estado(EstadoPedido.PAGADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.fechaAlta(LocalDateTime.now())
					.totalCosto(new BigDecimal(1000))
					.total(new BigDecimal(2000))
					.fechaPedido(LocalDate.of(2023, 10, 10))
					.horaEstimadaFinalizacion(hora)
					.build();
			pedidoRepository.save(ped2);
			DetallePedido det2 = DetallePedido.builder()
					.cantidad(4)
					.articuloManufacturado(CocaCola)
					.pedido(ped1)
					.build();
			detallePedidoRepository.save(det2);
			Pedido pedido3 = Pedido.builder()
					.cliente(cli2)
					.domicilioEntrega(domicilio1)
					.estado(EstadoPedido.PENDIENTE_PAGO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.totalCosto(new BigDecimal(4000))
					.total(new BigDecimal(8000))
					.fechaPedido(LocalDate.of(2023, 10, 10))
					.fechaAlta(LocalDateTime.now())
					.horaEstimadaFinalizacion(hora)
					.build();
			pedidoRepository.save(pedido3);
			DetallePedido detalle3 = DetallePedido.builder()
					.cantidad(4)
					.articuloManufacturado(CocaCola)
					.pedido(ped1)
					.build();
			detallePedidoRepository.save(detalle3);

			ArticuloInsumo art1 = ArticuloInsumo.builder()
					.rubroArticulo(null)
					.denominacion("Queso")
					.fechaBaja(null)
					.fechaAlta(LocalDateTime.now())
					.precioCompra(new BigDecimal(1200))
					.stockActual(new BigDecimal(100))
					.stockMinimo(new BigDecimal(10))
					.unidadMedida(null)
					.build();
			articuloInsumoRepository.save(art1);

			ArticuloInsumo art2 = ArticuloInsumo.builder()
					.rubroArticulo(null)
					.denominacion("Tomate")
					.fechaBaja(null)
					.fechaAlta(LocalDateTime.now())
					.precioCompra(new BigDecimal(1200))
					.stockActual(new BigDecimal(2))
					.stockMinimo(new BigDecimal(20))
					.unidadMedida(null)
					.build();
			articuloInsumoRepository.save(art2);


			Pedido ped4 = Pedido.builder()
					.cliente(cli2)
					.domicilioEntrega(domicilio1)
					.estado(EstadoPedido.PAGADO)
					.tipoEnvio(TipoEnvio.DELIVERY)
					.fechaAlta(LocalDateTime.now())
					.totalCosto(new BigDecimal(1000))
					.total(new BigDecimal(2000))
					.fechaPedido(LocalDate.of(2023, 10, 10))
					.horaEstimadaFinalizacion(hora)
					.build();
			pedidoRepository.save(ped4);
			Factura factura2 = Factura.builder()
					.fechaAlta(LocalDateTime.of(2023,02,12,12,25))
					.fechaFacturacion(LocalDateTime.now())
					.formaPago(FormaPago.EFECTIVO)
					.pedido(ped4)
					.build();
			facturaRepository.save(factura2);
			DetalleFactura detallefac2 = DetalleFactura.builder()
					.cantidad(10)
					.articuloManufacturado(HamburguesaCompleta)
					.facturas(factura2)
					.build();
			detalleFacturaRepository.save(detallefac2);

		};
	}

}
