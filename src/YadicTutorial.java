import com.googlecode.yadic.*;
import decorator.AuditHandler;
import decorator.Auditor;
import decorator.BaseHandler;
import decorator.HttpHandler;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class YadicTutorial {
 
    public static void main(String[] args) throws Exception {
        Container container = new SimpleContainer();
        container.add(Engine.class);
        container.add(Wheels.class);
        container.add(Car.class);


        Car car = container.get(Car.class);

        System.out.println("Has engine: " + car.hasEngine()); // returns true
        System.out.println("Has wheels: " + car.hasWheels()); // returns true

        //Container container = new SimpleContainer();
        container.add(ReservationService.class);
        container.add(ReservationRepository.class, DBReservationRepository.class);

        ReservationRepository repository = container.get(ReservationRepository.class);
        repository.reserve(new Room());


        container.addInstance(ScheduledExecutorService.class, Executors.newScheduledThreadPool(5));

        container.add(DBConfig.class);
        container.addActivator(DB.class, DBActivator.class);
        DB db = container.getActivator(DB.class).call();
        System.out.println(db);
        container.replace(DB.class, InMemoryDB.class);
        DB db2 = container.get(DB.class);
        System.out.println(db2);

        if(!container.contains(NotContain.class)){
            container.add(NotContain.class);
        }

        if(container.contains(NotContain.class)){
            System.out.println("sucessfuly added to container : " + container.get(NotContain.class));
        }
        container.add(HttpHandler.class, BaseHandler.class);
        container.add(Auditor.class); // required by the AuditHandler
        System.out.println(container.get(HttpHandler.class) instanceof AuditHandler); // true
        container.decorate(HttpHandler.class, AuditHandler.class);
        System.out.println(container.get(HttpHandler.class) instanceof AuditHandler); // true






    }
}