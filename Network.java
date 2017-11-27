import java.util.Random;

public class Network {

	private double[] weights;
	private double threshold;
	private Random r = new Random();
	private double learningRate;

	public Network(){
		//initialize weights
		for(int i=0;i<3;i++)
		{
			weights[i] = r.nextDouble();
		}
		weights = new double[3];
		threshold = 1;
		learningRate = 0.2;
	}

	public void Train(double[][] inputs, int[] outputs)
	{
		int n = inputs[0].length;
		int p = outputs.length;

		double error = 1;
		while(error > 0.5){
			for(int i = 0; i < outputs.length; i++){
				int act = calculateActivation(inputs[i]);
				error = outputs[i] - act;
				for(int j = 0; j < inputs.length; j++){
					double dWeights = learningRate*error*inputs[i][j];
					weights[i] = weights[i] + dWeights;
				}
			}
		}
	}

	private int calculateActivation(double[] inputs){
		double sum = 0.0;
		for(int i=0;i<inputs.length;i++) {
			sum += weights[i]*inputs[i];
		}

		if(sum>threshold)
			return 1;
		else
			return 0;
	}
}