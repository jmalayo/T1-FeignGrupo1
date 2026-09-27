package pe.cibertec.appgrupo1consumidor.consumer;

import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pe.cibertec.appgrupo1consumidor.config.RabbitMQConfig;
import pe.cibertec.appgrupo1consumidor.service.FibonacciService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@AllArgsConstructor
public class FibonacciConsumer {

    private FibonacciService fibonacciService;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String cadenaNumeros) {

        Integer[] integerArray = Stream.of(cadenaNumeros.split(";"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        List<Integer> positions = Arrays.asList(integerArray);

        List<Long> resultados = fibonacciService.calculateSequence(positions);

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Resultado Fibonacci: " + resultados);
    }
}
