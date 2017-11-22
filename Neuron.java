import java.util.Random;

public class Perceptron {

	double[] weights;
	double threshold;


	public int Output(double[] input) {
		double sum = 0.0;
		for(int i=0;i<input.length;i++) {
			sum += weights[i]*input[i];
		}

		if(sum>threshold)
			return 1;
		else
			return 0;
	}

}