package com.grupo4.ritapop;
import com.grupo4.ritapop.model.core.service.VipClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@SpringBootApplication
@EnableScheduling
public class ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerApplication.class, args);
		CallVipClientService();
	}
	@Scheduled(fixedRate = 3000)
	private static void CallVipClientService(){
		VipClientService vipClientService = new VipClientService();
		vipClientService.callVipClientService();
	}
}