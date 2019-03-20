package com.jxy.remoteService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.remoting.caucho.HessianServiceExporter;
import org.springframework.remoting.httpinvoker.HttpInvokerServiceExporter;
import org.springframework.remoting.rmi.RmiServiceExporter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;

import java.util.Properties;

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

  /*  @Bean
    public HttpInvokerServiceExporter httpInvokerServiceExporter(HttpRemoteService remoteService) {
        HttpInvokerServiceExporter exporter = new HttpInvokerServiceExporter();
        exporter.setServiceInterface(HttpRemoteService.class);
        exporter.setService(remoteService);
        return exporter;
    }*/

    @Bean
    public HessianServiceExporter hessianServiceExporter(HessionRemoteService hessionRemoteService) {
        HessianServiceExporter exporter = new HessianServiceExporter();
        exporter.setService(hessionRemoteService);
        exporter.setServiceInterface(HessionRemoteService.class);
        return exporter;
    }
    @Bean
    public HandlerMapping handlerMapping(){
        SimpleUrlHandlerMapping mapping=new SimpleUrlHandlerMapping();
        Properties properties=new Properties();
        properties.setProperty("/rpc/hessianService.service","hessianServiceExporter");
        mapping.setMappings(properties);
        return mapping;
    }
}
