import calculator.wsdl.Add;
import calculator.wsdl.AddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalcClient extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(CalcClient.class);

    public AddResponse add(int arg1, int arg2) {
        Add request = new Add();
        request.setIntA(arg1);
        request.setIntB(arg2);
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("calculator.wsdl");
        getWebServiceTemplate().setMarshaller(marshaller);
        getWebServiceTemplate().setUnmarshaller(marshaller);
        return (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://www.dneonline.com/calculator.asmx",
                        request, new SoapActionCallback("http://tempuri.org/Add"));
    }
}
