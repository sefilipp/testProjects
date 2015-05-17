package ru.test;

import javax.jws.WebService;


@WebService(serviceName = "CalculatorWebServiceService", portName = "CalculatorWebServicePort", endpointInterface = "ru.test.CalculatorWebService", targetNamespace = "http://test.ru/", wsdlLocation = "WEB-INF/wsdl/CalculatorWebService.wsdl")
public class CalcWS {

    public java.lang.Integer sayAdd(int arg0, int arg1) {
        return arg0 + arg1;
    }
    
}
