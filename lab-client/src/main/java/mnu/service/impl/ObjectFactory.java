
package mnu.service.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the mnu.service.impl package. 
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

    private final static QName _CreateResponse_QNAME = new QName("http://impl.service.mnu/", "createResponse");
    private final static QName _FindByGenderAndBirthdayResponse_QNAME = new QName("http://impl.service.mnu/", "findByGenderAndBirthdayResponse");
    private final static QName _FindByGenderResponse_QNAME = new QName("http://impl.service.mnu/", "findByGenderResponse");
    private final static QName _FindByName_QNAME = new QName("http://impl.service.mnu/", "findByName");
    private final static QName _FindByBirthday_QNAME = new QName("http://impl.service.mnu/", "findByBirthday");
    private final static QName _MySQLException_QNAME = new QName("http://impl.service.mnu/", "MySQLException");
    private final static QName _FindByGenderAndBirthday_QNAME = new QName("http://impl.service.mnu/", "findByGenderAndBirthday");
    private final static QName _FindByFullInfoResponse_QNAME = new QName("http://impl.service.mnu/", "findByFullInfoResponse");
    private final static QName _UpdateResponse_QNAME = new QName("http://impl.service.mnu/", "updateResponse");
    private final static QName _FindByGender_QNAME = new QName("http://impl.service.mnu/", "findByGender");
    private final static QName _FindByGenderAndSalaryResponse_QNAME = new QName("http://impl.service.mnu/", "findByGenderAndSalaryResponse");
    private final static QName _FindByNameAndGender_QNAME = new QName("http://impl.service.mnu/", "findByNameAndGender");
    private final static QName _FindByIdResponse_QNAME = new QName("http://impl.service.mnu/", "findByIdResponse");
    private final static QName _FindByFullName_QNAME = new QName("http://impl.service.mnu/", "findByFullName");
    private final static QName _FindBySalary_QNAME = new QName("http://impl.service.mnu/", "findBySalary");
    private final static QName _Delete_QNAME = new QName("http://impl.service.mnu/", "delete");
    private final static QName _FindAll_QNAME = new QName("http://impl.service.mnu/", "findAll");
    private final static QName _InvalidIdException_QNAME = new QName("http://impl.service.mnu/", "InvalidIdException");
    private final static QName _FindByFullNameResponse_QNAME = new QName("http://impl.service.mnu/", "findByFullNameResponse");
    private final static QName _FindByGenderAndSalary_QNAME = new QName("http://impl.service.mnu/", "findByGenderAndSalary");
    private final static QName _Update_QNAME = new QName("http://impl.service.mnu/", "update");
    private final static QName _FindByNameAndGenderResponse_QNAME = new QName("http://impl.service.mnu/", "findByNameAndGenderResponse");
    private final static QName _FindBySalaryResponse_QNAME = new QName("http://impl.service.mnu/", "findBySalaryResponse");
    private final static QName _FindBySurnameResponse_QNAME = new QName("http://impl.service.mnu/", "findBySurnameResponse");
    private final static QName _Create_QNAME = new QName("http://impl.service.mnu/", "create");
    private final static QName _FindAllResponse_QNAME = new QName("http://impl.service.mnu/", "findAllResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://impl.service.mnu/", "deleteResponse");
    private final static QName _FindByNameResponse_QNAME = new QName("http://impl.service.mnu/", "findByNameResponse");
    private final static QName _FindBySurname_QNAME = new QName("http://impl.service.mnu/", "findBySurname");
    private final static QName _FindByFullInfo_QNAME = new QName("http://impl.service.mnu/", "findByFullInfo");
    private final static QName _FindById_QNAME = new QName("http://impl.service.mnu/", "findById");
    private final static QName _InvalidParameterException_QNAME = new QName("http://impl.service.mnu/", "InvalidParameterException");
    private final static QName _FindByBirthdayResponse_QNAME = new QName("http://impl.service.mnu/", "findByBirthdayResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: mnu.service.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FindBySurnameResponse }
     * 
     */
    public FindBySurnameResponse createFindBySurnameResponse() {
        return new FindBySurnameResponse();
    }

    /**
     * Create an instance of {@link FindByNameAndGenderResponse }
     * 
     */
    public FindByNameAndGenderResponse createFindByNameAndGenderResponse() {
        return new FindByNameAndGenderResponse();
    }

    /**
     * Create an instance of {@link FindBySalaryResponse }
     * 
     */
    public FindBySalaryResponse createFindBySalaryResponse() {
        return new FindBySalaryResponse();
    }

    /**
     * Create an instance of {@link FindByGenderAndSalary }
     * 
     */
    public FindByGenderAndSalary createFindByGenderAndSalary() {
        return new FindByGenderAndSalary();
    }

    /**
     * Create an instance of {@link Update }
     * 
     */
    public Update createUpdate() {
        return new Update();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link FindAll }
     * 
     */
    public FindAll createFindAll() {
        return new FindAll();
    }

    /**
     * Create an instance of {@link EmployeeServiceFault }
     * 
     */
    public EmployeeServiceFault createEmployeeServiceFault() {
        return new EmployeeServiceFault();
    }

    /**
     * Create an instance of {@link FindByFullNameResponse }
     * 
     */
    public FindByFullNameResponse createFindByFullNameResponse() {
        return new FindByFullNameResponse();
    }

    /**
     * Create an instance of {@link FindByBirthdayResponse }
     * 
     */
    public FindByBirthdayResponse createFindByBirthdayResponse() {
        return new FindByBirthdayResponse();
    }

    /**
     * Create an instance of {@link FindBySurname }
     * 
     */
    public FindBySurname createFindBySurname() {
        return new FindBySurname();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
    }

    /**
     * Create an instance of {@link FindByNameResponse }
     * 
     */
    public FindByNameResponse createFindByNameResponse() {
        return new FindByNameResponse();
    }

    /**
     * Create an instance of {@link FindByFullInfo }
     * 
     */
    public FindByFullInfo createFindByFullInfo() {
        return new FindByFullInfo();
    }

    /**
     * Create an instance of {@link FindById }
     * 
     */
    public FindById createFindById() {
        return new FindById();
    }

    /**
     * Create an instance of {@link Create }
     * 
     */
    public Create createCreate() {
        return new Create();
    }

    /**
     * Create an instance of {@link FindAllResponse }
     * 
     */
    public FindAllResponse createFindAllResponse() {
        return new FindAllResponse();
    }

    /**
     * Create an instance of {@link FindByGenderAndBirthday }
     * 
     */
    public FindByGenderAndBirthday createFindByGenderAndBirthday() {
        return new FindByGenderAndBirthday();
    }

    /**
     * Create an instance of {@link CreateResponse }
     * 
     */
    public CreateResponse createCreateResponse() {
        return new CreateResponse();
    }

    /**
     * Create an instance of {@link FindByGenderAndBirthdayResponse }
     * 
     */
    public FindByGenderAndBirthdayResponse createFindByGenderAndBirthdayResponse() {
        return new FindByGenderAndBirthdayResponse();
    }

    /**
     * Create an instance of {@link FindByGenderResponse }
     * 
     */
    public FindByGenderResponse createFindByGenderResponse() {
        return new FindByGenderResponse();
    }

    /**
     * Create an instance of {@link FindByName }
     * 
     */
    public FindByName createFindByName() {
        return new FindByName();
    }

    /**
     * Create an instance of {@link FindByBirthday }
     * 
     */
    public FindByBirthday createFindByBirthday() {
        return new FindByBirthday();
    }

    /**
     * Create an instance of {@link FindBySalary }
     * 
     */
    public FindBySalary createFindBySalary() {
        return new FindBySalary();
    }

    /**
     * Create an instance of {@link FindByFullName }
     * 
     */
    public FindByFullName createFindByFullName() {
        return new FindByFullName();
    }

    /**
     * Create an instance of {@link FindByIdResponse }
     * 
     */
    public FindByIdResponse createFindByIdResponse() {
        return new FindByIdResponse();
    }

    /**
     * Create an instance of {@link FindByGender }
     * 
     */
    public FindByGender createFindByGender() {
        return new FindByGender();
    }

    /**
     * Create an instance of {@link FindByGenderAndSalaryResponse }
     * 
     */
    public FindByGenderAndSalaryResponse createFindByGenderAndSalaryResponse() {
        return new FindByGenderAndSalaryResponse();
    }

    /**
     * Create an instance of {@link FindByNameAndGender }
     * 
     */
    public FindByNameAndGender createFindByNameAndGender() {
        return new FindByNameAndGender();
    }

    /**
     * Create an instance of {@link FindByFullInfoResponse }
     * 
     */
    public FindByFullInfoResponse createFindByFullInfoResponse() {
        return new FindByFullInfoResponse();
    }

    /**
     * Create an instance of {@link UpdateResponse }
     * 
     */
    public UpdateResponse createUpdateResponse() {
        return new UpdateResponse();
    }

    /**
     * Create an instance of {@link Employee }
     * 
     */
    public Employee createEmployee() {
        return new Employee();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CreateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "createResponse")
    public JAXBElement<CreateResponse> createCreateResponse(CreateResponse value) {
        return new JAXBElement<CreateResponse>(_CreateResponse_QNAME, CreateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByGenderAndBirthdayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByGenderAndBirthdayResponse")
    public JAXBElement<FindByGenderAndBirthdayResponse> createFindByGenderAndBirthdayResponse(FindByGenderAndBirthdayResponse value) {
        return new JAXBElement<FindByGenderAndBirthdayResponse>(_FindByGenderAndBirthdayResponse_QNAME, FindByGenderAndBirthdayResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByGenderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByGenderResponse")
    public JAXBElement<FindByGenderResponse> createFindByGenderResponse(FindByGenderResponse value) {
        return new JAXBElement<FindByGenderResponse>(_FindByGenderResponse_QNAME, FindByGenderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByName")
    public JAXBElement<FindByName> createFindByName(FindByName value) {
        return new JAXBElement<FindByName>(_FindByName_QNAME, FindByName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByBirthday }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByBirthday")
    public JAXBElement<FindByBirthday> createFindByBirthday(FindByBirthday value) {
        return new JAXBElement<FindByBirthday>(_FindByBirthday_QNAME, FindByBirthday.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "MySQLException")
    public JAXBElement<EmployeeServiceFault> createMySQLException(EmployeeServiceFault value) {
        return new JAXBElement<EmployeeServiceFault>(_MySQLException_QNAME, EmployeeServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByGenderAndBirthday }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByGenderAndBirthday")
    public JAXBElement<FindByGenderAndBirthday> createFindByGenderAndBirthday(FindByGenderAndBirthday value) {
        return new JAXBElement<FindByGenderAndBirthday>(_FindByGenderAndBirthday_QNAME, FindByGenderAndBirthday.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByFullInfoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByFullInfoResponse")
    public JAXBElement<FindByFullInfoResponse> createFindByFullInfoResponse(FindByFullInfoResponse value) {
        return new JAXBElement<FindByFullInfoResponse>(_FindByFullInfoResponse_QNAME, FindByFullInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "updateResponse")
    public JAXBElement<UpdateResponse> createUpdateResponse(UpdateResponse value) {
        return new JAXBElement<UpdateResponse>(_UpdateResponse_QNAME, UpdateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByGender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByGender")
    public JAXBElement<FindByGender> createFindByGender(FindByGender value) {
        return new JAXBElement<FindByGender>(_FindByGender_QNAME, FindByGender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByGenderAndSalaryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByGenderAndSalaryResponse")
    public JAXBElement<FindByGenderAndSalaryResponse> createFindByGenderAndSalaryResponse(FindByGenderAndSalaryResponse value) {
        return new JAXBElement<FindByGenderAndSalaryResponse>(_FindByGenderAndSalaryResponse_QNAME, FindByGenderAndSalaryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameAndGender }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByNameAndGender")
    public JAXBElement<FindByNameAndGender> createFindByNameAndGender(FindByNameAndGender value) {
        return new JAXBElement<FindByNameAndGender>(_FindByNameAndGender_QNAME, FindByNameAndGender.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByIdResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByIdResponse")
    public JAXBElement<FindByIdResponse> createFindByIdResponse(FindByIdResponse value) {
        return new JAXBElement<FindByIdResponse>(_FindByIdResponse_QNAME, FindByIdResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByFullName }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByFullName")
    public JAXBElement<FindByFullName> createFindByFullName(FindByFullName value) {
        return new JAXBElement<FindByFullName>(_FindByFullName_QNAME, FindByFullName.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBySalary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findBySalary")
    public JAXBElement<FindBySalary> createFindBySalary(FindBySalary value) {
        return new JAXBElement<FindBySalary>(_FindBySalary_QNAME, FindBySalary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAll }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findAll")
    public JAXBElement<FindAll> createFindAll(FindAll value) {
        return new JAXBElement<FindAll>(_FindAll_QNAME, FindAll.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "InvalidIdException")
    public JAXBElement<EmployeeServiceFault> createInvalidIdException(EmployeeServiceFault value) {
        return new JAXBElement<EmployeeServiceFault>(_InvalidIdException_QNAME, EmployeeServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByFullNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByFullNameResponse")
    public JAXBElement<FindByFullNameResponse> createFindByFullNameResponse(FindByFullNameResponse value) {
        return new JAXBElement<FindByFullNameResponse>(_FindByFullNameResponse_QNAME, FindByFullNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByGenderAndSalary }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByGenderAndSalary")
    public JAXBElement<FindByGenderAndSalary> createFindByGenderAndSalary(FindByGenderAndSalary value) {
        return new JAXBElement<FindByGenderAndSalary>(_FindByGenderAndSalary_QNAME, FindByGenderAndSalary.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Update }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "update")
    public JAXBElement<Update> createUpdate(Update value) {
        return new JAXBElement<Update>(_Update_QNAME, Update.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameAndGenderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByNameAndGenderResponse")
    public JAXBElement<FindByNameAndGenderResponse> createFindByNameAndGenderResponse(FindByNameAndGenderResponse value) {
        return new JAXBElement<FindByNameAndGenderResponse>(_FindByNameAndGenderResponse_QNAME, FindByNameAndGenderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBySalaryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findBySalaryResponse")
    public JAXBElement<FindBySalaryResponse> createFindBySalaryResponse(FindBySalaryResponse value) {
        return new JAXBElement<FindBySalaryResponse>(_FindBySalaryResponse_QNAME, FindBySalaryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBySurnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findBySurnameResponse")
    public JAXBElement<FindBySurnameResponse> createFindBySurnameResponse(FindBySurnameResponse value) {
        return new JAXBElement<FindBySurnameResponse>(_FindBySurnameResponse_QNAME, FindBySurnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Create }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "create")
    public JAXBElement<Create> createCreate(Create value) {
        return new JAXBElement<Create>(_Create_QNAME, Create.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findAllResponse")
    public JAXBElement<FindAllResponse> createFindAllResponse(FindAllResponse value) {
        return new JAXBElement<FindAllResponse>(_FindAllResponse_QNAME, FindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByNameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByNameResponse")
    public JAXBElement<FindByNameResponse> createFindByNameResponse(FindByNameResponse value) {
        return new JAXBElement<FindByNameResponse>(_FindByNameResponse_QNAME, FindByNameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindBySurname }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findBySurname")
    public JAXBElement<FindBySurname> createFindBySurname(FindBySurname value) {
        return new JAXBElement<FindBySurname>(_FindBySurname_QNAME, FindBySurname.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByFullInfo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByFullInfo")
    public JAXBElement<FindByFullInfo> createFindByFullInfo(FindByFullInfo value) {
        return new JAXBElement<FindByFullInfo>(_FindByFullInfo_QNAME, FindByFullInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindById }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findById")
    public JAXBElement<FindById> createFindById(FindById value) {
        return new JAXBElement<FindById>(_FindById_QNAME, FindById.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EmployeeServiceFault }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "InvalidParameterException")
    public JAXBElement<EmployeeServiceFault> createInvalidParameterException(EmployeeServiceFault value) {
        return new JAXBElement<EmployeeServiceFault>(_InvalidParameterException_QNAME, EmployeeServiceFault.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FindByBirthdayResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.mnu/", name = "findByBirthdayResponse")
    public JAXBElement<FindByBirthdayResponse> createFindByBirthdayResponse(FindByBirthdayResponse value) {
        return new JAXBElement<FindByBirthdayResponse>(_FindByBirthdayResponse_QNAME, FindByBirthdayResponse.class, null, value);
    }

}
