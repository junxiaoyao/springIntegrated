package com.jxy.remoteService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;

/**
 * @Auther: jxy
 * @Date: 2019/3/15 16:15
 * @Description:
 */
@Configuration
@ComponentScan("com.jxy.remoteService")
public class RmiServiceExporterConfig {
    @Bean
    public RmiServiceExporter rmiExporter(RmiRemoteService testRemoteService) {
        RmiServiceExporter exporter = new RmiServiceExporter();
        exporter.setService(testRemoteService);
        exporter.setServiceName("testRemoteService");
        exporter.setRegistryPort(8081);
        exporter.setServiceInterface(RmiRemoteService.class);
        return exporter;
    }

    @Bean
    public HessianServiceExporter hessianServiceExporter(HessionRemoteService hessionRemoteService) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(hessionRemoteService);
        exporter.setServiceInterface(HessionRemoteService.class);
        return exporter;
    }
}
