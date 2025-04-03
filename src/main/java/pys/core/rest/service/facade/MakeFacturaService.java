package pys.core.rest.service.facade;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pys.core.rest.kotlin.model.ClienteMovimiento;
import pys.core.rest.service.ClienteMovimientoService;

import java.util.ArrayList;
import java.util.Objects;

@Service
@Slf4j
public class MakeFacturaService {

    private final FacturaPdfService facturaPdfService;
    private final ClienteMovimientoService clienteMovimientoService;
    private final JavaMailSender javaMailSender;

    public MakeFacturaService(FacturaPdfService facturaPdfService, ClienteMovimientoService clienteMovimientoService, JavaMailSender javaMailSender) {
        this.facturaPdfService = facturaPdfService;
        this.clienteMovimientoService = clienteMovimientoService;
        this.javaMailSender = javaMailSender;
    }

    public String send(Long clienteMovimientoId, String email) throws MessagingException {
        // Genera PDF
        String filenameFactura = facturaPdfService.generatePdf(clienteMovimientoId);
        log.info("filenameFactura -> {}", filenameFactura);
        if (filenameFactura.isEmpty()) {
            return "ERROR: Sin Factura para ENVIAR";
        }

        ClienteMovimiento clienteMovimiento = clienteMovimientoService.findByClienteMovimientoId(clienteMovimientoId);

        String data = getTextForEmail();

        // Envia correo
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        var addresses = new ArrayList<String>();
        var addresses_bcc = new ArrayList<String>();

        if (!Objects.requireNonNull(clienteMovimiento.getCliente()).getEmail().isEmpty()) {
            addresses.add(clienteMovimiento.getCliente().getEmail());
        }
        if (!email.isEmpty()) {
            addresses.add(email);
        }

        addresses_bcc.add("daniel.quinterospinto@gmail.com");

        try {
            helper.setTo(addresses.toArray(new String[0]));
            helper.setBcc(addresses_bcc.toArray(new String[0]));
            helper.setText(data);
            helper.setReplyTo("no-reply@gmail.com");
            helper.setSubject("Envío Automático de Comprobante -> " + filenameFactura);

            FileSystemResource fileRecibo = new FileSystemResource(filenameFactura);
            helper.addAttachment(filenameFactura, fileRecibo);

        } catch (MessagingException e) {
            return "Error envío";
        }
        javaMailSender.send(message);
        return "Envío de correo Ok";
    }

    @NotNull
    private static String getTextForEmail() {
        String data = "Estimad@ cliente:" + (char) 10;
        data = data + (char) 10;
        data = data + "Le enviamos como archivo adjunto su comprobante." + (char) 10;
        data = data + (char) 10;
        data = data + "Atentamente." + (char) 10;
        data = data + (char) 10;
        data = data + (char) 10
                + "Por favor no responda este mail, fue generado automáticamente. Su respuesta no será leída."
                + (char) 10;
        return data;
    }

}
