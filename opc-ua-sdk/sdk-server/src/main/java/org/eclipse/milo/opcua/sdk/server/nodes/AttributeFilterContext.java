/*
 * Copyright (c) 2019 the Eclipse Milo Authors
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package org.eclipse.milo.opcua.sdk.server.nodes;

import java.util.Iterator;
import java.util.Optional;

import org.eclipse.milo.opcua.sdk.server.Session;
import org.eclipse.milo.opcua.stack.core.AttributeId;

public class AttributeFilterContext {

    private Iterator<AttributeFilter> filterIterator;

    private final UaNode node;
    private final Session session;

    AttributeFilterContext(Session session, UaNode node, Iterator<AttributeFilter> filterIterator) {
        this.session = session;
        this.node = node;
        this.filterIterator = filterIterator;
    }

    /**
     * Get the {@link UaNode} an attribute is being get from or set on.
     *
     * @return the {@link UaNode} an attribute is being get from or set on.
     */
    public UaNode getNode() {
        return node;
    }

    /**
     * Get the {@link Session} this the attribute get or set request is originating from, if there is one.
     * <p>
     * No session indicates the call is internal and should not fail for access / authentication reasons.
     *
     * @return the {@link Session} this the attribute get or set request is originating from, if there is one.
     */
    public Optional<Session> getSession() {
        return Optional.ofNullable(session);
    }

    public Object getAttribute(AttributeId attributeId) {
        AttributeFilter next = filterIterator.hasNext() ?
            filterIterator.next() :
            AttributeFilter.DEFAULT_INSTANCE;

        return next.getAttribute(this, attributeId);
    }

    public void setAttribute(AttributeId attributeId, Object value) {
        AttributeFilter next = filterIterator.hasNext() ?
            filterIterator.next() :
            AttributeFilter.DEFAULT_INSTANCE;

        next.setAttribute(this, attributeId, value);
    }

}
