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
package org.jenetics.example.tensorflow;

import java.nio.file.Paths;

import org.tensorflow.DataType;
import org.tensorflow.Graph;
import org.tensorflow.Output;
import org.tensorflow.Session;
import org.tensorflow.Tensor;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public class MNIST {


	public static void main(final String[] args) throws Exception {
		//System.out.println("READING");
		//final float[][] images = IDX.images(Paths.get("/home/fwilhelm/Temp/tensorflow/train-images-idx3-ubyte"));
		//final int[] labels = IDX.labels(Paths.get("/home/fwilhelm/Temp/tensorflow/train-labels-idx1-ubyte"));

		try (Graph graph = new Graph();
			 Session session = new Session(graph))
		{
			final Output x = placeholder(graph, "x", DataType.FLOAT);
		}

		//try (Tensor tensor = Tensor.create(images)) {

		//}

		System.out.println("FINISHED");
	}

	public static Output placeholder(
		final Graph graph,
		final String name,
		final DataType type
	) {
		return graph
			.opBuilder("Placeholder", name)
				.setAttr("dtype", type)
				.build()
			.output(0);
	}

}
