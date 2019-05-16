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

import org.eclipse.milo.opcua.stack.core.AttributeId;

public interface AttributeFilter {

    /**
     * A shared instance of {@link DefaultAttributeFilter}.
     */
    DefaultAttributeFilter DEFAULT_INSTANCE = new DefaultAttributeFilter();

    /**
     * Get the value for the attribute identified by {@code attributeId} or delegate to the next filter in the chain.
     *
     * @param ctx         the {@link AttributeFilterContext}.
     * @param attributeId the {@link AttributeId} of the attribute to get the value of.
     * @return the value for the attribute identified by {@code attributeId}.
     * @see AttributeFilterContext#getAttribute(AttributeId)
     */
    default Object getAttribute(AttributeFilterContext ctx, AttributeId attributeId) {
        return ctx.getAttribute(attributeId);
    }

    /**
     * Set the value for the attribute identified by {@code attributeId} or delegate to the next filter in the chain.
     *
     * @param ctx         the {@link AttributeFilterContext}.
     * @param attributeId the {@link AttributeId} of the attribute to set the value of.
     * @param value       the value to set.
     * @see AttributeFilterContext#setAttribute(AttributeId, Object)
     */
    default void setAttribute(AttributeFilterContext ctx, AttributeId attributeId, Object value) {
        ctx.setAttribute(attributeId, value);
    }

}
