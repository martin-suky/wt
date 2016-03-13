package cz.suky.taxonomy.server.api;

import cz.suky.taxonomy.server.entity.Ping;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * User: msoukup
 * Date: 2/11/2016
 * Time: 22:27
 */
@RestController
@RequestMapping("/api/ping")
public class PingController {

    @RequestMapping(method = RequestMethod.GET)
    public Ping getPing() {
        return new Ping();
    }

}
