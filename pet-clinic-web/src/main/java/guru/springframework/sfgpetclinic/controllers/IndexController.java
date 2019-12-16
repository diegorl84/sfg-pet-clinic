package guru.springframework.sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author diego
 * @since 08/12/2019
 */
@Controller
public class IndexController {


    @RequestMapping({"", "/", "index", "index.html"})
    public String index() {
        return "index";
    }
}
