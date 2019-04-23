package com.wind.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    
    /**
     * 申明distribu队列
     * 
     * @return
     */
    @Bean
    public Queue DistribuQueue() {
        return new Queue("distribu");
    }

    @Bean
    public Queue hello() {
	return new Queue("hello");
    }

    @Bean
    public Queue user() {
	return new Queue("user");
    }

    @Bean
    public Queue queueMessage() {
	return new Queue("topic.message");
    }

    @Bean
    public Queue queueMessages() {
	return new Queue("topic.messages");
    }

    @Bean
    TopicExchange topicExchange() {
	return new TopicExchange("topicExchange");
    }

    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     * 
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueMessage, TopicExchange topicExchange) {
	return BindingBuilder.bind(queueMessage).to(topicExchange).with("topic.message");
    }

    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     * 
     * @param queueMessage
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange topicExchange) {
	return BindingBuilder.bind(queueMessages).to(topicExchange).with("topic.#");
    }

    // ===============以上是验证topic Exchange的队列和交互机==========

    // ===============以下是验证Fanout Exchange的队列和交互机==========

    @Bean
    public Queue fanoutQueueA() {
	return new Queue("fanout.A");
    }

    @Bean
    public Queue fanoutQueueB() {
	return new Queue("fanout.B");
    }

    @Bean
    public Queue fanoutQueueC() {
	return new Queue("fanout.C");
    }
    
    @Bean
    public Queue fanoutQueueD() {
	return new Queue("fanout.D");
    }

    @Bean
    FanoutExchange fanoutExchange() {
	return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingExchangeA(Queue fanoutQueueA, FanoutExchange fanoutExchange) {
	return BindingBuilder.bind(fanoutQueueA).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue fanoutQueueB, FanoutExchange fanoutExchange) {
	return BindingBuilder.bind(fanoutQueueB).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue fanoutQueueC, FanoutExchange fanoutExchange) {
	return BindingBuilder.bind(fanoutQueueC).to(fanoutExchange);
    }
    
    @Bean
    Binding bindingExchangeD(Queue fanoutQueueD, FanoutExchange fanoutExchange) {
	return BindingBuilder.bind(fanoutQueueD).to(fanoutExchange);
    }

    // ===============以上是验证Fanout Exchange的队列和交互机==========

    // ===============以下是验证Direct Exchange的队列和交互机==========
    @Bean
    public Queue directQueueA() {
	return new Queue("direct.A");
    }

    @Bean
    public Queue directQueueB() {
	return new Queue("direct.B");
    }

    @Bean
    public Queue directQueueC() {
	return new Queue("direct.C");
    }

    @Bean
    DirectExchange directExchange() {
	return new DirectExchange("directExchange");
    }

    @Bean
    Binding bindingDirectExchangeA(Queue directQueueA, DirectExchange directExchange) {
	return BindingBuilder.bind(directQueueA).to(directExchange).with("direct.a");
    }

    @Bean
    Binding bindingDirectExchangeB(Queue directQueueB, DirectExchange directExchange) {
	return BindingBuilder.bind(directQueueB).to(directExchange).with("direct.b");
    }

    @Bean
    Binding bindingDirectExchangeC(Queue directQueueC, DirectExchange directExchange) {
	return BindingBuilder.bind(directQueueC).to(directExchange).with("direct.c");
    }

    // ===============以上是验证Direct Exchange的队列和交互机==========

    // ===============以下是验证Headers Exchange的队列和交互机==========

    @Bean
    public Queue headersQueueA() {
	return new Queue("headers.A");
    }

    @Bean
    HeadersExchange headersExchange() {
	return new HeadersExchange("headersExchange");
    }

    @Bean
    Binding bindingHeadersExchangeA(Queue headersQueueA, HeadersExchange headersExchange) {
	// 这里x-match有两种类型
	// all:表示所有的键值对都匹配才能接受到消息
	// any:表示只要有键值对匹配就能接受到消息
	return BindingBuilder.bind(headersQueueA).to(headersExchange).where("age").exists();
    }

}
