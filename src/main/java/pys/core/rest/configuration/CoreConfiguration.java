package pys.core.rest.configuration;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "pys.core.rest.extern.client")
@PropertySource("classpath:config/factura.properties")
public class CoreConfiguration {

}
