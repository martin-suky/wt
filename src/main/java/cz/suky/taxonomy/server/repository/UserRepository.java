package cz.suky.taxonomy.server.repository;

import cz.suky.taxonomy.server.entity.User;

/**
 * Created by none_ on 03/13/16.
 */
public interface UserRepository extends AbstractEntityRepository<User> {

    User findByUsernameAndPassword(String username, String password);
}
