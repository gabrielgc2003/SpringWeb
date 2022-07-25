package com.example.projetin.SpringWeb.Servico.Autenticacao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.example.projetin.SpringWeb.Servico.CookieService;

@Component
public class LoginInterceptor implements HandlerInterceptor{
      @Override
      public boolean preHandle
      (HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception{
            if(CookieService.getCookie(request,"usuariosId") != null){
                  return true;
            }
            response.sendRedirect("/login");
            return false;
            
      }
      // @Override
      // public void postHandle
      // (HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception{

      // }
      // @Override
      // public void afterCompletion
      // (HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{

      // }
}
