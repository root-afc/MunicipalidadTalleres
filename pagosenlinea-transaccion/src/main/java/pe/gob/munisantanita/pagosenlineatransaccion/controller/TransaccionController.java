package pe.gob.munisantanita.pagosenlineatransaccion.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
public class TransaccionController {


    @Value("${Niubiz.urlLibJs}")
    private String urlLibJs;


    @GetMapping("/form")
    public String  form(Model model,
                        HttpServletRequest req,
                        @RequestParam(value = "merchantId", required = false) String merchantId,
                        @RequestParam(value = "moneda", required = false) String moneda,
                        @RequestParam(value = "nombre", required = false) String nombre,
                        @RequestParam(value = "apellido", required = false) String apellido,
                        @RequestParam(value = "importe", required = false) String importe,
                        @RequestParam(value = "email", required = false) String email,
                        @RequestParam(value = "sesion", required = false) String sesion,
                        @RequestParam(value = "purchasenumber", required = false) String purchasenumber,
                        @RequestParam(value = "urltimeout", required = false) String urltimeout
                        ) {

        String urlPost = req.getScheme() + "://" + req.getServerName() + ":" + req.getServerPort() + req.getContextPath()+"/post";

        model.addAttribute("merchantId", merchantId);
        model.addAttribute("moneda", moneda);
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellido", apellido);
        model.addAttribute("importe", importe);
        model.addAttribute("email", email);
        model.addAttribute("sesion", sesion);
        model.addAttribute("purchasenumber", purchasenumber);
        model.addAttribute("urltimeout", urltimeout);
        model.addAttribute("urlpost", urlPost);
        model.addAttribute("urlLibJs", urlLibJs);
        return "home";
    }


    //@RequestMapping(value = "/post", consumes = "multipart/form-data", produces = "application/json;charset=utf-8", method = RequestMethod.POST)
    @PostMapping("/post")
    public String  post(Model model,
                        HttpServletRequest req
    ) {
        String str = (new Gson()).toJson(req.getParameterMap());
        model.addAttribute("json", str);
        return "post";

    }

}
