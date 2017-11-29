public class Network {

	private double[] weights/* = {0.1,0.3}*/;
	private double threshold;
	private double learningRate;
	private double bias = 1 * Math.random();
	//private double bias = -0.3;
	public Network(){
		//initialize weights
		weights = new double[2];
		for(int i=0;i<weights.length;i++)
		{
			weights[i] = Math.random();
		}
		threshold = 1;
		learningRate = 0.1;
	}

	public void Train(double[][] inputs, int[] outputs)
	{

		double error = 1;
		double avgError = 1;
		int it = 0;
		while(avgError > 0.1){
			avgError = 0;
			it++;
			for(int i = 0; i < outputs.length; i++){
				int act = calculateActivation(inputs[i]);
				error = outputs[i] - act;
				for(int j = 0; j < weights.length; j++){
					weights[j] += learningRate*error*inputs[i][j];
					bias += learningRate*error;
				}
				avgError += Math.abs(error);
			}
			avgError /= weights.length;
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