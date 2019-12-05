package com.devglan.springbootrabbitmq.web;

import com.devglan.springbootrabbitmq.payload.MyMessage;
import com.devglan.springbootrabbitmq.config.Producer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class Controller {

	private Producer producer;

	public Controller(Producer producer) {
		this.producer = producer;
	}

	@PostMapping
	public void register(@RequestBody MyMessage myMessage){
		producer.sendMessage(myMessage);
	}
}
