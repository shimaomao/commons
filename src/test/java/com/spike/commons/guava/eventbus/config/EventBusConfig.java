// package com.spike.foundation.google.guava.eventbus.config;
//
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import com.google.common.eventbus.EventBus;
// import com.spike.foundation.google.guava.eventbus.auditor.SimpleTradeAuditor;
// import com.spike.foundation.google.guava.eventbus.executor.SimpleTradeExecutor;
//
// /**
// *
// * <pre>
// * 使用Spring的依赖注入JavaConfig配置
// *
// * 或者使用组建扫描{@link @ComponentScan}
// * </pre>
// *
// * @author zhoujiagen
// *
// */
// @Configuration
// public class EventBusConfig {
//
// @Bean
// public EventBus eventBus() {
// return new EventBus();
// }
//
// @Bean
// public SimpleTradeAuditor simpleTradeAuditor() {
// return new SimpleTradeAuditor(this.eventBus());
// }
//
// @Bean
// public SimpleTradeExecutor simpleTradeExecutor() {
// return new SimpleTradeExecutor(this.eventBus());
// }
//
// }
