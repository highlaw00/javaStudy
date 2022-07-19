import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

class WendlerWriter {
	private int weekNum;
	private Exercise workout;

	public WendlerWriter(Exercise e, int w) {
		this.weekNum = w;
		this.workout = e;
	}

	public void recordTraining() throws IOException {
		// write about training.
		FileWriter fout = new FileWriter(
				new File("C:\\Users\\choiy\\OneDrive\\바탕 화면\\WendlerWriterTest\\" + this.workout.getName() + ".txt"),
				true);
		LocalDate dateRaw = LocalDate.now();
		String dateString = dateRaw.toString();
		double[] weightArray = this.workout.getWeight();
		int[] repsArray = this.workout.getReps();
		double volume = this.workout.getVolume();
		String weekString = this.weekNum + "주차 " + this.workout.getName() + " 결과\n";
		String totalVolumeString = "총 볼륨: " + volume + "kg\n\n";
		String writtenDateString = "작성 날짜: " + dateString + "\n";
		String workoutContentString = null;

		fout.write(weekString);
		fout.write(writtenDateString);
		for (int i = 0; i < 3; i++) {
			workoutContentString = "본세트 " + (i + 1) + ": " + weightArray[i] + "kg * " + repsArray[i] + "\n";
			fout.write(workoutContentString);
		}
		fout.write(totalVolumeString);

		// 추후에는 sst, fst, bbb, joker등도 기입합니다.
		fout.close();
	}
}

class Exercise {
	private String workoutName;
	private double[] weight = new double[3];
	private int[] reps = new int[3];
	private double volume;

	public Exercise(String name, double[] w, int[] r) {
		this.workoutName = name;
		this.weight = w;
		this.reps = r;
		this.volume = weight[0] * reps[0] + weight[1] * reps[1] + weight[2] * reps[2];
	}

	public String getName() {
		return this.workoutName;
	}

	public double[] getWeight() {
		return this.weight;
	}

	public int[] getReps() {
		return this.reps;
	}

	public double getVolume() {
		return this.volume;
	}
}

public class VolumeCalculatorWendler {
	private static String[] MainWorkoutNames = new String[] { "Squat", "Bench Press", "Deadlift", "Ohp" };
	private static int week;
	private static String workoutName = "";
	private static double[] weights = new double[3];
	private static int[] reps = new int[3];
	
	public static void inputWeek() {
		Scanner sc = new Scanner(System.in);
		System.out.print("What week is this week?: ");
		week = sc.nextInt();
	}

	public static void inputWorkoutName() {
		Scanner sc = new Scanner(System.in);
		System.out.print("What was today's main workout?: ");
		workoutName = sc.nextLine();
		boolean isNameInArray = !Arrays.asList(MainWorkoutNames).contains(workoutName);
		while (isNameInArray) {
			System.out.println("An incorrect value was entered.");
			System.out.print("What was today's main workout?: ");
			workoutName = sc.nextLine();
			isNameInArray = !Arrays.asList(MainWorkoutNames).contains(workoutName);
		}
	}

	public static void inputWorkoutWeight() {
		Scanner sc = new Scanner(System.in);
		

		System.out.println("Enter the weights and reps that you trained in order.");
		System.out.println("For example, if you lifted 150 * 5, 160 * 3, 170 * 1" + "\n>>> 150 5 160 3 170 1");
		System.out.print(">>> ");
		for (int i = 0; i < 3; i++) {
			weights[i] = sc.nextDouble();
			reps[i] = sc.nextInt();
		}
	}

	public static void main(String[] args) throws IOException {
		inputWeek();
		inputWorkoutName();
		inputWorkoutWeight();
		
		Exercise ex = new Exercise(workoutName, weights, reps);
		WendlerWriter ww = new WendlerWriter(ex, week);
		ww.recordTraining();
	}

}
