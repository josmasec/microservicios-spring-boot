package com.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
	
	@Override
	public boolean shouldFilter() {
		// Para validaciones: Si existe algun parametro en la ruta, usuario autenticado ...
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		log.info("Entrando a post filter");
		
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;
		
		log.info(String.format("Tiempo transcurrido %s segundos", tiempoTranscurrido.doubleValue() / 1000.00));
		log.info(String.format("Tiempo transcurrido en milisegundos %s ms", tiempoTranscurrido.doubleValue() / 1000.00));
		return null;
	}

	@Override
	public String filterType() {
		// Siempre se llama así: Palabra clave
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
