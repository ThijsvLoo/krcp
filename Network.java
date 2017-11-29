import java.util.Random;

public class Network {

	private double[] weights;
	private double threshold;
	private Random r = new Random();
	private double learningRate;
	private double bias = Math.random();
	public Network(){
		//initialize weights
		weights = new double[2];
		for(int i=0;i<weights.length;i++)
		{
			weights[i] = Math.random();
		}

		threshold = 1;
		learningRate = 0.05;
	}

	public void Train(double[][] inputs, int[] outputs)
	{
		int n = inputs[0].length;
		int p = outputs.length;

		double error = 1;
		while(error > 0){
			for(int i = 0; i < outputs.length; i++){
				int act = calculateActivation(inputs[i]);
				error = outputs[i] - act;
				for(int j = 0; j < weights.length; j++){
					weights[j] += learningRate*error*inputs[i][j];
					bias += learningRate*error;
				}
			}
		}
	}

	public int calculateActivation(double[] inputs){
		double sum = 0.0;
		for(int i=0;i<inputs.length;i++) {
			sum += weights[i] * inputs[i];
		}
		sum += bias;
		if(sum>threshold)
			return 1;
		else
			return 0;
	}
}