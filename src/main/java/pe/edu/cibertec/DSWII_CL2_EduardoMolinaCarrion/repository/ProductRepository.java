package pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.edu.cibertec.DSWII_CL2_EduardoMolinaCarrion.model.bd.Producto;

import java.util.List;

public interface ProductRepository extends JpaRepository<Producto, Integer> {

    List<Producto> findByNombre(String nombre);

    @Query("SELECT p FROM Producto p WHERE p.cantidad > 10 AND p.cantidad < 100")
    List<Producto> findProductosByCantidadBetween10And100();

    @Query(value = "SELECT * FROM Producto p WHERE YEAR(p.fecha_vencimiento) = 2024", nativeQuery = true)
    List<Producto> findProductosByYear2024();



}
