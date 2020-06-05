/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2019 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.jpeek.graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Graph node description. It should at least provide its name and its neighbors.
 * @since 0.30.9
 */
public interface Node {

    /**
     * Node name.
     * @return A identifier for the node
     */
    String name();

    /**
     * Calculates ingoing and outgoing connected nodes.
     * @return List of nodes connected to this node.
     */
    Set<Node> connections();

    /**
     * Simple implementation.
     * @since 0.30.9
     */
    final class Simple implements Node {
        /**
         * Node name.
         */
        private final String name;

        /**
         * Nodes connected to this node.
         */
        private final Set<Node> connect;

        /**
         * Ctor.
         * @param name Node name
         */
        public Simple(final String name) {
            this.name = name;
            this.connect = new HashSet<Node>(1);
        }

        @Override
        public String name() {
            return this.name;
        }

        @Override
        public Set<Node> connections() {
            return this.connect;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }
}
