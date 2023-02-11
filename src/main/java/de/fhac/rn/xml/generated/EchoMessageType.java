//
// Ce fichier a été généré par l'implémentation de référence JavaTM Architecture for XML Binding (JAXB), v2.3.2 
// Voir <a href="https://javaee.github.io/jaxb-v2/">https://javaee.github.io/jaxb-v2/</a> 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2020.06.15 à 10:48:46 AM WEST 
//


package de.fhac.rn.xml.generated;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour EchoMessageType.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * <p>
 * <pre>
 * &lt;simpleType name="EchoMessageType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DEFAULT"/&gt;
 *     &lt;enumeration value="BROADCAST"/&gt;
 *     &lt;enumeration value="EXIT"/&gt;
 *     &lt;enumeration value="SHOWSTAT"/&gt;
 *     &lt;enumeration value="SHOWALLSTAT"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "EchoMessageType")
@XmlEnum
public enum EchoMessageType {

    DEFAULT,
    BROADCAST,
    EXIT,
    SHOWSTAT,
    SHOWALLSTAT;

    public String value() {
        return name();
    }

    public static EchoMessageType fromValue(String v) {
        return valueOf(v);
    }

}
