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

import java.util.Iterator;

import org.jenetics.Chromosome;
import org.jenetics.util.ISeq;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public final class WrappedChromosome<A> implements Chromosome<WrappedGene<A>> {

	private final Chromosome<WrappedGene<A>> _chromosome;


	private WrappedChromosome(final Chromosome<WrappedGene<A>> chromosome) {
		_chromosome = requireNonNull(chromosome);
	}

	@Override
	public boolean isValid() {
		return _chromosome.isValid();
	}

	@Override
	public Chromosome<WrappedGene<A>> newInstance(ISeq<WrappedGene<A>> genes) {
		return new WrappedChromosome<A>(_chromosome.newInstance(genes));
	}

	@Override
	public WrappedGene<A> getGene(int index) {
		return _chromosome.getGene(index);
	}

	@Override
	public int length() {
		return _chromosome.length();
	}

	@Override
	public ISeq<WrappedGene<A>> toSeq() {
		return _chromosome.toSeq();
	}

	@Override
	public Iterator<WrappedGene<A>> iterator() {
		return _chromosome.iterator();
	}

	@Override
	public Chromosome<WrappedGene<A>> newInstance() {
		return new WrappedChromosome<A>(_chromosome.newInstance());
	}

}
