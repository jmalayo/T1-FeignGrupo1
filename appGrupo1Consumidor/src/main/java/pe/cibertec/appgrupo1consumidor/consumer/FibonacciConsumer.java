package pe.cibertec.appgrupo1consumidor.consumer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pe.cibertec.appgrupo1consumidor.config.RabbitMQConfig;
import pe.cibertec.appgrupo1consumidor.service.FibonacciService;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class FibonacciConsumer {

    private FibonacciService fibonacciService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String cadenaNumeros) {

        System.out.println("Mensaje recibido de RabbitMQ: " + cadenaNumeros);

        Integer[] integerArray = Stream.of(cadenaNumeros.split(";"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        List<Integer> positions = Arrays.asList(integerArray);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        for (Integer pos : positions) {
            System.out.println("fibonacci(" + pos + ") = " + fibonacciService.fibonacci(pos));
        }

        List<Long> resultados = fibonacciService.calculateSequence(positions);
        System.out.println("Resultado: " + resultados);
        System.out.println("Procesado, fecha y hora " + LocalDateTime.now());
    }
}
