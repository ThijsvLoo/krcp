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

		double error = 1;
		double error2 = 1;
		int it = 0;
		while(error2 > 0.5){
			error2 = 0;
			it++;
			for(int i = 0; i < outputs.length; i++){
				int act = calculateActivation(inputs[i]);
				error = outputs[i] - act;
				for(int j = 0; j < weights.length; j++){
					weights[j] += learningRate*error*inputs[i][j];
					bias += learningRate*error;
				}
				error2 += Math.abs(error);
			}
		}
		System.out.println(it);
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
	public void printWeigths(){
		for(int i = 0; i < weights.length; i++){
			System.out.println(weights[i]);
		}
		System.out.println(bias);
	}
}