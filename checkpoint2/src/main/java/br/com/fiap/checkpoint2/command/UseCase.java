package br.com.fiap.checkpoint2.command;

import java.util.Map;

import org.springframework.stereotype.Service;

public interface UseCase {
	
	Map<String, Object> executar(Map<String, Object> dados);

}
