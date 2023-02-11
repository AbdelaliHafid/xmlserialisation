package de.fhac.rn.xml;

import de.fhac.rn.xml.generated.EchoMessage;
import de.fhac.rn.xml.generated.EchoMessageType;
import de.fhac.rn.xml.generated.ObjectFactory;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class XMLSerialisation {
    private ObjectFactory of;
    private JAXBContext jc;
    private Marshaller marshaller;
    private Unmarshaller unmarshaller;
    private String sender;
    //EchoMessage-Objekt
    private EchoMessage object ;
    

    /**
     * Erstellt ein XMLSerialisation-Objekt, welches ein EchoMessage-Objekt in einen XML-String
     * serialisiert/deserialisiert
     * <p>
     * In der Methode werden die Klassenparameter initialisiert. Ausserdem wird der
     * formatierte Output zur besseren Lesbarkeit eingeschaltet.
     *
     * @param sender Sendername
     * @see JAXBContext, marshaller, unmarshaller
     */
    public XMLSerialisation(String sender) {
    	// intialisierung von sender
        this.sender = sender ;
        try {
        	//Erstellung von Marshaller 
        	jc = JAXBContext.newInstance(EchoMessage.class);
			marshaller = jc.createMarshaller();
			  //Erstellung von Object Factory
			 of = new ObjectFactory();
			 marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
			 object = of.createEchoMessage();
			 object.setSender(this.sender);
			 object.setType(EchoMessageType.BROADCAST);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
       
       
        
    }

    /**
     * Serialisiert das Objekt in die XML-Repraesentation.
     *
     * @param message Object das serialisiert werden soll
     * @return die XML-Repraesentation des Objekts als String
     * @see StringWriter, Marshaller.marshall()
     */
    String messageToXMLString(EchoMessage message) throws JAXBException {
        StringWriter sw = new StringWriter();
        marshaller.marshal(message,sw);
        String xmlString = sw.toString();
        
        return xmlString;
    }

    EchoMessage getNewMessage() {
        EchoMessage em = of.createEchoMessage();
        em.setSender(sender);
        em.setType(EchoMessageType.DEFAULT);
        return em;
    }

    /**
     * Deserialisiert von einem XML-String ein Objekt aus dem JAXBContext
     *
     * @param xml XML-Repraesentation eines EchoMessage-Objekts
     * @return EchoMessage-Object
     * @throws JAXBException
     * @see StringReader, Unmarshaller.unmarshall()
     */
    EchoMessage xmlStringToMessage(String xml) throws JAXBException {
    	//Erstellung von UnMarshaller
    	 unmarshaller = jc.createUnmarshaller();
        StringReader sr = new  StringReader(xml);
        EchoMessage em = (EchoMessage) unmarshaller.unmarshal(sr);
        return em;
    }
}
