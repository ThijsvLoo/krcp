public class Main {

	public static void main(String[] args) {
		double[][] input = {{0,0},{0,1},{1,0},{1,1}};
		int[] output = {0,0,0,1};
		Network network = new Network();
		network.Train(input, output);
		for (int i = 0; i<input.length;i++) {
			System.out.println(network.calculateActivation(input[i]) + " " + output[i]);
		}
		network.printWeigths();
	}
}