
public class Individual {
	
	char[] chromosome;
	double fitness;
	
	public Individual(char[] chromosome) {
		this.chromosome = chromosome;
		this.fitness = setFitness();
	}


	public char[] getChromosome() {
		return chromosome;
	}

	public void setChromosome(char[] chromosome) {
		this.chromosome = chromosome;
	}

	public double getFitness() {
		return fitness;
	}

	public double setFitness() {
		char[] ownChromosome = getChromosome();
		double count = 0;
		for(int i =0; i < ownChromosome.length; i++)
		{
			if(ownChromosome[i] != Practical2.TARGET.charAt(i))
				count++;
		}
		fitness = count/11;
		return fitness;
	}


	public String genoToPhenotype() {
		StringBuilder builder = new StringBuilder();
		builder.append(chromosome);
		return builder.toString();
	}
	
	public Individual clone() {
		char[] chromClone = new char[chromosome.length];
		for(int i = 0; i < chromClone.length; i++) {
			chromClone[i] = chromosome[i];
		}
		return new Individual(chromClone);
	}
	


}
