public class Main {

	public static void main(String[] args) {
		int samples = 1000000;//number of training samples
		double[][] input = new double[samples][2];//create the training sample input array
		int[] output = new int[samples];//create the training sample output array
		for (int i = 0; i < samples; i++){
			//generate a random x and y coordinate
			double randX = Math.random() * 10;
			double randY = Math.random() * 10;
			int randOut;
			//fidn out which output belongs to these random x and y coordinates
			if(2*randX+1 > randY){
				randOut = 1;
			} else {
				randOut = 0;
			}
			//put the data into our training sample arrays
			input[i][0] = randX;
			input[i][1] = randY;
			output[i] = randOut;
		}
		//create a new network and train it
		Network network = new Network();
		network.Train(input, output);
		for (int i = 0; i<input.length;i++) {
			System.out.println(network.calculateActivation(input[i]) + " " + output[i]);
		}
		network.printWeigths();
	}
}