package pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.repository.ProductRepository;
import pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.service.ProductoService;

import java.util.List;
import java.util.Optional;

@RestController
    @RequestMapping("/api/producto")
    public class ProductoController {
        private final ProductoService productoService;

        @Autowired
        public ProductoController(ProductoService productoService) {
            this.productoService = productoService;
        }

        @GetMapping
        public List<Producto> obtenerTodosLosProductos() {
            return productoService.obtenerTodosLosProductos();
        }

        @GetMapping("/{id}")
        public Optional<Producto> obtenerProductoPorId(@PathVariable Integer id) {
            return productoService.obtenerProductoPorId(id);
        }

        @PostMapping
        public Producto crearProducto(@RequestBody Producto producto) {
            return productoService.crearProducto(producto);
        }

        @PutMapping("/{id}")
        public Producto actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
            producto.setId(id);
            return productoService.actualizarProducto(producto);
        }

        @DeleteMapping("/{id}")
        public void eliminarProductoPorId(@PathVariable Integer id) {
            productoService.eliminarProductoPorId(id);
        }

    @Autowired
    private ProductRepository productoRepository;

    @GetMapping("/por-nombre/{nombre}")
    public List<Producto> buscarPorNombre(@PathVariable String nombre) {
        return productoRepository.findByNombre(nombre);
    }

    @GetMapping("/cantidad-entre-10-y-100")
    public List<Producto> buscarPorCantidadEntre10Y100() {
        return productoRepository.findProductosByCantidadBetween10And100();
    }

    @GetMapping("/vencimiento-2024")
    public List<Producto> buscarPorVencimiento2024() {
        return productoRepository.findProductosByYear2024();
    }
    }