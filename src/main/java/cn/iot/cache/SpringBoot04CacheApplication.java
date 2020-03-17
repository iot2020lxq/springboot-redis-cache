package cn.iot.cache;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan(basePackages= {"cn.iot.cache.mapper"})//扫描mapper
@SpringBootApplication
@EnableCaching	//开启缓存
public class SpringBoot04CacheApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04CacheApplication.class, args);
	}

}
