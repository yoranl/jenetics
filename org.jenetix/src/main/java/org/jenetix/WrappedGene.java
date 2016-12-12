/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetix;

import static java.util.Objects.requireNonNull;

import org.jenetics.Gene;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public final class WrappedGene<A> implements Gene<A, WrappedGene<A>> {

	private final Gene<A, ?> _gene;

	private WrappedGene(final Gene<A, ?> gene) {
		_gene = requireNonNull(gene);
	}

	public Gene<A, ?> unwrap() {
		return _gene;
	}

	@Override
	public boolean isValid() {
		return _gene.isValid();
	}

	@Override
	public A getAllele() {
		return _gene.getAllele();
	}

	@Override
	public WrappedGene<A> newInstance() {
		return of(_gene.newInstance());
	}

	@Override
	public WrappedGene<A> newInstance(final A value) {
		return of(_gene.newInstance(value));
	}

	public static <A> WrappedGene<A> of(final Gene<A, ?> gene) {
		return new WrappedGene<A>(gene);
	}

}
