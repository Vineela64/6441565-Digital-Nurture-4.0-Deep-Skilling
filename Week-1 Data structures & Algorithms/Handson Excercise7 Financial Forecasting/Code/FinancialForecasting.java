import java.util.Scanner;
public class FinancialForecasting {
    public static double forecastValue(double initialInvestment, double growthRate, int years) {
        if (years == 0) {
            return initialInvestment;
        }
        return forecastValue(initialInvestment, growthRate, years - 1) * (1 + growthRate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial investment amount: ");
        double initialInvestment = scanner.nextDouble();

        System.out.print("Enter annual growth rate: ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();
        double futureValue = forecastValue(initialInvestment, growthRate, years);

        System.out.printf("Projected value after %d years: %.2f\n", years, futureValue);
        scanner.close();
    }
}
