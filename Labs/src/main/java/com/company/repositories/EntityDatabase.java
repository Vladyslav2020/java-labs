package com.company.repositories;

import java.io.IOException;
import java.util.Collection;

public interface EntityDatabase<T> {

    Collection<T> getAllEntities() throws IOException;

    void saveEntities(Collection<T> entities) throws IOException;
}
