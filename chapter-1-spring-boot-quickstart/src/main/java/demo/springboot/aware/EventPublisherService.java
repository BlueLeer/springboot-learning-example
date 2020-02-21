package demo.springboot.aware;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

/**
 * @author lee
 * @date 2020/1/16 23:58
 */
@Service
public class EventPublisherService implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher publisher;

    /**
     * 可以看到 不用实现ResourceLoaderAware,使用自动装配也是可以的
     */
    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * bean加载的时候会自动回调,然后将值设置给成员变量publisher
     *
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }
}
