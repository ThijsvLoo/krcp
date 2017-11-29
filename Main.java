public class Main {

	public static void main(String[] args) {
		int samples = 1000;
		double[][] input = new double[samples][];
		int[] output = new int[samples];
		for (int i = 0; i < samples; i++){
			double randX = Math.random() * 4;
			double randY = Math.random() * 4;
			int randOut;
			if(2*randX+1 > randY){
				randOut = 1;
			} else {
				randOut = 0;
			}
			input[i][1] = randX;
			input[i][2] = randY;
			output[i] = randOut;
		}

		Network network = new Network();
		network.Train(input, output);
		for (int i = 0; i<input.length;i++) {
			System.out.println(network.calculateActivation(input[i]) + " " + output[i]);
		}
		network.printWeigths();
	}
}