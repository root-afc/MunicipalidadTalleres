package pe.gob.munisantanita.talleres.global.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {



/*
        Si el metodo retorna "false", no se pasa el filtro.

        Calendar calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        System.out.println(hora);
        if(hora >= apertura && hora < cierre){
            StringBuilder mensaje = new StringBuilder("Bienvenido a mi sitio web, el horario de atención es desde las ");
            mensaje.append(apertura);
            mensaje.append(" horas hasta las ");
            mensaje.append(cierre);
            mensaje.append(" horas. Gracias por su visita");
            request.setAttribute("mensaje", mensaje);
            return true;
        }

        response.sendRedirect(request.getContextPath().concat("/cerrado"));
*/

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //StringBuilder mensaje = (StringBuilder) request.getAttribute("mensaje");
        //if(modelAndView != null && handler instanceof HandlerMethod){
        //    modelAndView.addObject("horario", mensaje);
        //}
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
