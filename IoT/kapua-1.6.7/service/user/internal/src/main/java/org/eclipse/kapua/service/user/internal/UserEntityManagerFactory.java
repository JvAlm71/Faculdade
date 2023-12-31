/*******************************************************************************
 * Copyright (c) 2016, 2022 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.user.internal;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.kapua.commons.jpa.AbstractEntityManagerFactory;
import org.eclipse.kapua.commons.jpa.EntityManager;
import org.eclipse.kapua.commons.jpa.EntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Entity manager factory for the user module.
 *
 * @since 1.0
 *
 */
public class UserEntityManagerFactory extends AbstractEntityManagerFactory implements EntityManagerFactory {

    @SuppressWarnings("unused")
    private static final Logger LOG = LoggerFactory.getLogger(UserEntityManagerFactory.class);

    private static final String PERSISTENCE_UNIT_NAME = "kapua-user";
    private static final String DATASOURCE_NAME = "kapua-dbpool";
    private static final Map<String, String> UNIQUE_CONSTRAINTS = new HashMap<>();

    private static UserEntityManagerFactory instance = new UserEntityManagerFactory();

    /**
     * Constructs a new entity manager factory and configure it to use the user persistence unit.
     */
    private UserEntityManagerFactory() {
        super(PERSISTENCE_UNIT_NAME, DATASOURCE_NAME, UNIQUE_CONSTRAINTS);
    }

    /**
     * Return the {@link EntityManager} singleton instance
     *
     * @return
     */
    public static UserEntityManagerFactory getInstance() {
        return instance;
    }
}
