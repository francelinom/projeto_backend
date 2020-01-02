package com.ufrn.eaj.demo.services;

import com.ufrn.eaj.demo.domain.Pedido;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {

    void sendOrderConfirmationEmail(Pedido obj);

    void sendEmail(SimpleMailMessage msg);


}
