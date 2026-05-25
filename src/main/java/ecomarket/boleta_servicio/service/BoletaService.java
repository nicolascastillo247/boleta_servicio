package ecomarket.boleta_servicio.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ecomarket.boleta_servicio.model.BoletaFactura;
import ecomarket.boleta_servicio.repository.BoletaRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class BoletaService {

    @Autowired
    private BoletaRepository boletaRepository;

    public BoletaFactura generarDocumento(BoletaFactura documento) {
        return boletaRepository.save(documento);
    }

    public List<BoletaFactura> findAll() {
        return boletaRepository.findAll();
    }

    public BoletaFactura findById(Long id) {
        return boletaRepository.findById(id).orElse(null);
    }

    // Lógica para simular la impresión física o digital
    public String imprimirDocumento(Long id) {
        BoletaFactura doc = findById(id);
        if (doc != null) {
            return "Imprimiendo " + doc.getTipo() + " ID: " + doc.getIdGeneral() + " por un total de $" + doc.getTotal();
        }
        return "Documento no encontrado";
    }

    // Lógica para simular el envío del correo electrónico
    public boolean enviarPorEmail(Long id, String email) {
        BoletaFactura doc = findById(id);
        if (doc != null) {
            System.out.println("Enviando correo con el documento " + doc.getIdGeneral() + " a: " + email);
            return true;
        }
        return false;
    }
}