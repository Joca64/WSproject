
package mypackage;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mypackage package. 
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

    private final static QName _ListClassByPropertyResponse_QNAME = new QName("http://example/", "listClassByPropertyResponse");
    private final static QName _GetFranchiseInfo_QNAME = new QName("http://example/", "getFranchiseInfo");
    private final static QName _SayHelloWorldFrom_QNAME = new QName("http://example/", "sayHelloWorldFrom");
    private final static QName _SayHelloWorldFromNoobResponse_QNAME = new QName("http://example/", "sayHelloWorldFromNoobResponse");
    private final static QName _GetGameInfoResponse_QNAME = new QName("http://example/", "getGameInfoResponse");
    private final static QName _ListGamesByTypeResponse_QNAME = new QName("http://example/", "listGamesByTypeResponse");
    private final static QName _SayHelloWorldFromNoob_QNAME = new QName("http://example/", "sayHelloWorldFromNoob");
    private final static QName _ListGamesByType_QNAME = new QName("http://example/", "listGamesByType");
    private final static QName _GetFranchiseInfoResponse_QNAME = new QName("http://example/", "getFranchiseInfoResponse");
    private final static QName _GetGamesFromPlatformResponse_QNAME = new QName("http://example/", "getGamesFromPlatformResponse");
    private final static QName _SayHelloWorldFromResponse_QNAME = new QName("http://example/", "sayHelloWorldFromResponse");
    private final static QName _GetGameInfo_QNAME = new QName("http://example/", "getGameInfo");
    private final static QName _GetCompanyInfo_QNAME = new QName("http://example/", "getCompanyInfo");
    private final static QName _GetGamesFromPlatform_QNAME = new QName("http://example/", "getGamesFromPlatform");
    private final static QName _GetCompanyInfoResponse_QNAME = new QName("http://example/", "getCompanyInfoResponse");
    private final static QName _ListClassByProperty_QNAME = new QName("http://example/", "listClassByProperty");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mypackage
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetFranchiseInfo }
     * 
     */
    public GetFranchiseInfo createGetFranchiseInfo() {
        return new GetFranchiseInfo();
    }

    /**
     * Create an instance of {@link ListClassByPropertyResponse }
     * 
     */
    public ListClassByPropertyResponse createListClassByPropertyResponse() {
        return new ListClassByPropertyResponse();
    }

    /**
     * Create an instance of {@link ListGamesByType }
     * 
     */
    public ListGamesByType createListGamesByType() {
        return new ListGamesByType();
    }

    /**
     * Create an instance of {@link GetFranchiseInfoResponse }
     * 
     */
    public GetFranchiseInfoResponse createGetFranchiseInfoResponse() {
        return new GetFranchiseInfoResponse();
    }

    /**
     * Create an instance of {@link GetGamesFromPlatformResponse }
     * 
     */
    public GetGamesFromPlatformResponse createGetGamesFromPlatformResponse() {
        return new GetGamesFromPlatformResponse();
    }

    /**
     * Create an instance of {@link SayHelloWorldFromResponse }
     * 
     */
    public SayHelloWorldFromResponse createSayHelloWorldFromResponse() {
        return new SayHelloWorldFromResponse();
    }

    /**
     * Create an instance of {@link SayHelloWorldFrom }
     * 
     */
    public SayHelloWorldFrom createSayHelloWorldFrom() {
        return new SayHelloWorldFrom();
    }

    /**
     * Create an instance of {@link SayHelloWorldFromNoobResponse }
     * 
     */
    public SayHelloWorldFromNoobResponse createSayHelloWorldFromNoobResponse() {
        return new SayHelloWorldFromNoobResponse();
    }

    /**
     * Create an instance of {@link GetGameInfoResponse }
     * 
     */
    public GetGameInfoResponse createGetGameInfoResponse() {
        return new GetGameInfoResponse();
    }

    /**
     * Create an instance of {@link ListGamesByTypeResponse }
     * 
     */
    public ListGamesByTypeResponse createListGamesByTypeResponse() {
        return new ListGamesByTypeResponse();
    }

    /**
     * Create an instance of {@link SayHelloWorldFromNoob }
     * 
     */
    public SayHelloWorldFromNoob createSayHelloWorldFromNoob() {
        return new SayHelloWorldFromNoob();
    }

    /**
     * Create an instance of {@link GetGamesFromPlatform }
     * 
     */
    public GetGamesFromPlatform createGetGamesFromPlatform() {
        return new GetGamesFromPlatform();
    }

    /**
     * Create an instance of {@link GetCompanyInfoResponse }
     * 
     */
    public GetCompanyInfoResponse createGetCompanyInfoResponse() {
        return new GetCompanyInfoResponse();
    }

    /**
     * Create an instance of {@link GetGameInfo }
     * 
     */
    public GetGameInfo createGetGameInfo() {
        return new GetGameInfo();
    }

    /**
     * Create an instance of {@link GetCompanyInfo }
     * 
     */
    public GetCompanyInfo createGetCompanyInfo() {
        return new GetCompanyInfo();
    }

    /**
     * Create an instance of {@link ListClassByProperty }
     * 
     */
    public ListClassByProperty createListClassByProperty() {
        return new ListClassByProperty();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListClassByPropertyResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "listClassByPropertyResponse")
    public JAXBElement<ListClassByPropertyResponse> createListClassByPropertyResponse(ListClassByPropertyResponse value) {
        return new JAXBElement<ListClassByPropertyResponse>(_ListClassByPropertyResponse_QNAME, ListClassByPropertyResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFranchiseInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getFranchiseInfo")
    public JAXBElement<GetFranchiseInfo> createGetFranchiseInfo(GetFranchiseInfo value) {
        return new JAXBElement<GetFranchiseInfo>(_GetFranchiseInfo_QNAME, GetFranchiseInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWorldFrom }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "sayHelloWorldFrom")
    public JAXBElement<SayHelloWorldFrom> createSayHelloWorldFrom(SayHelloWorldFrom value) {
        return new JAXBElement<SayHelloWorldFrom>(_SayHelloWorldFrom_QNAME, SayHelloWorldFrom.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWorldFromNoobResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "sayHelloWorldFromNoobResponse")
    public JAXBElement<SayHelloWorldFromNoobResponse> createSayHelloWorldFromNoobResponse(SayHelloWorldFromNoobResponse value) {
        return new JAXBElement<SayHelloWorldFromNoobResponse>(_SayHelloWorldFromNoobResponse_QNAME, SayHelloWorldFromNoobResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getGameInfoResponse")
    public JAXBElement<GetGameInfoResponse> createGetGameInfoResponse(GetGameInfoResponse value) {
        return new JAXBElement<GetGameInfoResponse>(_GetGameInfoResponse_QNAME, GetGameInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListGamesByTypeResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "listGamesByTypeResponse")
    public JAXBElement<ListGamesByTypeResponse> createListGamesByTypeResponse(ListGamesByTypeResponse value) {
        return new JAXBElement<ListGamesByTypeResponse>(_ListGamesByTypeResponse_QNAME, ListGamesByTypeResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWorldFromNoob }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "sayHelloWorldFromNoob")
    public JAXBElement<SayHelloWorldFromNoob> createSayHelloWorldFromNoob(SayHelloWorldFromNoob value) {
        return new JAXBElement<SayHelloWorldFromNoob>(_SayHelloWorldFromNoob_QNAME, SayHelloWorldFromNoob.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListGamesByType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "listGamesByType")
    public JAXBElement<ListGamesByType> createListGamesByType(ListGamesByType value) {
        return new JAXBElement<ListGamesByType>(_ListGamesByType_QNAME, ListGamesByType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetFranchiseInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getFranchiseInfoResponse")
    public JAXBElement<GetFranchiseInfoResponse> createGetFranchiseInfoResponse(GetFranchiseInfoResponse value) {
        return new JAXBElement<GetFranchiseInfoResponse>(_GetFranchiseInfoResponse_QNAME, GetFranchiseInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGamesFromPlatformResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getGamesFromPlatformResponse")
    public JAXBElement<GetGamesFromPlatformResponse> createGetGamesFromPlatformResponse(GetGamesFromPlatformResponse value) {
        return new JAXBElement<GetGamesFromPlatformResponse>(_GetGamesFromPlatformResponse_QNAME, GetGamesFromPlatformResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SayHelloWorldFromResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "sayHelloWorldFromResponse")
    public JAXBElement<SayHelloWorldFromResponse> createSayHelloWorldFromResponse(SayHelloWorldFromResponse value) {
        return new JAXBElement<SayHelloWorldFromResponse>(_SayHelloWorldFromResponse_QNAME, SayHelloWorldFromResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGameInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getGameInfo")
    public JAXBElement<GetGameInfo> createGetGameInfo(GetGameInfo value) {
        return new JAXBElement<GetGameInfo>(_GetGameInfo_QNAME, GetGameInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getCompanyInfo")
    public JAXBElement<GetCompanyInfo> createGetCompanyInfo(GetCompanyInfo value) {
        return new JAXBElement<GetCompanyInfo>(_GetCompanyInfo_QNAME, GetCompanyInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetGamesFromPlatform }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getGamesFromPlatform")
    public JAXBElement<GetGamesFromPlatform> createGetGamesFromPlatform(GetGamesFromPlatform value) {
        return new JAXBElement<GetGamesFromPlatform>(_GetGamesFromPlatform_QNAME, GetGamesFromPlatform.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetCompanyInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "getCompanyInfoResponse")
    public JAXBElement<GetCompanyInfoResponse> createGetCompanyInfoResponse(GetCompanyInfoResponse value) {
        return new JAXBElement<GetCompanyInfoResponse>(_GetCompanyInfoResponse_QNAME, GetCompanyInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ListClassByProperty }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://example/", name = "listClassByProperty")
    public JAXBElement<ListClassByProperty> createListClassByProperty(ListClassByProperty value) {
        return new JAXBElement<ListClassByProperty>(_ListClassByProperty_QNAME, ListClassByProperty.class, null, value);
    }

}
