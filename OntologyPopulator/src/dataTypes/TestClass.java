package dataTypes;

import com.yoshtec.owl.annotations.OwlClass;
import com.yoshtec.owl.annotations.OwlDataProperty;
import com.yoshtec.owl.annotations.OwlDataType;
import com.yoshtec.owl.annotations.OwlObjectProperty;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyDomain;
import com.yoshtec.owl.annotations.dprop.OwlDataPropertyRange;
import com.yoshtec.owl.annotations.oprop.OwlIrreflexiveObjectProperty;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyDomain;
import com.yoshtec.owl.annotations.oprop.OwlObjectPropertyRange;

import java.util.ArrayList;

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test")
public class TestClass
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#whateverNumero")
    @OwlDataPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test")
    @OwlDataType(uri= "http://www.w3.org/2001/XMLSchema#anyURI")
    private String numero;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#whateverString")
    @OwlDataPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test")
    @OwlDataType(uri= "http://www.w3.org/2001/XMLSchema#string")
    private String string;
    @OwlObjectProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasTest2")
    @OwlObjectPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test")
    @OwlObjectPropertyRange(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test2")
    @OwlIrreflexiveObjectProperty
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test2")
    private ArrayList<TestDois> test2;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#whateverStrings")
    @OwlDataPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test")
    @OwlDataType(uri= "http://www.w3.org/2001/XMLSchema#string")
    private ArrayList<String> strings;

    public TestClass(String numero, String string, TestDois test2, TestDois segundo)
    {
        this.strings = new ArrayList<String>();
        strings.add("MERDA");
        strings.add("MERDA2");
        strings.add("MERDA3");
        this.test2 = new ArrayList<TestDois>();
        this.test2.add(test2);
        this.test2.add(segundo);
        this.numero = numero;
        this.string = string;
    }
}
