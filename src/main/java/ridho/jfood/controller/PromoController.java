package ridho.jfood.controller;

import ridho.jfood.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * class PromoController
 * @author Ridho Gani
 * @version 6/6/2020
 */

@RequestMapping("/promo")
@CrossOrigin(origins = "*", allowedHeaders = "")
@RestController
public class PromoController {

    /**
     * Get database promo
     * @return DatabasePromoPostgre.getDatabasePromo()
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ArrayList<Promo> getAllPromo() {
        return DatabasePromoPostgre.getDatabasePromo();
    }

    /**
     * Get database promo by promo code
     * @param code promo code
     * @return DatabasePromoPostgre.getPromo(code)
     */
    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public Promo getPromoByCode(@PathVariable String code) {
        return DatabasePromoPostgre.getPromo(code);
    }

    /**
     * Add promo
     * @param code promo code
     * @param discount discount
     * @param minPrice minimum price
     * @param active promo status
     * @return DatabasePromoPostgre.insertPromo(code, discount, minPrice, active)
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Promo addPromo(@RequestParam(value="code") String code,
                          @RequestParam(value="discount") int discount,
                          @RequestParam(value="minPrice") int minPrice,
                          @RequestParam(value="active") boolean active) {
        return DatabasePromoPostgre.insertPromo(code, discount, minPrice, active);
    }

}
