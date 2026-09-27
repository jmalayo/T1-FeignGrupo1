package pe.cibertec.appgrupo1productor.controller;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.cibertec.appgrupo1productor.config.RabbitMQConfig;

@RestController
@RequestMapping("/api/fibonacci")
@AllArgsConstructor
public class FibonacciController {

    private RabbitTemplate rabbitTemplate;

    @GetMapping("/send")
    public String sendNumbers(@RequestParam("numbers") String numbers) {
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, numbers);
        return "Lista enviada a RabbitMQ correctamente.";
    }
}
