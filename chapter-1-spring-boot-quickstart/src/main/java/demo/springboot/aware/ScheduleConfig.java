package demo.springboot.aware;

import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

/**
 * @author lee
 * @date 2020/1/17 0:18
 */
@Configuration
@EnableScheduling
public class ScheduleConfig implements SchedulingConfigurer {
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(5));
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void sayHello() {
        System.out.println(Thread.currentThread().getName() + ">>>hello" + System.currentTimeMillis());
    }

    @Scheduled(cron = "0/5 * * * * ?")
    public void sayBye() {
        System.out.println(Thread.currentThread().getName() + ">>>bye" + System.currentTimeMillis());
    }
}
