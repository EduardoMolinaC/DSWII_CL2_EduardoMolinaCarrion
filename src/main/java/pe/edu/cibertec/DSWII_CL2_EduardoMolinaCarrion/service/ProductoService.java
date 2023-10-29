package pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.model.bd.Producto;
import pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
    public class ProductoService {
        private final ProductRepository productoRepository;

        @Autowired
        public ProductoService(ProductRepository productoRepository) {
            this.productoRepository = productoRepository;
        }

        public List<Producto> obtenerTodosLosProductos() {
            return productoRepository.findAll();
        }

        public Optional<Producto> obtenerProductoPorId(Integer id) {
            return productoRepository.findById(id);
        }

        public Producto crearProducto(Producto producto) {
            return productoRepository.save(producto);
        }

        public Producto actualizarProducto(Producto producto) {
            return productoRepository.save(producto);
        }

        public void eliminarProductoPorId(Integer id) {
            productoRepository.deleteById(id);
        }
    }
