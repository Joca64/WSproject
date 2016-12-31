
package mypackage;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.7-b01 
 * Generated source version: 2.2
 * 
 */
@WebService(name = "GameOntologyServer", targetNamespace = "http://example/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface GameOntologyServer {


    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getGameInfo", targetNamespace = "http://example/", className = "mypackage.GetGameInfo")
    @ResponseWrapper(localName = "getGameInfoResponse", targetNamespace = "http://example/", className = "mypackage.GetGameInfoResponse")
    @Action(input = "http://example/GameOntologyServer/getGameInfoRequest", output = "http://example/GameOntologyServer/getGameInfoResponse")
    public List<String> getGameInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        boolean arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listGamesByType", targetNamespace = "http://example/", className = "mypackage.ListGamesByType")
    @ResponseWrapper(localName = "listGamesByTypeResponse", targetNamespace = "http://example/", className = "mypackage.ListGamesByTypeResponse")
    @Action(input = "http://example/GameOntologyServer/listGamesByTypeRequest", output = "http://example/GameOntologyServer/listGamesByTypeResponse")
    public List<String> listGamesByType(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1);

    /**
     * 
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getFranchiseInfo", targetNamespace = "http://example/", className = "mypackage.GetFranchiseInfo")
    @ResponseWrapper(localName = "getFranchiseInfoResponse", targetNamespace = "http://example/", className = "mypackage.GetFranchiseInfoResponse")
    @Action(input = "http://example/GameOntologyServer/getFranchiseInfoRequest", output = "http://example/GameOntologyServer/getFranchiseInfoResponse")
    public List<String> getFranchiseInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        boolean arg1);

    /**
     * 
     * @param arg2
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getCompanyInfo", targetNamespace = "http://example/", className = "mypackage.GetCompanyInfo")
    @ResponseWrapper(localName = "getCompanyInfoResponse", targetNamespace = "http://example/", className = "mypackage.GetCompanyInfoResponse")
    @Action(input = "http://example/GameOntologyServer/getCompanyInfoRequest", output = "http://example/GameOntologyServer/getCompanyInfoResponse")
    public List<String> getCompanyInfo(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        boolean arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        String arg2);

    /**
     * 
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHelloWorldFromNoob", targetNamespace = "http://example/", className = "mypackage.SayHelloWorldFromNoob")
    @ResponseWrapper(localName = "sayHelloWorldFromNoobResponse", targetNamespace = "http://example/", className = "mypackage.SayHelloWorldFromNoobResponse")
    @Action(input = "http://example/GameOntologyServer/sayHelloWorldFromNoobRequest", output = "http://example/GameOntologyServer/sayHelloWorldFromNoobResponse")
    public String sayHelloWorldFromNoob();

    /**
     * 
     * @param arg3
     * @param arg2
     * @param arg4
     * @param arg1
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "listClassByProperty", targetNamespace = "http://example/", className = "mypackage.ListClassByProperty")
    @ResponseWrapper(localName = "listClassByPropertyResponse", targetNamespace = "http://example/", className = "mypackage.ListClassByPropertyResponse")
    @Action(input = "http://example/GameOntologyServer/listClassByPropertyRequest", output = "http://example/GameOntologyServer/listClassByPropertyResponse")
    public List<String> listClassByProperty(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        String arg1,
        @WebParam(name = "arg2", targetNamespace = "")
        boolean arg2,
        @WebParam(name = "arg3", targetNamespace = "")
        int arg3,
        @WebParam(name = "arg4", targetNamespace = "")
        int arg4);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "sayHelloWorldFrom", targetNamespace = "http://example/", className = "mypackage.SayHelloWorldFrom")
    @ResponseWrapper(localName = "sayHelloWorldFromResponse", targetNamespace = "http://example/", className = "mypackage.SayHelloWorldFromResponse")
    @Action(input = "http://example/GameOntologyServer/sayHelloWorldFromRequest", output = "http://example/GameOntologyServer/sayHelloWorldFromResponse")
    public String sayHelloWorldFrom(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

    /**
     * 
     * @param arg0
     * @return
     *     returns java.util.List<java.lang.String>
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getGamesFromPlatform", targetNamespace = "http://example/", className = "mypackage.GetGamesFromPlatform")
    @ResponseWrapper(localName = "getGamesFromPlatformResponse", targetNamespace = "http://example/", className = "mypackage.GetGamesFromPlatformResponse")
    @Action(input = "http://example/GameOntologyServer/getGamesFromPlatformRequest", output = "http://example/GameOntologyServer/getGamesFromPlatformResponse")
    public List<String> getGamesFromPlatform(
        @WebParam(name = "arg0", targetNamespace = "")
        String arg0);

}
