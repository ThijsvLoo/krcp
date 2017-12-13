import java.util.Random;

/**
 * Some very basic stuff to get you started. It shows basically how each
 * chromosome is built.
 * 
 * @author Jo Stevens
 * @version 1.0, 14 Nov 2008
 * 
 * @author Alard Roebroeck
 * @version 1.1, 12 Dec 2012
 * 
 */

public class Practical2 {

	static final String TARGET = "HELLO WORLD";
	static char[] alphabet = new char[27];

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int popSize = 100;
		for (char c = 'A'; c <= 'Z'; c++) {
			alphabet[c - 'A'] = c;
		}
		alphabet[26] = ' ';
		Random generator = new Random(System.currentTimeMillis());
		Individual[] population = new Individual[popSize];
		// we initialize the population with random characters
		for (int i = 0; i < popSize; i++) {
			char[] tempChromosome = new char[TARGET.length()];
			for (int j = 0; j < TARGET.length(); j++) {
				tempChromosome[j] = alphabet[generator.nextInt(alphabet.length)]; //choose a random letter in the alphabet
			}
			population[i] = new Individual(tempChromosome);
		}
		// What does your population look like?
		HeapSort.sort(population);
		for (int i = 0; i < population.length; i++) {
			System.out.println(population[i].genoToPhenotype() + " Fitness: " + population[i].getFitness());
		}

		// do your own cool GA here

		int i = 0;
		while (population[0].getFitness() != 1) {
			Individual parent1 = individualSelect(population).clone();
			Individual parent2 = individualSelect(population).clone();
			Individual child1 = crossOver(population, parent1, parent2);
			population[population.length-1] = child1;
			mutate(population);
			HeapSort.sort(population);
			i++;
		}
		for (int k = population.length-1; k >= 0; k--) {
			System.out.println(population[k].genoToPhenotype() + " Fitness: " + population[k].getFitness());
		}
		System.out.println("Number of Iterations: " + i);


		/*Individual parent1 = individualSelect(population).clone();
		Individual parent2 = individualSelect(population).clone();
		Individual child1 = crossOver(population, parent1, parent2);
		Individual child2 = crossOver(population, parent1, parent2);
		System.out.println("parent1: " + parent1.genoToPhenotype() + " Fitness: " + parent1.getFitness());
		System.out.println("parent2: " + parent2.genoToPhenotype() + " Fitness: " + parent2.getFitness());
		System.out.println("child1: " + child1.genoToPhenotype() + " Fitness: " + child1.getFitness());
		System.out.println("child2: " + child2.genoToPhenotype() + " Fitness: " + child2.getFitness());
		*/

		/**
		 * Some general programming remarks and hints:
		 * - A crucial point is to set each individual's fitness (by the setFitness() method) before sorting. When is an individual fit? 
		 * 	How do you encode that into a double (between 0 and 1)?
		 * - Decide when to stop, that is: when the algorithm has converged. And make sure you  terminate your loop when it does.
		 * - print the whole population after convergence and print the number of generations it took to converge.
		 * - print lots of output (especially if things go wrong).
		 * - work in an orderly and structured fashion (use tabs, use methods,..)
		 * - DONT'T make everything private. This will only complicate things. Keep variables local if possible
		 * - A common error are mistakes against pass-by-reference (this means that you pass the 
		 * 	address of an object, not a copy of the object to the method). There is a deepclone method included in the
		 *  Individual class.Use it!
		 * - You can compare your chromosome and your target string, using for eg. TARGET.charAt(i) == ...
		 * - Check your integers and doubles (eg. don't use ints for double divisions).
		 */
	}
	public static Individual individualSelect(Individual[] population){
		double totalFitness = 0;
		for(int i =0; i < population.length; i++){
			totalFitness += population[i].getFitness();
		}

		double tmpDouble = Math.random();
		double tmpFitness = 0;
		int i = 0;
		do {
			tmpFitness += population[i].getFitness()/ totalFitness;
			i++;
		} while(tmpFitness < tmpDouble);
		return population[i-1];
	}

	public static Individual crossOver(Individual[] population, Individual individual1, Individual individual2){
		double rand = 11 * Math.random();
		String parent1 = new String();
		String parent2 = new String();
		if(Math.random() > 0.5){
			parent1 = individual1.genoToPhenotype();
			parent2 = individual2.genoToPhenotype();
		} else {
			parent1 = individual2.genoToPhenotype();
			parent2 = individual1.genoToPhenotype();
		}
		int i = 0;
		char[] chromosome1 = new char[11];
		while(i < rand){
			chromosome1[i] = parent1.charAt(i);
			i++;
		}
		while(i < 11){
			chromosome1[i] = parent2.charAt(i);
			i++;
		}
		return new Individual(chromosome1);
	}

	public static void mutate(Individual[] population){
		double mutateChance = 0.001;
		for (char c = 'A'; c <= 'Z'; c++) {
			alphabet[c - 'A'] = c;
		}
		alphabet[26] = ' ';
		Random generator = new Random(System.currentTimeMillis());

		for (int i = 0; i < population.length; i++){
			for (int j = 0; j < 11; j++){
				double rand = Math.random();
				if (rand < mutateChance){
					String chromosome1 = population[i].genoToPhenotype();
					String newChromosome = chromosome1.substring(0,j) + alphabet[generator.nextInt(alphabet.length)] + chromosome1.substring(j + 1,11);
					char[] newerCromosome = new char[11];
					for (int k = 0; k < 11; k++){
						newerCromosome[k] = newChromosome.charAt(k);
					}
					population[i] = new Individual(newerCromosome);
				}
			}
		}
	}
}
