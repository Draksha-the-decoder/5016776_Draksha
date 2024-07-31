public class FinancialForecasting {

    public static double futureVal(double pv, double g, int p) {
        if (p == 0) {
            return pv;
        }
        return (1 + g) * futureVal(pv, g, p - 1);
    }

    public static void main(String[] args) {
        
        double pv = 2000.0; 
        double g = 0.07; 
        int p = 9; 

        double futureValue = futureVal(pv, g, p);
        System.out.println("Future Value: " + futureValue);
    }
}

// OUTPUT
// Future Value: 3676.918424840311