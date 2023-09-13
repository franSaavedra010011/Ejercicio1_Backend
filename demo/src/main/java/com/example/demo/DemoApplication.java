package com.example.demo;

import com.example.demo.Entity.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepo) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO-----------------");
			/*Cliente cliente = new Cliente();
			cliente.setNombre("Francisco");
			cliente.setApellido("Saavedra");
			cliente.setTelefono("2611111111");
			cliente.setEmail("abc@gmail.com");*/

			Cliente cliente = Cliente.builder()
				.nombre("Francisco")
				.apellido("Saavedra")
				.telefono("2611111111")
				.email("abc@gmail.com")
				.build();

			Domicilio domicilio1 = Domicilio.builder()
				.localidad("Guaymallen")
				.calle("Carril Godoy Cruz")
				.numero("800")
				.build();

			Domicilio domicilio2 = Domicilio.builder()
				.localidad("Ciudad")
				.calle("Av. San Martin")
				.numero("1500")
				.build();

			Pedido pedido1 = Pedido.builder()
				.estado("Iniciado")
				.fecha("12-09-2023")
				.tipoEnvio("delivery")
				.total(2500)
				.build();

			Pedido pedido2 = Pedido.builder()
				.estado("preparacion")
				.fecha("12-09-2023")
				.tipoEnvio("delivery")
				.total(1500)
				.build();

			DetallePedido dp1 = DetallePedido.builder()
				.cantidad(1)
				.subtotal(2000)
				.build();

			DetallePedido dp2 = DetallePedido.builder()
				.cantidad(1)
				.subtotal(500)
				.build();

			Producto producto1 = Producto.builder()
				.tipo("manufacturado")
				.tiempoEstimadoCocina(30)
				.denominacion("Hamburguesa")
				.precioVenta(2000)
				.precioCompra(1000)
				.stockActual(150)
				.stockMinimo(50)
				.unidadMedida("gr")
				.receta("...")
				.build();

			Producto producto2 = Producto.builder()
				.tipo("insumo")
				.tiempoEstimadoCocina(0)
				.denominacion("Coca-cola")
				.precioVenta(500)
				.precioCompra(200)
				.stockActual(300)
				.stockMinimo(10)
				.unidadMedida("ml")
				.receta("...")
				.build();

			Rubro rubro1 = Rubro.builder()
				.denominacion("Alimentos procesados")
				.build();

			Rubro rubro2 = Rubro.builder()
				.denominacion("Bebidas")
				.build();


			clienteRepository.save(cliente);
			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);
			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);
			detallePedidoRepository.save(dp1);
			detallePedidoRepository.save(dp2);
			productoRepository.save(producto1);
			productoRepository.save(producto2);
			rubroRepository.save(rubro1);
			rubroRepository.save(rubro2);

			Cliente clienteRecuperada = clienteRepository.findById(cliente.getId()).orElse(null);
			if (clienteRecuperada != null) {
				System.out.println("Nombre: " + clienteRecuperada.getNombre());
				System.out.println("Apellido: " + clienteRecuperada.getApellido());
				System.out.println("Telefono: " + clienteRecuperada.getTelefono());
				System.out.println("Email: " + clienteRecuperada.getEmail());
			}

			Domicilio domicilioRecuperado = domicilioRepository.findById(domicilio1.getId()).orElse(null);
			if (domicilioRecuperado != null) {
				System.out.println("Localidad: " + domicilioRecuperado.getLocalidad());
				System.out.println("Calle: " + domicilioRecuperado.getCalle());
				System.out.println("Número: " + domicilioRecuperado.getNumero());
			}

			Pedido pedidoRecuperado = pedidoRepository.findById(pedido1.getId()).orElse(null);
			if (pedidoRecuperado != null) {
				System.out.println("Estado: " + pedidoRecuperado.getEstado());
				System.out.println("Fecha: " + pedidoRecuperado.getFecha());
				System.out.println("Tipo de Envío: " + pedidoRecuperado.getTipoEnvio());
				System.out.println("Total: " + pedidoRecuperado.getTotal());
			}

			DetallePedido detallePedidoRecuperado = detallePedidoRepository.findById(dp1.getId()).orElse(null);
			if (detallePedidoRecuperado != null) {
				System.out.println("Cantidad: " + detallePedidoRecuperado.getCantidad());
				System.out.println("Subtotal: " + detallePedidoRecuperado.getSubtotal());
			}

			Producto productoRecuperado = productoRepository.findById(producto1.getId()).orElse(null);
			if (productoRecuperado != null) {
				System.out.println("Tipo: " + productoRecuperado.getTipo());
				System.out.println("Denominación: " + productoRecuperado.getDenominacion());
				System.out.println("Precio de Venta: " + productoRecuperado.getPrecioVenta());
				System.out.println("Precio de Compra: " + productoRecuperado.getPrecioCompra());
				System.out.println("Stock Actual: " + productoRecuperado.getStockActual());
			}

			Rubro rubroRecuperado = rubroRepository.findById(rubro1.getId()).orElse(null);
			if (rubroRecuperado != null) {
				System.out.println("Denominación del Rubro: " + rubroRecuperado.getDenominacion());
			}

		};
	}
}