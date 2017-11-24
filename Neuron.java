import java.util.Random;

public class Perceptron {

	private double[] weights;
	private double threshold;
	private double threshold;
	private weights = new double[n];
	private Random r = new Random();

	public Perceptron(){
		//initialize weights
		for(int i=0;i<n;i++)
		{
			weights[i] = r.nextDouble();
		}

		threshold = 1;
	}

	public void Train(double[][] inputs, int[] outputs, double lrate,)
	{
		int n = inputs[0].length;
		int p = outputs.length;

		while(error > 0.5){
			for(i = 0; i < intputs.length; i++){

			}
		}

	}

	private int calculateActivation(int[][] inputs, ){

	}

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