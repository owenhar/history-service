package edu.iu.harriowe.historyservice.rabbitmq;

import com.google.gson.Gson;
import edu.iu.harriowe.historyservice.model.PrimesRecord;
import edu.iu.harriowe.historyservice.repository.PrimesHistoryRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class MQReciever {

    private final PrimesHistoryRepository primesHistoryRepository;
    public MQReciever(PrimesHistoryRepository primesHistoryRepository) {
        this.primesHistoryRepository = primesHistoryRepository;
    }

    @RabbitListener(queues = {"primes"})
    public void recieveMessage(@Payload String message) {
        System.out.println(message);
        Gson gson = new Gson();
        PrimesRecord primesRecord = gson
                .fromJson(message, PrimesRecord.class);
        primesHistoryRepository.save(primesRecord);
    }
}
