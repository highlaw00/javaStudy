import java.util.Scanner;

class Exercise {
	private String workoutName;
	private double weight;
	private int reps;
	private int sets;

	public Exercise(String name, double w, int r, int s) {
		this.workoutName = name;
		this.weight = w;
		this.reps = r;
		this.sets = s;
	}

	public void testPrint() {
		System.out.println("Workout Name: " + this.workoutName);
		System.out.println("Weight: " + this.weight);
		System.out.println("Reps: " + this.reps);
		System.out.println("Sets: " + this.sets);
		System.out.println("Total Volume: " + (this.weight * this.reps * this.sets));

	}
}

public class VolumeCalculator {

	public static void main(String[] args) {

		Scanner s1 = new Scanner(System.in);

		System.out.println("How much did you exercise today?");

		int i = s1.nextInt();
		Exercise[] exerciseArray = new Exercise[i];
		String workoutName;
		int weight;
		int reps;
		int sets;

		for (int tmp = 0; tmp < i; tmp++) {
			System.out.println("What is the name of exercise?");
			workoutName = s1.next();
			System.out.println("How was it heavy?");
			weight = s1.nextInt();
			System.out.println("How much did you repeat in a set?");
			reps = s1.nextInt();
			System.out.println("How much did you repeat sets?");
			sets = s1.nextInt();
			exerciseArray[tmp] = new Exercise(workoutName, weight, reps, sets);
		}

		for (int tmp = 0; tmp < i; tmp++) {
			exerciseArray[tmp].testPrint();
		}
	}

}
