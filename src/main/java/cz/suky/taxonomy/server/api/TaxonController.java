package cz.suky.taxonomy.server.api;

import cz.suky.taxonomy.server.entity.Taxon;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by none_ on 03/14/16.
 */
@RestController
@RequestMapping("/api/taxon")
public class TaxonController {

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> saveTaxon(@RequestBody Taxon taxon) {
        return ResponseEntity.ok().build();
    }
}
