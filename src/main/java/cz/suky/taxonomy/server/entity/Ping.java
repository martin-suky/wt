package cz.suky.taxonomy.server.entity;

import java.util.Date;

/**
 * User: msoukup
 * Date: 2/11/2016
 * Time: 22:42
 */
public class Ping {
    private String name;
    private Date date;

    public Ping() {
        this.name = "World of Taxonomy";
        date = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(final Date date) {
        this.date = date;
    }
}
