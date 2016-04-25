package br.com.juniorsite.mvc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
