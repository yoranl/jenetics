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

import org.testng.annotations.Test;

import org.jenetics.DoubleChromosome;
import org.jenetics.Genotype;
import org.jenetics.IntegerChromosome;
import org.jenetics.Mutator;
import org.jenetics.engine.Engine;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 */
public class WrappedChromosomeTest {

	static double fitness(final Genotype<WrappedGene<Number>> gene) {
		return 1;
	}

	@Test
	public void create() {
		final Genotype<WrappedGene<Number>> gt = Genotype.of(
			WrappedChromosome.of(DoubleChromosome.of(0.0, 10.0, 5)),
			//new WrappedChromosome<>(CharacterChromosome.of(4)),
			WrappedChromosome.of(IntegerChromosome.of(0, 10, 5))
		);

		final Engine<WrappedGene<Number>, Double> engine = Engine
			.builder(WrappedChromosomeTest::fitness, gt)
			.alterers(new Mutator<>())
			.build();

	}

}
