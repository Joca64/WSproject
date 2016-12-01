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

@OwlClass(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test2")
public class TestDois
{
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#whateverNumero2")
    @OwlDataPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test2")
    @OwlDataType(uri= "http://www.w3.org/2001/XMLSchema#int")
    private int numero;
    @OwlDataProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#whateverString2")
    @OwlDataType(uri= "http://www.w3.org/2001/XMLSchema#string")
    private String string;
    @OwlObjectProperty(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#hasTest")
    @OwlObjectPropertyDomain(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test2")
    @OwlObjectPropertyRange(domain = "http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test")
    @OwlIrreflexiveObjectProperty
    @OwlDataType(uri="http://www.semanticweb.org/joca/ontologies/2016/10/vg-ontology#Test")
    private ArrayList<TestClass> test;

    public TestDois(int numero, String string)
    {
        this.test = new ArrayList<TestClass>();
        this.numero = numero;
        this.string = string;
    }

    public void addBosta(TestClass test)
    {
        this.test.add(test);
        this.test.add(test);
        this.test.add(test);
    }
}
