package org.qingfei.glee.app;/**
 * Created by ASUS on 5/30/2018.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Entry Class For Glee
 *
 * @author Chenhaiqing
 * @create 2018-05-30 4:03 PM
 */
@SpringBootApplication
@ComponentScan(basePackages = "org.qingfei.glee")
@EnableJpaRepositories(basePackages = "org.qingfei.glee.repository")
@EntityScan("org.qingfei.glee.entity")
public class GleeApplication {

    public static void main(String[] args) {
        SpringApplication.run(GleeApplication.class,args);
    }
}
