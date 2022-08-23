package com.mikes.mail;

import com.mikes.server.pojo.MailConstants;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;


/**
 * @author mikes
 * @date 2021/7/21 12:51
 * @param
 * @return
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MailApplication {
    public static void main(String[] args){
        SpringApplication.run(MailApplication.class,args);
    }


    @Bean
    public Queue queue(){
        return new Queue(MailConstants.MAIL_QUEUE_NAME);
    }
}
