public class Network {

	private double[] weights/* = {0.1,0.3}*/;
	private double threshold;//threshold for the step function/heavyside function
	private double learningRate;
	private double bias = 1 * Math.random(); //initiate the bias weight at a random value, as the bias always outputs 1, we can kindof ignore the neuron and jsut use the weight in further calculations
	//private double bias = -0.3;
	public Network(){
		//initialize weights
		weights = new double[2];
		for(int i=0;i<weights.length;i++)
		{
			weights[i] = Math.random();
		}
		threshold = 1;
		learningRate = 0.15;
	}

	public void Train(double[][] inputs, int[] outputs)
	{
		//initialize the avarage eroor at an arbitrary value, the value does not matter as logn as it is greater thean 0.1
		double avgError = 1;
		//declare a variable
		int it = 0;
		//the training loop, keep training untill the average error is low enough
		while(avgError > 0.1){
			avgError = 0;
			it++;//increse the number of itrations
			for(int i = 0; i < outputs.length; i++){
				int act = calculateActivation(inputs[i]);
				int error = outputs[i] - act;
				for(int j = 0; j < weights.length; j++){
					weights[j] += learningRate*error*inputs[i][j];
					bias += learningRate*error;
				}
				avgError += Math.abs(error);
			}
			avgError /= weights.length;//calculate average error by taking ll the errors and dividing by the number of training samples
		}
		System.out.println(it);//print the number of iterations
	}

	public int calculateActivation(double[] inputs){
		double sum = 0.0;
		//take the sum of all the weights time the corresponding inputs
		for(int i=0;i<inputs.length;i++) {
			sum += weights[i] * inputs[i];
		}
		sum += bias;//and add the bias as well
		if(sum>threshold) {//the heavyside step function
			return 1;
		} else {
			return 0;
		}
	}
	public void printWeigths(){//print all the weights into the terminal(and the bias)
		for(int i = 0; i < weights.length; i++){
			System.out.println(weights[i]);
		}
		System.out.println(bias);
	}
}