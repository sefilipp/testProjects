
package ru.test;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.test package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SayAddResponse_QNAME = new QName("http://test.ru/", "sayAddResponse");
    private final static QName _SayAdd_QNAME = new QName("http://test.ru/", "sayAdd");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.test
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SayAdd }
     * 
     */
    public SayAdd createSayAdd() {
        return new SayAdd();
    }

    /**
     * Create an instance of {@link SayAddResponse }
     * 
     */
    public SayAddResponse createSayAddResponse() {
        return new SayAddResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayAddResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.ru/", name = "sayAddResponse")
    public JAXBElement<SayAddResponse> createSayAddResponse(SayAddResponse value) {
        return new JAXBElement<SayAddResponse>(_SayAddResponse_QNAME, SayAddResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayAdd }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://test.ru/", name = "sayAdd")
    public JAXBElement<SayAdd> createSayAdd(SayAdd value) {
        return new JAXBElement<SayAdd>(_SayAdd_QNAME, SayAdd.class, null, value);
    }

}
