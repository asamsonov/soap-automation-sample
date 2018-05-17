import calculator.wsdl.AddResponse;

public class Application {

    public static void main(String[] args) {
        CalcClient client = new CalcClient();
        AddResponse addResult = client.add(1, 2);
        System.out.println("");
    }
}