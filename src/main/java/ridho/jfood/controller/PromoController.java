package ridho.jfood.controller;

import ridho.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RequestMapping("/promo")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
public class PromoController {
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromoPostgre.getDatabasePromo();
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        return DatabasePromoPostgre.getPromo(code);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                          @RequestParam(value="discount") int discount,
                          @RequestParam(value="minPrice") int minPrice,
                          @RequestParam(value="active") boolean active) {
        return DatabasePromoPostgre.insertPromo(code, discount, minPrice, active);
    }

}
