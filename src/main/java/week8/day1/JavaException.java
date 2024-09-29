package week8.day1;

public class JavaException {

	public static void main(String[] args) {

		int[] num= {67,89,19,56,88,34};

		int a=10;
		int b=0;

		try {
			System.out.println(a/5);
		}catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(num[num.length-1]);
		}catch(Exception e) {
			System.out.println(e);
			System.out.println(a/2);
		}finally {
			System.out.println("program run successful");
		}

		System.out.println("Code completed");
	}

}
